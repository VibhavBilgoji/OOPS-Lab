import java.util.Scanner;

public class AvgOfDigits {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        sc.close();
        float sum = 0;
        int count = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
            ++count;
        }
        if (count > 0) {
            float avg = sum / count;
            System.out.println(
                "The average of all the digits of the number is " + avg
            );
        } else System.out.println("The number has no digits");
    }
}
