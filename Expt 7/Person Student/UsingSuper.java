import java.util.Scanner;

public class UsingSuper{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the person: ");
        String name = sc.nextLine();
        System.out.print("Are you a student? (yes/no): ");
        String response = sc.next();
        if(response.equalsIgnoreCase("no")){
            Person person = new Person(name);
            person.display();
        }
        else if (response.equalsIgnoreCase("yes")){
            Student student = new Student(name);
            student.display();
        } else {
            System.out.println("Invalid response! Please enter 'yes' or 'no'.");
        }
        sc.close();
    }
}

class Person{
    String name;
    public Person(){
        name = "";
    }
    public Person(String n){
        name = n;
    }
    public void display(){
        System.out.printf("My name is %s.", name);
    }
}

class Student extends Person{
    public Student(String n){
        super(n);
    }
    public Student(){
        super();
    }
    @Override
    public void display(){
        super.display();
        System.out.println("\nI am a student.");
    }
}