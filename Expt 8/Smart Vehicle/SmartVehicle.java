import java.util.Scanner;

public class SmartVehicle{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the model of the electric car: ");
        String model = sc.nextLine();
        ElectricCar car = new ElectricCar(model);
        System.out.println("Vehicle Type: " + ElectricCar.vehicleType());
        System.out.println("Car Model: " + car.model);
        System.out.println(car.getLocation());
        System.out.println(car.drive());
        sc.close();
    }
}

interface GPS{
    String getLocation();
}

abstract class Vehicle{
    static String vehicleType(){
        return "Electric Vehicle";
    }
    abstract String drive();
}

class ElectricCar extends Vehicle implements GPS{
    String model;
    public ElectricCar(String model){
        this.model = model;
    }
    public ElectricCar(){
        this.model = "Unknown Model";
    }
    @Override
    public String getLocation(){
        return "Current location: 15°25'20.9\"N 73°58'39.3\"E";
    }
    @Override
    public String drive(){
        return "The electric car is driving silently...";
    }
}