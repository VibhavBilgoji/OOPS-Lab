import java.util.Scanner;

public class ColumnSum {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                System.out.print(
                    "Enter the element at [" + (i + 1) + "," + (j + 1) + "]: "
                );
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println("\nEntered Matrix: ");
        display(matrix, rows, cols);
        System.out.println();
        displayColSums(matrix, cols, rows);
    }

    public static void display(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < cols; j++) System.out.print(matrix[i][j] + " ");
            System.out.println('|');
        }
    }

    public static int[] displayColSums(int[][] matrix, int cols, int rows) {
        int[] colSums = new int[cols];
        for (int j = 0; j < cols; ++j) {
            for (int i = 0; i < rows; ++i) colSums[j] += matrix[i][j];
            System.out.println(
                "The Sum of Column " + (j + 1) + " is: " + colSums[j]
            );
        }
        return colSums;
    }
}
