import java.util.Scanner;

public class EmpRoles{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Select the role of the employee:");
            System.out.println("1. Employee");
            System.out.println("2. Manager");
            System.out.println("3. Developer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            Employee emp;
            switch(choice){
                case 1:
                    emp = new Employee();
                    emp.work();
                    break;
                case 2:
                    emp = new Manager();
                    emp.work();
                    break;
                case 3:
                    emp = new Developer();
                    emp.work();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }
}

class Employee{
    public void work(){
        System.out.println("Employee is working...\n");
    }
}

class Manager extends Employee{
    @Override
    public void work(){
        System.out.println("Manager is managing the team...\n");
    }
}

class Developer extends Employee{
    @Override
    public void work(){
        System.out.println("Developer is writing code...\n");
    }
}