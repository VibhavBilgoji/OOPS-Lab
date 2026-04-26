import java.util.Scanner;

interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Invalid radius");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double side) {
        if (side <= 0) throw new IllegalArgumentException("Invalid side");
        this.length = side;
        this.width = side;
    }

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) throw new IllegalArgumentException("Invalid dimensions");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class Triangle implements Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }
}

public class ShapesDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape[] shapes = new Shape[3];

        try {
            System.out.print("Enter Circle radius: ");
            shapes[0] = new Circle(scanner.nextDouble());

            System.out.print("Enter Rectangle length and width: ");
            shapes[1] = new Rectangle(scanner.nextDouble(), scanner.nextDouble());

            System.out.print("Enter Triangle sides a, b, c: ");
            shapes[2] = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());

            for (Shape s : shapes) {
                if (s != null) {
                    System.out.println(s.getClass().getSimpleName() + " Area: " + s.calculateArea() + ", Perimeter: " + s.calculatePerimeter());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Dimension Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            scanner.close();
        }
    }
}