import java.util.Scanner;

public class Transpose {

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

        System.out.println("\nCalculating the Transpose of the Matrix...\n");
        int trans[][] = transpose(matrix, rows, cols);

        System.out.println("Original Matrix: ");
        display(matrix, rows, cols);
        System.out.println();
        System.out.println("Transposed Matrix: ");
        display(trans, cols, rows);
    }

    public static void display(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < cols; j++) System.out.print(matrix[i][j] + " ");
            System.out.println('|');
        }
    }

    public static int[][] transpose(int[][] matrix, int rows, int cols) {
        int[][] trans = new int[cols][rows];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) trans[j][i] = matrix[i][j];
        }
        return trans;
    }
}
