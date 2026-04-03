import java.util.Scanner;

public class StudentDeets{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the student: ");
        String name = sc.nextLine();
        System.out.print("Enter the age of the student: ");
        int age = sc.nextInt();
        System.out.print("Enter the grade of the student: ");
        float grade = sc.nextFloat();
        sc.nextLine();
        System.out.print("Enter the branch of the student: ");
        String branch = sc.nextLine();
        EngineeringStudent student = new EngineeringStudent(name, age, grade, branch);
        System.out.println("\nStudent Details:");
        student.getDetails();
        sc.close();
    }
}

abstract class Person{
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Person(){
        name = "";
        age = 0;
    }
    public void getDetails(){
        System.out.println("Name: " + name + "\nAge: " + age);
    }
}

abstract class Student extends Person{
    float grade;
    public Student(String name, int age, float grade){
        super(name, age);
        this.grade = grade;
    }
    public Student(){
        super();
        grade = 0;
    }
    public void getGrade(){
        System.out.println("Grade: " + grade);
    }
    @Override
    public void getDetails(){
        super.getDetails();
        getGrade();
    }
}

class EngineeringStudent extends Student{
    String branch;
    public EngineeringStudent(String name, int age, float grade, String branch){
        super(name, age, grade);
        this.branch = branch;
    }
    public EngineeringStudent(){
        super();
        branch = "";
    }
    @Override
    public void getDetails(){
        super.getDetails();
        System.out.println("Branch: " + branch);
    }
}