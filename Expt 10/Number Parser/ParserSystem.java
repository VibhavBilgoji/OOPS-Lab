import java.util.Scanner;

class NumberParser{
    static int parseAndDouble(String input) throws NumberFormatException{
        return Integer.parseInt(input) * 2;
    }
}

public class ParserSystem{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        boolean choice = false;
        String input;
        int num;
        do{
            System.out.print("Enter the String: ");
            input = sc.nextLine();
            if(input == "") {
                System.out.println("String is null. Try again.\n");
                continue;
            }

            try {
                num = NumberParser.parseAndDouble(input);
                System.out.printf("Parsed and Doubled: %s\n\n", num);
            } catch (NumberFormatException e){
                System.out.printf("Error: '%s' is not a valid integer.\n\n", input);
            }

            System.out.print("Do you want to continue? (y/n): ");
            input = sc.nextLine();

            if(input.equalsIgnoreCase("y")) choice = true;
            else if(input.equalsIgnoreCase("n")) choice = false;
            else {
                System.out.println("Invalid input. Exiting...");
                return;
            }
        } while(choice);
        sc.close();
    }
}