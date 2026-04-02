import static java.lang.Math.*;

import java.util.Scanner;

public class Cube {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the side length of the cube: ");
        double side = sc.nextDouble();
        sc.close();

        double volume = pow(side, 3);
        System.out.println("Volume of the cube: " + volume);
    }
}
