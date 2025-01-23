import java.util.*;

class Student {
    String id, name;
    Map<String, Double> grades = new HashMap<>();

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addGrade(String course, double grade) {
        grades.put(course, grade);
    }

    public double calculateGPA() {
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return total / grades.size();
    }
}

class GradeManagementSystem {
    List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void assignGrade(String studentId, String course, double grade) {
        for (Student student : students) {
            if (student.id.equals(studentId)) {
                student.addGrade(course, grade);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void calculateAndPrintGPA(String studentId) {
        for (Student student : students) {
            if (student.id.equals(studentId)) {
                System.out.println("GPA: " + student.calculateGPA());
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
