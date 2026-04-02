import java.util.Scanner;

public class ElectricityBillGenerator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rate per unit: ");
        double rate = sc.nextDouble();
        ElectricityBill.updateRate(rate);
        System.out.print("Enter units consumed: ");
        double units = sc.nextDouble();
        ElectricityBill bill = new ElectricityBill();
        bill.setUnits(units);
        System.out.println("Units Billed: " + bill.getUnits());
        System.out.println("Total electricity bill: " + bill.calculateBill());
        sc.close();
    }
}

class ElectricityBill{
    double unitsConsumed;
    static double ratePerUnit;
    public ElectricityBill(double units){
        unitsConsumed = units;
    }
    public ElectricityBill(){
        unitsConsumed = 0;
    }
    public void setUnits(double units){
        unitsConsumed = units;
    }
    public double getUnits(){
        return unitsConsumed;
    }
    public double calculateBill(){
        return unitsConsumed * ratePerUnit;
    }
    public static void updateRate(double newRate){
        ratePerUnit = newRate;
    }
}