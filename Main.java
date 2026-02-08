public class Main {
    public static void main(String[] args) {
        // Step 1: Show welcome message
        UserInterface.displayWelcomeMessage();

        // Step 2: Ask user how many semesters they've completed
        int completedSemesters = UserInterface.getCompletedSemesters();

        // Step 3: Collect marks for all courses in completed semesters
        double[][] marks = UserInterface.collectMarks(completedSemesters);

        // Step 4: Create student and semesters with marks
        Student student = new Student();
        for (int i = 0; i < completedSemesters; i++) {
            Semester semester = new Semester(i + 1);
            semester.setCourseMarks(marks[i]);
            student.addSemester(semester);
        }

        // Step 5: Calculate and display results
        UserInterface.displayResults(student);

        // Step 6: Close scanner
        UserInterface.closeScanner();
    }
}