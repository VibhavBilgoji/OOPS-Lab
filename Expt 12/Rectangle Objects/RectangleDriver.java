import java.io.*;
import java.util.*;

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
        return String.format("Length: %.2f, Breadth: %.2f, Area: %.2f\n", length, breadth, area());
    }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }
    public double getBreadth() { return breadth; }
    public void setBreadth(double breadth) { this.breadth = breadth;}
}

public class RectangleDriver {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try {
            List<Rectangle> rectangles = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\s+");
                    double l = Double.parseDouble(parts[0]);
                    double b = Double.parseDouble(parts[1]);
                    rectangles.add(new Rectangle(l, b));
                }
            }

            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write("--- Rectangle Report ---\n");
                for (Rectangle r : rectangles) writer.write(r.toString());
                System.out.println("Processing complete. Check output.txt");
            }
        } catch (IOException e) {
            System.err.println("File Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Data Format Error: Ensure file contains only numbers.");
        }
    }
}