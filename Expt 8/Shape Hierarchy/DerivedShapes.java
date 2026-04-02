import java.util.Scanner;

public class DerivedShapes{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        float radius = sc.nextFloat();
        Shape circle = new Circle(radius);
        circle.display();
        System.out.print("\nEnter the length and breadth of the rectangle: ");
        float length = sc.nextFloat();
        float breadth = sc.nextFloat();
        Shape rectangle = new Rectangle(length, breadth);
        rectangle.display();
        sc.close();
    }
}

abstract class Shape{
    abstract double area();
    public void display(){
        System.out.println("Area of the Shape: " + area());
    }
}

class Circle extends Shape{
    float radius;
    public Circle(float rad){
        radius = rad;
    }
    public Circle(){
        radius = 0;
    }
    @Override
    public double area(){
        return Math.PI * radius * radius;
    }
    public void display(){
        System.out.printf("Shape: Circle\nArea of the Circle: %.2f\n", area());
    }
}

class Rectangle extends Shape{
    float length, breadth;
    public Rectangle(float l, float b){
        length = l;
        breadth = b;
    }
    public Rectangle(){
        length = breadth = 0;
    }
    @Override
    public double area(){
        return length * breadth;
    }
    public void display(){
        System.out.printf("Shape: Rectangle\nArea of the Rectangle: %.2f\n", area());
    }
}