// src/Student.java
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a student composed of multiple semesters and provides overall CGPA.
 */
public class Student {
    private List<Semester> semesters;
    private double totalCredits;
    private double totalGradePoints;

    public Student() {
        this.semesters = new ArrayList<>();
    }

    public void addSemester(Semester semester) {
        semesters.add(semester);
        calculateOverallTotals();
    }

    private void calculateOverallTotals() {
        totalCredits = 0;
        totalGradePoints = 0;

        for (Semester semester : semesters) {
            totalCredits += semester.getTotalCredits();
            totalGradePoints += semester.getTotalGradePoints();
        }
    }

    public double getCGPA() {
        return totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
    }

    public String getCGPAInterpretation() {
        double cgpa = getCGPA();

        // return a short human-friendly interpretation of CGPA
        if (cgpa >= 3.75) return "⭐ Excellent Performance!";
        else if (cgpa >= 3.50) return "👍 Very Good Performance";
        else if (cgpa >= 3.25) return "✅ Good Performance";
        else if (cgpa >= 3.00) return "📚 Satisfactory Performance";
        else if (cgpa >= 2.00) return "⚠️  Needs Improvement";
        else return "❌ Academic Probation";
    }

    // Getters
    public List<Semester> getSemesters() { return semesters; }
    public double getTotalCredits() { return totalCredits; }
    public double getTotalGradePoints() { return totalGradePoints; }
}
