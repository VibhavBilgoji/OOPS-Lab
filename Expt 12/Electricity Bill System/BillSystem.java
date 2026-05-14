import java.util.*;
import java.io.*;
import java.nio.file.*;

class Consumer{
    private String name, number;
    private float unitsConsumed, pricePerUnit;

    public Consumer(String name, String num, float u, float ppu) {
        this.name = name;
        number = num;
        unitsConsumed = u;
        pricePerUnit = ppu;
    }
    public Consumer() {
        name = number = "";
        unitsConsumed = pricePerUnit = 0;
    }

    public String getName() { return name; }
    public void setName(String n) { name = n; }
    public String getNumber() { return number; }
    public void setNumber(String n) { number = n; }
    public float getUnitsConsumed() { return unitsConsumed; }
    public void setUnitsConsumed(float u) { unitsConsumed = u; }
    public float getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(float p) { pricePerUnit = p; }

    public float calculateBill() {
        return unitsConsumed * pricePerUnit;
    }

    @Override
    public String toString(){
        return String.format("Consumer Name: %s, Number: %s, Units Consumed: %.2f, Bill Amount: Rs.%.2f", name, number, unitsConsumed, calculateBill());
    }
}

public class BillSystem{
    public static void main(String[] args){
        System.out.print("Enter the Price per Unit (in Rs.): ");
        float pricePerUnit;
        try(Scanner sc = new Scanner(System.in)) {
            pricePerUnit = sc.nextFloat();
        }

        Path inputPath = Paths.get("consumers.txt");
        Path outputPath = Paths.get("bills.txt");

        try{
            List<String> list = Files.readAllLines(inputPath);
            final int n = list.size();
            Consumer[] consumers = new Consumer[n];
            for(int i = 0; i < n; ++i){
                String[] parts = list.get(i).split("\\s+");
                String name = parts[0];
                String number = parts[1];
                float units = Float.parseFloat(parts[2]);
                consumers[i] = new Consumer(name, number, units, pricePerUnit);
            }
            try(BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
                writer.write("--- Electricity Bills ---\n");
                for(Consumer c : consumers){
                    writer.write(c.toString());
                    writer.newLine();
                }
                System.out.println("Processing complete. Check bills.txt");
            }
        } catch (IOException e) {
            System.err.println("File Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Data Format Error: Ensure file contains valid data.");
        }
    }
}