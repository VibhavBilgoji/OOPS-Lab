import java.util.Scanner;

class InvalidEmployeeDataException extends Exception {
    public InvalidEmployeeDataException(String message) {
        super(message);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) throws InvalidEmployeeDataException {
        if (age < 0) {
            throw new InvalidEmployeeDataException("Age cannot be negative.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidEmployeeDataException("Name cannot be empty.");
        }
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name.toUpperCase());
        System.out.println("Age: " + age);
    }
}

class Employee extends Person {
    double salary;

    public Employee(String name, int age, double salary) throws InvalidEmployeeDataException {
        super(name, age);
        if (salary < 0) {
            throw new InvalidEmployeeDataException("Salary cannot be negative.");
        }
        this.salary = salary;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Salary: $" + String.format("%.2f", salary));
    }
}

class Manager extends Employee {
    String department;

    public Manager(String name, int age, double salary, String department) throws InvalidEmployeeDataException {
        super(name, age, salary);
        if (department == null || department.trim().isEmpty()) {
            throw new InvalidEmployeeDataException("Department cannot be empty.");
        }
        this.department = department;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + department.substring(0, 1).toUpperCase() + department.substring(1).toLowerCase());
    }
}

public class ManagerDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager[] managers = new Manager[2];

        for (int i = 0; i < managers.length; i++) {
            System.out.println("Enter details for Manager " + (i + 1) + ":");
            try {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Salary: ");
                double salary = Double.parseDouble(scanner.nextLine());
                System.out.print("Department: ");
                String dept = scanner.nextLine();

                managers[i] = new Manager(name, age, salary, dept);
            } catch (InvalidEmployeeDataException e) {
                System.out.println("Validation Error: " + e.getMessage());
                i--;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please try again.");
                i--;
            }
        }

        System.out.println("\n--- Manager Details ---");
        for (Manager m : managers) {
            m.display();
            System.out.println("-----------------------");
        }
        scanner.close();
    }
}