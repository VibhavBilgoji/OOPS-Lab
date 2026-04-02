import java.util.Scanner;

public class EvenLenStrs {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int count = sc.nextInt();
        sc.nextLine();
        String arr[] = new String[count];
        System.out.println("Enter the strings one by one: ");
        for (int i = 0; i < arr.length; ++i) arr[i] = sc.nextLine();
        sc.close();

        System.out.println("\nStrings with even length are: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() % 2 == 0) System.out.println(arr[i]);
        }
    }
}
