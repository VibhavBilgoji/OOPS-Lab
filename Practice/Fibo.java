import java.util.Scanner;

public class Fibo {
    public static void main() {
        final Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci terms to generate: ");
        final int nOfTerms = sc.nextInt();
        sc.close();
        FiboTerms.gen(nOfTerms);
    }
}

final class FiboTerms {
    final public static void gen(final int n) {
        if (n < 0) {
            System.out.println("Number of terms must be non-negative.");
            return;
        }
        System.out.print("Fibonacci sequence: ");
        if (n == 0) return;

        System.out.print("0");
        if (n == 1) return;

        System.out.print(", 1");
        if (n == 2) return;

        int a = 0, b = 1;
        for (int i = 2; i < n; ++i) {
            final int c = a + b;
            System.out.print(", " + c);
            a = b;
            b = c;
        }
    }
}
