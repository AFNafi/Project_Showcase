/**
 * Utility for converting numeric marks to grade points and letter grades.
 */
public class GradeCalculator {

    /**
     * CALCULATE GRADE POINT FROM MARKS
     * Converts numerical marks (0-100) to grade points (0-4.00)
     */
    public static double calculateGradePoint(double marks) {
        if (marks >= 80) return 4.00;
        else if (marks >= 75) return 3.75;
        else if (marks >= 70) return 3.50;
        else if (marks >= 65) return 3.25;
        else if (marks >= 60) return 3.00;
        else if (marks >= 55) return 2.75;
        else if (marks >= 50) return 2.50;
        else if (marks >= 45) return 2.25;
        else if (marks >= 40) return 2.00;
        else return 0.00;
    }

    /**
     * GET LETTER GRADE FROM MARKS
     * Converts numerical marks to letter grades (A+, A, A-, etc.)
     */
    public static String getLetterGrade(double marks) {
        if (marks >= 80) return "A+";
        else if (marks >= 75) return "A";
        else if (marks >= 70) return "A-";
        else if (marks >= 65) return "B+";
        else if (marks >= 60) return "B";
        else if (marks >= 55) return "B-";
        else if (marks >= 50) return "C+";
        else if (marks >= 45) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }
}