import java.util.Scanner;

public class CalculateSumProg{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter count of numbers to sum: ");
        int count = sc.nextInt();
        int[] numbers = new int[count];
        System.out.println("Enter the numbers:");
        for(int i=0; i < count; i++) numbers[i] = sc.nextInt();
        int result = FlexibleCalculator.sum(numbers);
        System.out.println("Sum of the numbers: " + result);
        int newResult = FlexibleCalculator.sum(1, 2, 3, 4, 5);
        System.out.println("Sum of 1, 2, 3, 4, 5: " + newResult);
        sc.close();
    }
}

class FlexibleCalculator{
    public static int sum(int... numbers){
        int sum = 0;
        System.out.println("Count of numbers: " + numbers.length);
        for(int n: numbers) sum += n;
        return sum;
    }
}