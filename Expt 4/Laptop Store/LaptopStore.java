import java.util.Scanner;

public class LaptopStore{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of laptops: ");
        int n = sc.nextInt();
        Laptop[] laptops = new Laptop[n];
        for(int i = 1; i <= n; ++i){
            sc.nextLine(); //consume newline character
            System.out.print("\nEnter the brand of laptop " + i + ": ");
            String brand = sc.nextLine().trim();
            System.out.print("Enter the RAM size (in GB) of laptop " + i + ": ");
            float ramSize = sc.nextFloat();
            System.out.print("Enter the price (in Rs.) of laptop " + i + ": ");
            double price = sc.nextDouble();
            laptops[i-1] = new Laptop(brand, ramSize, price);
        }
        sc.close();
        System.out.println("\nLaptops having 8GB RAM or more:");
        int c = 0;
        for(int i = 0; i < n; ++i)
            if(laptops[i].getRamSize() >= 8.0f){
                c++;
                System.out.println(c + ". " + laptops[i].toString());
            }
        if(c == 0) System.out.println("No laptops found with 8GB RAM or more.");
    }
}

class Laptop{
    private String brand;
    private float ramSize;
    private double price;

    public Laptop(){
        brand = null;
        ramSize = 0.0f;
        price = 0.0;
    }
    public Laptop(String brand, float ramSize, double price){
        this.brand = brand;
        this.ramSize = ramSize;
        this.price = price;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public float getRamSize(){
        return ramSize;
    }
    public void setRamSize(float ramSize){
        this.ramSize = ramSize;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String toString(){
        return "Brand: " + brand + ", RAM Size: " + ramSize + " GB, Price: Rs." + price;
    }
}
