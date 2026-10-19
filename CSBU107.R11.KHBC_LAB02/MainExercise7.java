class UITStudent {
    private String studentId;
    private String fullName;
    private String major;
    private double gpa;

    public UITStudent() {
        this("N/A", "Unknown", "General", 0.0);
    }

    public UITStudent(String studentId, String fullName) {
        this(studentId, fullName, "Software Engineering", 0.0);
    }

    public UITStudent(String studentId, String fullName, String major, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.major = major;
        this.gpa = (gpa >= 0.0 && gpa <= 10.0) ? gpa : 0.0;
    }

    public boolean isPassed() {
        return gpa >= 5.0;
    }

    public String academicClassification() {
        if (gpa >= 8.5) return "Excellent";
        if (gpa >= 7.0) return "Good";
        if (gpa >= 5.0) return "Average";
        return "Weak";
    }

    public void displayInfo() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + fullName);
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
        System.out.println("Passed: " + isPassed());
        System.out.println("Classification: " + academicClassification());
        System.out.println("----------------------------------------");
    }
}

public class MainExercise7 {
    public static void main(String[] args) {
        UITStudent s1 = new UITStudent();
        UITStudent s2 = new UITStudent("25560001", "Nguyen Van A");
        UITStudent s3 = new UITStudent("25560002", "Tran Thi B", "Data Science", 8.8);
        UITStudent s4 = new UITStudent("25560003", "Le Van C", "Computer Science", 4.2);
        UITStudent s5 = new UITStudent("25560004", "Le Thi D", "Information Security", 7.3);

        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();
        s4.displayInfo();
        s5.displayInfo();
    }
}