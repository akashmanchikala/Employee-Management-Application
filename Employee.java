import java.util.ArrayList;
import java.util.Scanner;
class Employee {
    private final int id;
    private String name;
    private String designation;
    private double salary;
    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
    }
}
public class EmployeeManagementApp {
    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Employee Management Application ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> {
                    running = false;
                    System.out.println("Exiting the application. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, designation, salary));
        System.out.println("Employee added successfully!");
    }
    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\n=== Employee List ===");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }
    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            System.out.print("Enter New Name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isBlank()) {
                emp.setName(name);
            }

            System.out.print("Enter New Designation (leave blank to keep current): ");
            String designation = scanner.nextLine();
            if (!designation.isBlank()) {
                emp.setDesignation(designation);
            }
            System.out.print("Enter New Salary (leave blank to keep current): ");
            String salaryInput = scanner.nextLine();
            if (!salaryInput.isBlank()) {
                double salary = Double.parseDouble(salaryInput);
                emp.setSalary(salary);
            }

            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found.");
        }
    }
    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            employees.remove(emp);
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found.");
        }
    }
    private static Employee findEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
}
