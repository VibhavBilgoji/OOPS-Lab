import java.util.Scanner;

public class NRectangles{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Rectangles: ");
        int n = sc.nextInt();
        Rectangle[] rects = new Rectangle[n];
        for(int i = 0; i < n; ++i){
            System.out.print("Enter length and breadth of Rectangle " + (i+1) + ": ");
            double len = sc.nextDouble();
            double bre = sc.nextDouble();
            rects[i] = new Rectangle(len, bre);
        }
        sc.close();
        System.out.println("\nAreas of the Rectangles:");
        for(int i = 0; i < n; ++i){
            System.out.println("Rectangle " + (i+1) + rects[i].toString());
        }
    }
}

class Rectangle{
    private double length, breadth;
    public Rectangle(double len, double bre){
        length = len;
        breadth = bre;
    }
    public Rectangle(){
        length = breadth = 0;
    }
    public double getLength(){
        return length;
    }
    public void setLength(double length){
        this.length = length;
    }
    public double getBreadth(){
        return breadth;
    }
    public void setBreadth(double breadth){
        this.breadth = breadth;
    }
    public double area(){
        return length * breadth;
    }
    public String toString(){
        return " Area: " + area();
    }
}