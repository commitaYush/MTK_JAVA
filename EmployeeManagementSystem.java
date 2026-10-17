
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void updateDetails(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double calculateSalary() {
        double bonus = salary * 0.10;
        return salary + bonus;
    }

    public void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Basic Salary: Rs. " + salary);
        System.out.println("Salary with 10% Bonus: Rs. " + calculateSalary());
        System.out.println("------------------------------");
    }
}

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;

                    case 2:
                        viewEmployees();
                        break;

                    case 3:
                        searchEmployee();
                        break;

                    case 4:
                        updateEmployee();
                        break;

                    case 5:
                        deleteEmployee();
                        break;

                    case 6:
                        System.out.println("Thank you for using Employee Management System!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }

        } while (choice != 6);

        sc.close();
    }

    // Add Employee
    static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (id <= 0 || findEmployee(id) != null) {
                System.out.println("Invalid or duplicate Employee ID!");
                return;
            }

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Basic Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            if (name.trim().isEmpty() || department.trim().isEmpty()
                    || salary < 0 || Double.isInfinite(salary)
                    || Double.isNaN(salary)) {
                System.out.println("Invalid employee details!");
                return;
            }

            employees.add(new Employee(id, name, department, salary));
            System.out.println("Employee added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // View All Employees
    static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        for (Employee employee : employees) {
            employee.display();
        }
    }

    // Search Employee
    static void searchEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            Employee employee = findEmployee(id);

            if (employee != null) {
                employee.display();
            } else {
                System.out.println("Employee not found!");
            }

        } catch (Exception e) {
            System.out.println("Invalid Employee ID!");
            sc.nextLine();
        }
    }

    // Update Employee
    static void updateEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            Employee employee = findEmployee(id);

            if (employee == null) {
                System.out.println("Employee not found!");
                return;
            }

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Department: ");
            String department = sc.nextLine();

            System.out.print("Enter New Basic Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            if (name.trim().isEmpty() || department.trim().isEmpty()
                    || salary < 0 || Double.isInfinite(salary)
                    || Double.isNaN(salary)) {
                System.out.println("Invalid employee details!");
                return;
            }

            employee.updateDetails(name, department, salary);
            System.out.println("Employee updated successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // Delete Employee
    static void deleteEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            Employee employee = findEmployee(id);

            if (employee != null) {
                employees.remove(employee);
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found!");
            }

        } catch (Exception e) {
            System.out.println("Invalid Employee ID!");
            sc.nextLine();
        }
    }

    // Find Employee
    static Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }
}

