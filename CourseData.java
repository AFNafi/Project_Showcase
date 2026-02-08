public class CourseData {
    /**
     * 2D array storing course codes for all 8 semesters
     */
    public static final String[][] COURSE_NAMES = {
            // Semester 1 - Actual CSE courses (YOU CAN EDIT THESE)
            {"PHY-111", "PHY-112", "CHE-111", "CHE-112", "MAT-111", "EEE-111", "EEE-112", "CIT-111", "CIT-112", "CCE-112"},
            // Semester 2 (EDIT: Replace with actual course names)
            {"PHY-121", "PHY-122", "MAT-121", "CIT-121", "LCM-121", "EEE-121", "EEE-122", "CCE-121","CCE-122"},
            // Semester 3 (EDIT: Replace with actual course names)
            {"CIT-211","CIT-212","CIT-213","CCE-211","MAT-211","EEE-211","EEE-212","AIS-211"},
            // Semester 4 (EDIT: Replace with actual course names)
            {"CCE-211", "CCE-222", "CCE-223", "CCE-244", "AES-221", "MAT-221", "CIT-220", "CIT-221","CIT-222"},
            // Semester 5 (EDIT: Replace with actual course names)
            {"CIT-311", "CIT-312", "CIT-313", "CIT-315", "CIT-316", "CCE-310", "CCE-311","CCE-312","CCE-313","CCE-314"},
            // Semester 6 (EDIT: Replace with actual course names)
            {"CIT-320", "CIT-321", "CIT-322", "CIT-323", "CIT-324", "EEE-321", "EEE-322","CCE-321","CCE-322","CCE-323"},
            // Semester 7 (EDIT: Replace with actual course names)
            {"CSE-410", "CSE-421", "CCE-411", "CCE-413", "CCE-415", "CCE-416","CCE-417","CIT-411","CIT-412"},
            // Semester 8 (EDIT: Replace with actual course names)
            {"CSE-420", "CSE-421", "CCE-421", "CCE-423", "CIT-421","CIT-422","CIT-433"}
    };

    /**
     * 2D array storing credit hours for each course in all 8 semesters
     */
    public static final double[][] SEMESTER_CREDITS = {
            // Semester 1 - Actual credits (YOU CAN EDIT THESE)
            {3.0, 0.75, 3.0, 0.75, 3.0, 3.0, 1.5, 3.0, 1.5, 0.75},
            // Semester 2 (EDIT: Replace with actual credits)
            {3.0, .75, 3.0, 3.0, 2.0, 3, 1.5, 3.0, 1.5},
            // Semester 3 (EDIT: Replace with actual credits)
            {3.0, 1.5, 3.0, 3.0, 3.0, 3.0, 1.5, 3.0},
            // Semester 4 (EDIT: Replace with actual credits)
            {3.0, 1.5, 3.0, 1.5, 3.0, 3, 1.5, 3.0, 1.5},
            // Semester 5 (EDIT: Replace with actual credits)
            {3.0, 1.5, 3.0, 3.0, 1.5, 1.5, 3.0, 0.75, 3, 1.5},
            // Semester 6 (EDIT: Replace with actual credits)
            {1.5, 3.0, 1.5, 3.0, 1.5, 3, .75, 3, 1.5, 3},
            // Semester 7 (EDIT: Replace with actual credits)
            {3.0, 1.0, 3.0, 3.0, 3.0, 1.5, 3, 3, 1.5},
            // Semester 8 (EDIT: Replace with actual credits)
            {3.0, .75, 3.0, 3.0, 3.0, .75, 3}
    };
}