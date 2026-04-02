import java.util.Scanner;

public class Points2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Point p1 = new Point();
        System.out.println("Default Point 1: " + p1);

        System.out.print("Enter x and y for Point 2: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        Point p2 = new Point(x2, y2);
        System.out.println("Point 2: " + p2.toString());

        System.out.print("Enter new x for Point 1: ");
        p1.setX(sc.nextInt());
        System.out.print("Enter new y for Point 1: ");
        p1.setY(sc.nextInt());

        System.out.println("Point 1 X: " + p1.getX());
        System.out.println("Point 1 Y: " + p1.getY());

        System.out.print("Enter new x and y for Point 2: ");
        int newX2 = sc.nextInt();
        int newY2 = sc.nextInt();
        p2.setXY(newX2, newY2);
        int[] coords = p2.getXY();
        System.out.println("Point 2 Coordinates: (" + coords[0] + ',' + coords[1] + ")");

        System.out.println("Distance from Point 1 to origin: " + p1.distance());
        System.out.println("Distance from Point 1 to Point 2: " + p1.distance(p2));
        System.out.print("Enter x and y to calculate distance from Point 1: ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        Double dist = p1.distance(x3, y3);
        System.out.println("Distance from Point 1 to (" + x3 + "," + y3 + "): " + dist);

        sc.close();
    }
}
class Point{
    private int x, y;
    public Point(){
        x = y = 0;
    }
    public Point(int x, int y){
       setXY(x, y);
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public int[] getXY(){
        return new int[] {x, y};
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + x + "," + y + ")";
    }
    public Double distance(int x, int y){
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }
    public Double distance(Point another){
        return distance(another.getX(), another.getY());
    }
    public Double distance(){
        return distance(0, 0);
    }
}
