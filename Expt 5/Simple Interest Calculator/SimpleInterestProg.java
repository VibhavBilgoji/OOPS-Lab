import java.util.Scanner;

public class SimpleInterestProg{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter principal amount: ");
        double principal = sc.nextDouble();
        System.out.print("Enter rate of interest: ");
        double rate = sc.nextDouble();
        System.out.print("Enter time in years: ");
        double time = sc.nextDouble();
        SimpleInterestCalculator calculator = new SimpleInterestCalculator();
        double simpleInterest = calculator.calculateSI(principal, rate, time);
        double amount = SimpleInterestCalculator.calculateAmount(principal, rate, time);
        double defaultInterest = calculator.calculateSI(principal, rate);
        System.out.printf("\nSimple Interest (for %.2f years): %.2f\n", time, simpleInterest);
        System.out.println("Total Amount: " + amount);
        System.out.println("Simple Interest (Default 1-year period): " + defaultInterest);
        sc.close();
    }
}

class SimpleInterestCalculator{
    double principal, rate, time;
    public double calculateSI(double principal, double rate, double time){
        this.principal = principal;
        this.rate = rate;
        this.time = time;
        return (principal * rate * time) / 100;
    }
    public double calculateSI(double principal, double rate){
        return calculateSI(principal, rate, 1);
    }
    public static double calculateAmount(double principal, double rate, double time){
        return principal + (principal * rate * time) / 100;
    }
}