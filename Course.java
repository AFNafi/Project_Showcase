/**
 * Represents a single course: code, credit hours, marks and computed grade info.
 */
public class Course {
    private String courseCode;
    private double creditHours;
    private double marks;
    private double gradePoint;
    private String letterGrade;

    public Course(String courseCode, double creditHours) {
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        calculateGrade();
    }

    private void calculateGrade() {
        // derive grade point and letter grade from numeric marks
        this.gradePoint = GradeCalculator.calculateGradePoint(marks);
        this.letterGrade = GradeCalculator.getLetterGrade(marks);
    }

    // Getters
    public String getCourseCode() { return courseCode; }
    public double getCreditHours() { return creditHours; }
    public double getMarks() { return marks; }
    public double getGradePoint() { return gradePoint; }
    public String getLetterGrade() { return letterGrade; }
    public double getGradePoints() { return creditHours * gradePoint; }
}