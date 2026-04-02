import java.util.Scanner;

public class CalculateArea{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the sides of a square: ");
        int side = sc.nextInt();
        System.out.printf("Area of the square: %d\n\n", AreaCalculator.area(side));
        System.out.print("Enter the length and breadth of a rectangle: ");
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        System.out.printf("Area of the rectange: %d\n\n", AreaCalculator.area(length, breadth));
        System.out.print("Enter the radius of a circle: ");
        double radius = sc.nextDouble();
        System.out.printf("Area of the circle: %.2f\n", AreaCalculator.area(radius));
        sc.close();
    }
}

class AreaCalculator{
    public static int area(int side){
        return side * side;
    }
    public static int area(int length, int breadth){
        return length * breadth;
    }
    public static double area(double radius){
        return Math.PI * radius * radius;
    }
}