import java.util.Arrays;
import java.util.Scanner;

public class Smallest3K {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int count = sc.nextInt();

        int arr[] = new int[count];
        System.out.println("Enter the elements one by one: ");
        for (int i = 0; i < count; ++i) arr[i] = sc.nextInt();

        System.out.println("The entered array is: " + Arrays.toString(arr));
        Arrays.sort(arr);

        System.out.print("Enter the value of K: ");
        int k = sc.nextInt();
        sc.close();
        if (k > count) {
            System.out.println("Error: Index out of bounds.");
            return;
        }
        if (k < 3) {
            System.out.println("K should be atleast 3.");
            return;
        }
        System.out.print("The Kth, K-1th and K-2th smallest elements in an array are: ");
        for (int i = k - 1; i > k - 4; --i) System.out.print(arr[i] + " ");
    }
}