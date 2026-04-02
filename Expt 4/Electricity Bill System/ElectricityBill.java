import java.util.Scanner;

public class ElectricityBill{
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter the number of consumers: ");
       int n = sc.nextInt();
       Consumer[] consumers = new Consumer[n];
       for(int i = 0; i < n; ++i){
           System.out.print("Enter the consumer number for consumer " + (i+1) + ": ");
           String number = sc.next();
           System.out.print("Enter the consumer name for consumer " + (i+1) + ": ");
           sc.nextLine();
           String name = sc.nextLine();
           System.out.print("Enter the number of units consumed by consumer " + (i+1) + ": ");
           double units = sc.nextDouble();
           consumers[i] = new Consumer(number, name, units);
       }
       System.out.print("Enter the cost per unit in Rupees: ");
       float cpu = sc.nextFloat();
       sc.close();
       for(int i = 0; i < n; ++i){
           double bill = consumers[i].getUnits() * cpu;
           consumers[i].setBill(bill);
       }
       System.out.println("\nElectricity Bills:");
       for(int i = 0; i < n; ++i){
           System.out.println("\nConsumer " + (i+1) + ":\n" + consumers[i].toString());
           System.out.println("Bill Amount: Rs." + consumers[i].getBill() + "/-");
       }
    }
}

class Consumer{
    private String number, name;
    private double units, bill;

    public Consumer(){
        number = name = "";
        units = 0;
    }
    public Consumer(String number, String name, double units){
        this.number = number;
        this.name = name;
        this.units = units;
    }
    public String toString(){
        return "Number: " + number + "\nName: " + name + "\nUnits Consumed: " + units;
    }
    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getUnits(){
        return units;
    }
    public void setUnits(double units){
        this.units = units;
    }
    public double getBill(){
        return bill;
    }
    public void setBill(double bill){
        this.bill = bill;
    }
}
