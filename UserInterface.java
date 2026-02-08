import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayWelcomeMessage() {
        System.out.println("=========================================");
        System.out.println("      CSE DEPARTMENT CGPA CALCULATOR     ");
        System.out.println("=========================================");
        System.out.println();
    }

    public static int getCompletedSemesters() {
        int semesters = 0;

        while (true) {
            System.out.print("Enter number of semesters completed (1-8): ");
            try {
                semesters = scanner.nextInt();
                if (semesters >= 1 && semesters <= 8) {
                    break;
                } else {
                    System.out.println("❌ Please enter a number between 1 and 8.");
                }
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return semesters;
    }

    public static double[][] collectMarks(int completedSemesters) {
        double[][] marks = new double[completedSemesters][];

        System.out.println("\nENTER MARKS FOR EACH COURSE:");
        System.out.println("=============================");
        System.out.println("Note: Enter marks out of 100");
        System.out.println("=============================");

        for (int semester = 0; semester < completedSemesters; semester++) {
            int coursesInSemester = CourseData.SEMESTER_CREDITS[semester].length;
            marks[semester] = new double[coursesInSemester];

            System.out.println("\n📚 SEMESTER " + (semester + 1) + " (" + coursesInSemester + " courses):");
            System.out.println("----------------------------------------");

            for (int course = 0; course < coursesInSemester; course++) {
                while (true) {
                    System.out.printf("Enter marks for %s (%.2f credits): ",
                            CourseData.COURSE_NAMES[semester][course],
                            CourseData.SEMESTER_CREDITS[semester][course]);

                    try {
                        double mark = scanner.nextDouble();
                        if (mark >= 0 && mark <= 100) {
                            marks[semester][course] = mark;
                            break;
                        } else {
                            System.out.println("❌ Marks should be between 0 and 100.");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Invalid input! Please enter a valid number.");
                        scanner.nextLine();
                    }
                }
            }
        }
        return marks;
    }

    public static void displayResults(Student student) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                           FINAL RESULTS");
        System.out.println("=".repeat(70));

        for (Semester semester : student.getSemesters()) {
            System.out.println("\n🎓 SEMESTER " + semester.getSemesterNumber() + " DETAILS:");
            System.out.println("-".repeat(60));
            System.out.printf("%-12s %-8s %-8s %-8s %-12s\n",
                    "COURSE", "CREDITS", "MARKS", "GRADE", "GRADE POINT");
            System.out.println("-".repeat(60));

            for (Course course : semester.getCourses()) {
                System.out.printf("%-12s %-8.2f %-8.2f %-8s %-12.2f\n",
                        course.getCourseCode(), course.getCreditHours(),
                        course.getMarks(), course.getLetterGrade(), course.getGradePoint());
            }

            System.out.println("-".repeat(60));
            System.out.printf("📊 SEMESTER %d GPA: %.2f\n", semester.getSemesterNumber(), semester.getGPA());
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.println("                     OVERALL SUMMARY");
        System.out.println("=".repeat(70));
        System.out.printf("Total Semesters Completed: %d\n", student.getSemesters().size());
        System.out.printf("Total Credits Completed: %.2f\n", student.getTotalCredits());
        System.out.printf("OVERALL CGPA: %.2f\n", student.getCGPA());
        System.out.println("\nCGPA Interpretation:");
        System.out.println(student.getCGPAInterpretation());
        System.out.println("=".repeat(70));
    }

    public static void closeScanner() {
        scanner.close();
    }
}