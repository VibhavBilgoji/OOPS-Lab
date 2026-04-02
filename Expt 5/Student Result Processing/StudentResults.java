import java.util.Scanner;

public class StudentResults{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of subjects: ");
        int subjects = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++){
            System.out.println("Enter details for student " + (i+1) + ":");
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();
            System.out.printf("Enter marks for %d subjects: ", subjects);
            float[] marks = new float[subjects];
            for(int j = 0; j < subjects; j++) marks[j] = sc.nextFloat();
            students[i] = new Student(name, rollNo, marks);
        }
        sc.close();
        System.out.println("\nStudent Results:");
        for(Student s: students) System.out.println(s.displayResult());
        System.out.println("Class Average: " + Student.calculateClassAverage(students));
    }
}

class Student{
    String name;
    int rollNo;
    float[] marks;
    public Student(){
        name = "";
        rollNo = 0;
    }
    public Student(String n, int r, float[] mks){
        name = n;
        rollNo = r;
        marks = mks;
    }
    public double calculateTotal(){
        double total = 0;
        for(float m: marks) total += m;
        return total;
    }
    public double calculateAverage(){
        return calculateTotal() / marks.length;
    }
    public String displayResult(){
        String status = calculateAverage() >= 40 ? "Pass" : "Fail";
        return "Name: " + name + "\nRoll No: " + rollNo + "\nTotal Marks: " + calculateTotal()
        + "\nAverage Marks: " + calculateAverage() + "\nStatus: " + status + "\n";
    }
    public static double calculateClassAverage(Student[] students){
        double total = 0;
        for(Student s: students) total += s.calculateAverage();
        return total / students.length;
    }
}