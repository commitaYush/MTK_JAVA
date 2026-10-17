
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int rollNumber;
    private String name;
    private String course;
    private double marks;

    // Constructor
    public Student(int rollNumber, String name, String course, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void updateDetails(String name, String course, double marks) {
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("-------------------------");
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        updateStudent();
                        break;
                    case 5:
                        deleteStudent();
                        break;
                    case 6:
                        System.out.println("Thank you for using the system!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }

        } while (choice != 6);

        sc.close();
    }

    // Add Student
    static void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            if (findStudent(roll) != null) {
                System.out.println("Roll number already exists!");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks (0-100): ");
            double marks = sc.nextDouble();
            sc.nextLine();

            if (roll <= 0 || name.trim().isEmpty()
                    || course.trim().isEmpty()
                    || marks < 0 || marks > 100) {
                System.out.println("Invalid student details!");
                return;
            }

            students.add(new Student(roll, name, course, marks));
            System.out.println("Student added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input! Please try again.");
            sc.nextLine();
        }
    }

    // View All Students
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        for (Student student : students) {
            student.display();
        }
    }

    // Search Student
    static void searchStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            Student student = findStudent(roll);

            if (student != null) {
                student.display();
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("Invalid roll number!");
            sc.nextLine();
        }
    }

    // Update Student
    static void updateStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            Student student = findStudent(roll);

            if (student == null) {
                System.out.println("Student not found!");
                return;
            }

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Course: ");
            String course = sc.nextLine();

            System.out.print("Enter New Marks (0-100): ");
            double marks = sc.nextDouble();
            sc.nextLine();

            if (name.trim().isEmpty() || course.trim().isEmpty()
                    || marks < 0 || marks > 100) {
                System.out.println("Invalid details!");
                return;
            }

            student.updateDetails(name, course, marks);
            System.out.println("Student updated successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // Delete Student
    static void deleteStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            Student student = findStudent(roll);

            if (student != null) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("Invalid roll number!");
            sc.nextLine();
        }
    }

    // Find Student
    static Student findStudent(int roll) {
        for (Student student : students) {
            if (student.getRollNumber() == roll) {
                return student;
            }
        }
        return null;
    }
}

