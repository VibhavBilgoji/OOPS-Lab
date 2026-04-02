import java.util.Scanner;

public class RevAndCmp {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        sc.close();

        int revNum = reverse(num);
        System.out.println("Reversed Number: " + revNum);

        if (revNum > num) {
            System.out.println(
                "Reversed Number is greater than Original Number"
            );
        } else if (revNum < num) {
            System.out.println(
                "Reversed Number is lesser than Original Number"
            );
        } else {
            System.out.println("Reversed Number is equal to Original Number");
        }
    }

    public static int reverse(Integer num) {
        int revNum = 0;
        while (num > 0) {
            revNum = revNum * 10 + (num % 10);
            num /= 10;
        }
        return revNum;
    }
}
