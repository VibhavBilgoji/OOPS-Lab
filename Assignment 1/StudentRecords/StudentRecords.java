import java.util.Scanner;

class Student {
    protected int id;
    protected String name;
    protected double[] marks;

    public Student(int id, String name, double[] marks) {
        if (id <= 0 || name == null || name.isEmpty() || marks == null || marks.length == 0) {
            throw new IllegalArgumentException("Invalid student data");
        }
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public String getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        if (avg >= 75) return "B";
        if (avg >= 50) return "C";
        return "F";
    }

    public boolean matchesId(int searchId) {
        return this.id == searchId;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Avg: " + calculateAverage() + ", Grade: " + getGrade());
    }
}

class PGStudent extends Student {
    private String thesisTopic;

    public PGStudent(int id, String name, double[] marks, String thesisTopic) {
        super(id, name, marks);
        if (thesisTopic == null || thesisTopic.isEmpty()) {
            throw new IllegalArgumentException("Invalid thesis topic");
        }
        this.thesisTopic = thesisTopic;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Thesis: " + thesisTopic);
    }
}

public class StudentRecords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of marks: ");
            int n = scanner.nextInt();
            double[] marks = new double[n];

            System.out.println("Enter UG Student ID, Name:");
            int id1 = scanner.nextInt();
            scanner.nextLine();
            String name1 = scanner.nextLine();
            System.out.println("Enter marks:");
            for(int i=0; i<n; i++) marks[i] = scanner.nextDouble();

            Student ug = new Student(id1, name1, marks.clone());

            System.out.println("Enter PG Student ID, Name:");
            int id2 = scanner.nextInt();
            scanner.nextLine();
            String name2 = scanner.nextLine();
            System.out.println("Enter marks:");
            for(int i=0; i<n; i++) marks[i] = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Thesis Topic: ");
            String thesis = scanner.nextLine();

            PGStudent pg = new PGStudent(id2, name2, marks.clone(), thesis);

            Student[] records = {ug, pg};

            System.out.print("Enter ID to search: ");
            int searchId = scanner.nextInt();
            boolean found = false;
            for (Student s : records) {
                if (s.matchesId(searchId)) {
                    s.display();
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Student not found.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            scanner.close();
        }
    }
}