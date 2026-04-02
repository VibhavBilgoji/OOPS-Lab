import java.util.Scanner;

public class CharOccur {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.nextLine();
        System.out.println("\nEnter the character: ");
        char c = sc.next().charAt(0);
        sc.close();

        short count = 0;
        for (int i = 0; i < str.length(); ++i) if (str.charAt(i) == c) ++count;
        System.out.println(
            "The character '" + c + "' has occured " + count + " time(s)."
        );
    }
}
