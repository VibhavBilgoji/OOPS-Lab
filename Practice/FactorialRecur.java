import java.util.Scanner;

public class FactorialRecur {
    public static void main() {
        final Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        final int num = sc.nextInt();
        sc.close();

        final int result = (num >= 0) ? fact(num) : null;
        System.out.println("Factorial of " + num + " is: " + result);

    }
    final public static int fact(int num) {
        if ((num == 0) | (num == 1)) return 1;
        return num * fact(num - 1);
    }
}
