import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class ArrayOperations {
    private int[] arr;

    public ArrayOperations(int[] arr) {
        this.arr = arr;
    }

    public int getLargest() {
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        return max;
    }

    public int getSmallest() {
        int min = arr[0];
        for (int num : arr) if (num < min) min = num;
        return min;
    }

    public void sortArray() {
        Arrays.sort(arr);
    }

    public int binarySearch(int key) {
        return Arrays.binarySearch(arr, key);
    }

    public void display() {
        for (int num : arr) System.out.printf("%d ", num);
        System.out.println();
    }
}

public class Q1Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter array size: ");
            int n = scanner.nextInt();
            if (n <= 0) throw new IllegalArgumentException("Size must be positive.");

            int[] arr = new int[n];
            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            ArrayOperations ops = new ArrayOperations(arr);

            System.out.printf("Largest: %d%n", ops.getLargest());
            System.out.printf("Smallest: %d%n", ops.getSmallest());

            ops.sortArray();
            System.out.print("Sorted: ");
            ops.display();

            System.out.print("Enter key to search: ");
            int key = scanner.nextInt();
            int index = ops.binarySearch(key);
            if (index >= 0) System.out.printf("Found at index: %d%n", index);
            else System.out.println("Not found.");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}