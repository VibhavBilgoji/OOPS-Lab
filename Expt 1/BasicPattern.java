import java.util.Scanner;

public class BasicPattern {

    public static void main(String args[]) {
        System.out.print("Enter the number of rows: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
