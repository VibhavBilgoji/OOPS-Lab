import java.util.Scanner;

public class Fibo {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci terms to generate: ");
        int nOfTerms = sc.nextInt();
        sc.close();
        FiboTerms.gen(nOfTerms);
    }
}

class FiboTerms {

    public static void gen(Integer n) {
        if (n < 0) {
            System.out.println("Number of terms must be non-negative.");
            return;
        }
        if (n == 0) {
            System.out.println("Fibonacci sequence: ");
            return;
        }
        if (n == 1) {
            System.out.println("Fibonacci sequence: 0");
            return;
        }
        if (n == 2) {
            System.out.println("Fibonacci sequence: 0, 1");
            return;
        }

        System.out.print("Fibonacci sequence: 0, 1");
        int a = 0,
            b = 1;

        for (int i = 2; i < n; ++i) {
            int c = a + b;
            System.out.print(", " + c);
            a = b;
            b = c;
        }
    }
}
