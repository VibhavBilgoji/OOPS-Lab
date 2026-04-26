import java.util.Scanner;

class MathCalculator {
    public long calculate(int n) throws IllegalArgumentException {
        if (n < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        if (n == 0 || n == 1) return 1;
        return n * calculate(n - 1);
    }

    public int calculate(int n, boolean isFibonacci) throws IllegalArgumentException {
        if (n < 0) throw new IllegalArgumentException("Fibonacci sequence index cannot be negative.");
        if (n == 0) return 0;
        if (n == 1) return 1;
        return calculate(n - 1, true) + calculate(n - 2, true);
    }

    public double calculate(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent < 0) return 1.0 / calculate(base, -exponent);
        return base * calculate(base, exponent - 1);
    }
}

public class MathDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathCalculator calc = new MathCalculator();

        System.out.print("How many factorials to calculate? ");
        int factCount = scanner.nextInt();
        int[] factInputs = new int[factCount];
        long[] factResults = new long[factCount];

        for (int i = 0; i < factCount; i++) {
            System.out.print("Enter number for factorial: ");
            factInputs[i] = scanner.nextInt();
            try {
                factResults[i] = calc.calculate(factInputs[i]);
                System.out.println("Factorial of " + factInputs[i] + " is " + factResults[i]);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.print("\nEnter number for Fibonacci index: ");
        int fibInput = scanner.nextInt();
        try {
            System.out.println("Fibonacci at index " + fibInput + " is " + calc.calculate(fibInput, true));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("\nEnter base for power calculation: ");
        double base = scanner.nextDouble();
        System.out.print("Enter exponent: ");
        int exponent = scanner.nextInt();
        System.out.println(base + "^" + exponent + " = " + calc.calculate(base, exponent));

        scanner.close();
    }
}