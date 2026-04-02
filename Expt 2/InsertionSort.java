import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println();
        Sort(arr);

        System.out.print("\nSorted Array: ");
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
    }

    public static void Sort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) arr[j + 1] = arr[j];
                else {
                    arr[j + 1] = temp;
                    break;
                }
                if (j == 0) arr[j] = temp;
            }
            System.out.println("Step " + i + ": " + Arrays.toString(arr));
        }
    }
}
