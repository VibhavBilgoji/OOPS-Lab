import java.util.Scanner;

public class Factorial {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer : ");
        int num = sc.nextInt();
        sc.close();

        int fact = 1;
        for (int i = 1; i <= num; i++) fact *= i;

        System.out.println("Factorial of " + num + " is: " + fact);
    }
}
