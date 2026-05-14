import java.util.*;
import java.io.*;
import java.nio.file.*;

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
        return String.format("ID: %s, Name: %s, Subject: %s", id, name, subject);
    }
}

public class ListTeachers{
    public static void main(String[] args){
        String filter;
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the subject to filter teachers: ");
            filter = sc.nextLine().trim().toLowerCase();
        }
        Path inputPath = Paths.get("teachers.txt");
        Path outputPath = Paths.get("teacher_report.txt");

        try {
            List<String> lines = Files.readAllLines(inputPath);
            final int n = lines.size();
            Teacher[] teachers = new Teacher[n];

            for (int i = 0; i < n; i++) {
                String[] parts = lines.get(i).split("(,\\s)+");
                String id = parts[0];
                String name = parts[1];
                String subject = parts[2];
                teachers[i] = new Teacher(id, name, subject);
            }

            try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
                writer.write(String.format("--- Teachers teaching %s ---\n", filter));
                for (Teacher t : teachers) {
                    if(t.getSubject().toLowerCase().equals(filter)){
                        writer.write(t.toString());
                        writer.newLine();
                    }
                }
                System.out.println("Processing complete. Check teacher_report.txt");
            }
        } catch (IOException e) {
            System.err.println("File Error: " + e.getMessage());
        }
    }
}