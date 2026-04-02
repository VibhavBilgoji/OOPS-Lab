import java.util.Scanner;

public class SpecialNum {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        sc.close();
        int numCopy = num,
            sum = 0,
            endDigit;
        while (num > 0) {
            endDigit = num % 10;
            num /= 10;
            sum += fact(endDigit);
        }
        if (sum == numCopy) System.out.println(
            "The entered integer is a Special Number"
        );
        else System.out.println("The entered integer is not a Special Number");
    }

    public static int fact(Integer num) {
        if ((num == 0) | (num == 1)) return 1;
        return num * fact(num - 1);
    }
}
