import java.io.*;
import java.nio.file.*;
import java.util.*;

public class RectangleDriver{
    public static void main(String[] args){
        Path inputPath = Paths.get("input.txt");
        Path outputPath = Paths.get("output.txt");

        try {
            List<String> lines = Files.readAllLines(inputPath);
            final int n = lines.size();

            Rectangle[] rectangles = new Rectangle[n];

            for (int i = 0; i < n; i++) {
                String[] parts = lines.get(i).split("\\s+");
                double l = Double.parseDouble(parts[0]);
                double b = Double.parseDouble(parts[1]);
                rectangles[i] = new Rectangle(l, b);
            }

            try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
                writer.write("--- Rectangle Report ---\n");
                for (Rectangle r : rectangles) {
                    writer.write(r.toString());
                    writer.newLine();
                }
                System.out.println("Processing complete. Check output.txt");
            }
        } catch (IOException e) {
            System.err.println("File Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Data Format Error: Ensure file contains only numbers.");
        }
    }
}

class Rectangle{
    private double length, breadth;
    public Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public Rectangle(){ length = breadth = 0; }
    public double area(){ return length * breadth; }

    @Override
    public String toString() {
        return String.format("Length: %.2f, Breadth: %.2f, Area: %.2f", length, breadth, area());
    }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }
    public double getBreadth() { return breadth; }
    public void setBreadth(double breadth) { this.breadth = breadth;}
}