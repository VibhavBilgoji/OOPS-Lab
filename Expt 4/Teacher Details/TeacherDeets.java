import java.util.Scanner;

public class TeacherDeets{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of teachers: ");
        int n = sc.nextInt();
        Teacher[] teachers = new Teacher[n];
        sc.nextLine(); //consume newline character
        for(int i = 1; i <= n; ++i){
            System.out.print("\nEnter the name of teacher " + i + ": ");
            String name = sc.nextLine().trim();
            System.out.print("Enter the subject of teacher " + i + ": ");
            String subject = sc.nextLine().trim();
            System.out.print("Enter the ID of teacher " + i + ": ");
            String id = sc.nextLine();
            teachers[i-1] = new Teacher(name, id, subject);
        }
        System.out.print("\nEnter the Subject to filter by: ");
        String filterSub = sc.nextLine().trim();
        sc.close();
        System.out.println("\nTeachers teaching '" + filterSub + "':");
        int c = 0;
        for(int i = 0; i < n; ++i)
            if(teachers[i].getSub().equalsIgnoreCase(filterSub)){
                c++;
                System.out.println(c + ". " + teachers[i].toString());
            }
        if(c == 0) System.out.println("No teachers found teaching '" + filterSub + "'.");
    }
}

class Teacher{
    private String name, id, subject;
    public Teacher(){
        name = id = subject = null;
    }
    public Teacher(String name, String id, String subject){
        this.name = name;
        this.id = id;
        this.subject = subject;
    }
    public String toString(){
        return "Name: " + name + ", ID: " + id + ", Subject: " + subject;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getSub(){
        return subject;
    }
    public void setSub(String subject){
        this.subject = subject;
    }
}
