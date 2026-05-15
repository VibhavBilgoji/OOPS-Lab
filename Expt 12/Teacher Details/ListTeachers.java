import java.util.*;
import java.io.*;

class Teacher{
    private String id, name, subject;
    public Teacher(String id, String name, String subject){
        this.id = id;
        this.name = name;
        this.subject = subject;
    }
    public Teacher(){ id = name = subject = ""; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String n) { name = n; }
    public String getSubject() { return subject; }
    public void setSubject(String s) { subject = s; }

    @Override
    public String toString(){
        return String.format("ID: %s, Name: %s, Subject: %s\n", id, name, subject);
    }
}

public class ListTeachers {
    public static void main(String[] args) {
        String filter;
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the subject to filter teachers: ");
            filter = sc.nextLine().trim().toLowerCase();
        }

        File inputFile = new File("teachers.txt");
        File outputFile = new File("teacher_report.txt");

        try {
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }

            List<Teacher> teacherList = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split("(,\\s)+");
                teacherList.add(new Teacher(parts[0], parts[1], parts[2]));
            }

            new FileOutputStream(outputFile).close();

            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write(String.format("--- Teachers teaching %s ---\n", filter));
                for (Teacher t : teacherList) {
                    if(t.getSubject().toLowerCase().equals(filter)){
                        writer.write(t.toString());
                    }
                }
                System.out.println("Processing complete. Check teacher_report.txt");
            }
        } catch (IOException e) {
            System.err.println("File Error: " + e.getMessage());
        }
    }
}