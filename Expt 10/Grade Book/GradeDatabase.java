import java.util.*;

class StudentNotFoundException extends Exception{
    StudentNotFoundException(){};
    StudentNotFoundException(String msg){ super(msg); }
}

class GradeBook{
    private final HashMap<String, Integer> gradeMap;

    GradeBook() {gradeMap = new HashMap<String, Integer>(); }
    GradeBook(int n) {gradeMap = new HashMap<String, Integer>(n); }

    void addStudent(String name, int grade){ gradeMap.put(name, grade); }

    int getGrade(String name) throws NullPointerException, StudentNotFoundException{
        if(name == null) throw new NullPointerException();
        final var grade = gradeMap.get(name);

        if(grade == null)
        throw new StudentNotFoundException("Error: " + name + " not found in the grade book");

        return grade;
    }
}

public class GradeDatabase{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student count: ");
        final int n = sc.nextInt();
        sc.nextLine();
        if(n <= 0) return;
        GradeBook gradeBook = new GradeBook(n);

        for(short i = 0; i < n; i++){
            System.out.println("\nEnter the Student " + (i+1) + " details: ");
            System.out.print("Name: ");
            final String name = sc.nextLine();
            if(name == null || name.isEmpty()) {
                System.out.println("Invalid name. Name cannot be null or empty.");
                --i;
                continue;
            }
            System.out.print("Grade: ");
            final int grade = sc.nextInt();
            if(grade < 0 || grade > 100) {
                System.out.println("Invalid grade. Must be between 0 and 100.");
                --i;
                continue;
            }
            sc.nextLine();

            gradeBook.addStudent(name, grade);
        }

        System.out.println("\n---Student Grade Lookup---");
        String input;
        do {
            System.out.print("\nName of the student: ");
            var name = sc.nextLine();
            if(name.isBlank() || name.isEmpty()) name = null;
            try {
                System.out.println("- Grade: " + gradeBook.getGrade(name));
            } catch (NullPointerException e){
                System.out.println("Error: Student name cannot be null");
            } catch (StudentNotFoundException e){
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Grade lookup finished");
            }

            System.out.print("Enter y to continue: ");
            input = sc.nextLine();

            if(input.equalsIgnoreCase("y")) continue;
            else break;
        } while(true);
        System.out.println("Exiting...");
        sc.close();
    }
}