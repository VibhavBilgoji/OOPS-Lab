import java.util.Scanner;

public class RectangleOperations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length and breadth of first rectangle: ");
        double l1 = sc.nextDouble();
        double b1 = sc.nextDouble();
        Rectangle r1 = new Rectangle(l1, b1);
        System.out.print("Enter length and breadth of second rectangle: ");
        double l2 = sc.nextDouble();
        double b2 = sc.nextDouble();
        Rectangle r2 = new Rectangle(l2, b2);
        System.out.println("\nArea of first rectangle: " + r1.calculateArea());
        System.out.println("Perimeter of first rectangle: " + r1.calculatePerimeter());
        System.out.println("\nArea of second rectangle: " + r2.calculateArea());
        System.out.println("Perimeter of second rectangle: " + r2.calculatePerimeter());
        Rectangle larger = Rectangle.compareArea(r1, r2);
        System.out.println("\nRectangle with larger area has area: " + larger.calculateArea());
        System.out.print("\nEnter side length for square: ");
        double side = sc.nextDouble();
        Rectangle square = Rectangle.createSquare(side);
        System.out.println("\nArea of square: " + square.calculateArea());
        System.out.println("Perimeter of square: " + square.calculatePerimeter());
        sc.close();
    }
}

class Rectangle{
    double length, breadth;
    public Rectangle(double l, double b){
        length = l;
        breadth = b;
    }
    public Rectangle(){
        length = breadth = 0;
    }
    public double calculateArea(){
        return length * breadth;
    }
    public double calculatePerimeter(){
        return 2 * (length + breadth);
    }
    public static Rectangle compareArea(Rectangle r1, Rectangle r2){
        return (r1.calculateArea() > r2.calculateArea()) ? r1 : r2;
    }
    public static Rectangle createSquare(double side){
        return new Rectangle(side, side);
    }
}