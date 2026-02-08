import java.util.ArrayList;
import java.util.List;

/**
 * Holds courses for a single semester and computes semester totals / GPA.
 */
public class Semester {
    private int semesterNumber;
    private List<Course> courses;
    private double totalCredits;
    private double totalGradePoints;

    public Semester(int semesterNumber) {
        this.semesterNumber = semesterNumber;
        this.courses = new ArrayList<>();
        initializeCourses();
        calculateTotals();
    }

    private void initializeCourses() {
        // create Course objects using CourseData for this semester
        String[] courseCodes = CourseData.COURSE_NAMES[semesterNumber - 1];
        double[] credits = CourseData.SEMESTER_CREDITS[semesterNumber - 1];

        for (int i = 0; i < courseCodes.length; i++) {
            courses.add(new Course(courseCodes[i], credits[i]));
        }
    }

    public void setCourseMarks(double[] marks) {
        // assign marks to courses and update totals
        for (int i = 0; i < courses.size() && i < marks.length; i++) {
            courses.get(i).setMarks(marks[i]);
        }
        calculateTotals();
    }

    private void calculateTotals() {
        // recompute aggregated credits and grade points for the semester
        totalCredits = 0;
        totalGradePoints = 0;

        for (Course course : courses) {
            totalCredits += course.getCreditHours();
            totalGradePoints += course.getGradePoints();
        }
    }

    public double getGPA() {
        return totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
    }

    // Getters
    public int getSemesterNumber() { return semesterNumber; }
    public List<Course> getCourses() { return courses; }
    public double getTotalCredits() { return totalCredits; }
    public double getTotalGradePoints() { return totalGradePoints; }
}