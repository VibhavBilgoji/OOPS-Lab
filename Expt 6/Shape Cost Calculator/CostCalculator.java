import java.util.Scanner;

class CostCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape myShape;

        System.out.print("Enter the painting cost per unit (in Rupees): ");
        double globalCost = sc.nextDouble();

        System.out.print("\nEnter side of Square: ");
        double s = sc.nextDouble();
        myShape = new Square(s, globalCost);
        System.out.println("Square Painting Cost: Rs." + myShape.calculatePaintingCost());

        System.out.print("\nEnter radius of Circle: ");
        double r = sc.nextDouble();
        myShape = new Circle(r, globalCost);
        System.out.println("Circle Painting Cost: Rs." + myShape.calculatePaintingCost());

        System.out.print("\nEnter base and height of Triangle: ");
        double b = sc.nextDouble();
        double h = sc.nextDouble();
        myShape = new Triangle(b, h, globalCost);
        System.out.println("Triangle Painting Cost: Rs." + myShape.calculatePaintingCost());

        sc.close();
    }
}

class Shape {
    double costPerUnit;
    public Shape(double cost) {
        costPerUnit = cost;
    }
    public double getArea() {
        return 0.0;
    }
    public double calculatePaintingCost() {
        return getArea() * costPerUnit;
    }
}

class Square extends Shape {
    double side;
    public Square(double side, double cost) {
        super(cost);
        this.side = side;
    }
    @Override
    public double getArea() {
        return side * side;
    }
}

class Circle extends Shape {
    double radius;
    public Circle(double radius, double cost) {
        super(cost);
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle extends Shape {
    double base, height;
    public Triangle(double base, double height, double cost) {
        super(cost);
        this.base = base;
        this.height = height;
    }
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
