import java.util.Scanner;

public class CamelToSnake {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string in camelCase: ");
        String camel = sc.next();
        sc.close();
        System.out.println("\nString in snake_case is: " + camelToSnake(camel));
    }

    public static String camelToSnake(String camel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < camel.length(); ++i) {
            int c = (int) camel.charAt(i);

            if (c >= 65 && c <= 90) sb.append("_" + (char) (c + 32));
            else sb.append((char) c);
        }
        return sb.toString();
    }
}
