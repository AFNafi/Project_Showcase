#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <termios.h>
#include <time.h>

#define WIDTH 70
#define HEIGHT 40
#define Plane 'A'
#define OBSTACLE_CHAR '*'
#define ROAD_CHAR '|'
#define EMPTY_CHAR ' '
int lives = 3; 

int car_pos = WIDTH / 2;
int score = 0;
char road[HEIGHT][WIDTH];

struct termios orig_termios;
void disableRawMode() {
    tcsetattr(STDIN_FILENO, TCSAFLUSH, &orig_termios);
}

void enableRawMode() {
    tcgetattr(STDIN_FILENO, &orig_termios);
    atexit(disableRawMode);

    struct termios raw = orig_termios;
    raw.c_lflag &= ~(ICANON | ECHO);
    tcsetattr(STDIN_FILENO, TCSAFLUSH, &raw);
}

int kbhit() {
    struct timeval tv = {0L, 0L};
    fd_set fds;
    FD_ZERO(&fds);
    FD_SET(STDIN_FILENO, &fds);
    return select(STDIN_FILENO + 1, &fds, NULL, NULL, &tv);
}

void initRoad() {
    for (int i = 0; i < HEIGHT; i++)
        for (int j = 0; j < WIDTH; j++)
            road[i][j] = (j == 0 || j == WIDTH - 1) ? ROAD_CHAR : EMPTY_CHAR;
}

void drawRoad() {
    system("clear");
    for (int i = 0; i < HEIGHT - 1; i++) {
        for (int j = 0; j < WIDTH; j++) {
            printf("%c", road[i][j]);
        }
        printf("\n");
    }

    for (int j = 0; j < WIDTH; j++) {
        if (j == car_pos)
            printf("%c", Plane);
        else if (j == 0 || j == WIDTH - 1)
            printf("%c", ROAD_CHAR);
        else
            printf("%c", EMPTY_CHAR);
    }
    printf("\nScore: %d | Lives: %d\n", score, lives);
}

void scrollRoad() {
    for (int i = HEIGHT - 2; i > 0; i--)
        for (int j = 1; j < WIDTH - 1; j++)
            road[i][j] = road[i - 1][j];

    // Random obstacle in top row
    for (int j = 1; j < WIDTH - 1; j++)
        road[0][j] = (rand() % 100 == 0) ? OBSTACLE_CHAR : EMPTY_CHAR;
}

int checkCollision() {
    return road[HEIGHT - 2][car_pos] == OBSTACLE_CHAR;
}

int main() {
    srand(time(NULL));
    enableRawMode();
    initRoad();

    int frame_delay = 200000;      // Start slower (200 ms)
    const int min_delay = 60000;   // Minimum speed cap (60 ms)

    while (1) {
        if (kbhit()) {
            char ch = getchar();
            if (ch == 'a' && car_pos > 1)
                car_pos--;
            else if (ch == 'd' && car_pos < WIDTH - 2)
                car_pos++;
            else if (ch == 'q')
                break;
        }

        scrollRoad();
if (checkCollision()) {
    lives--;
    if (lives <= 0) {
        drawRoad();
        printf("💥 Crash! Game Over.\nFinal Score: %d\n", score);
        break;
    } else {
        // Clear current obstacle
        road[HEIGHT - 2][car_pos] = EMPTY_CHAR;
        printf("💥 You crashed! Lives left: %d\n", lives);
        usleep(1000000); // Pause 1 second after hit
    }
}

        drawRoad();
        score++;

        // Increase speed every 5 points
        if (score % 5 == 0 && frame_delay > min_delay) {
            frame_delay -= 10000;  // Speed up by 5 ms
        }

        usleep(frame_delay);
    }

    disableRawMode();
    return 0;
}