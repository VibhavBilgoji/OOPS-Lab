import java.util.Scanner;

class NumberParser{
    static int parseAndDouble(String input) throws NumberFormatException{
        return Integer.parseInt(input) * 2;
    }
}

public class ParserSystem{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input;
        do{
            System.out.print("Enter the String: ");
            input = sc.nextLine();
            if(input == "") {
                System.out.println("String is null. Try again.\n");
                continue;
            }

            try {
                final int num = NumberParser.parseAndDouble(input);
                System.out.printf("Parsed and Doubled: %s\n\n", num);
            } catch (NumberFormatException e){
                System.out.printf("Error: '%s' is not a valid integer.\n\n", input);
            }

            System.out.print("Enter y to continue: ");
            input = sc.nextLine();

            if(input.equalsIgnoreCase("y")) continue;
            else break;
        } while(true);
        System.out.println("Exiting...");
        sc.close();
    }
}