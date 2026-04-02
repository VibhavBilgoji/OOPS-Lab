import java.util.Scanner;

public class DecToOct {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal value: ");
        int dec = sc.nextInt();
        int rem;
        sc.close();
        String oct = "";
        while (dec > 0) {
            rem = dec % 8;
            dec /= 8;
            oct = rem + oct;
        }
        System.out.println("The value in octal is " + oct);
    }
}
