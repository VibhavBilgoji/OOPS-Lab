import java.util.Scanner;

interface FuelCalculable{
    default double estimateFuelBurn(double distanceKm, int passengers){
        final float baseBurn = 4.5f;
        final float perPassBurn = 0.002f;
        return (baseBurn + passengers * perPassBurn) * distanceKm;
    }
}

interface EmissionTrackable{
    default double co2Emissions(double fuelLiters){
        final float co2PerLit = 2.53f;
        return co2PerLit * fuelLiters;
    }
}

class AircraftFlight implements FuelCalculable, EmissionTrackable{
    private double distanceKm;
    private int passengers;
    private double fuelLiters;
    AircraftFlight(){
        distanceKm = fuelLiters = 0.0;
        passengers = 0;
    }
    AircraftFlight(double d, int p){
        distanceKm = d;
        passengers = p;
        fuelLiters = estimateFuelBurn(distanceKm, passengers);
    }
    double totalFuelCost(){
        final int fuelPerLit = 85;
        return estimateFuelBurn(distanceKm, passengers) * fuelPerLit;
    }
    double perPassFuelSur(){
        final float perPassBurn = 0.002f;
        final int fuelPerLit = 85;
        return perPassBurn * distanceKm * fuelPerLit;
    }
    double carbonOffsetCost(){
        final int costPerTonne = 1200;
        return costPerTonne * co2Emissions(fuelLiters)/1000;
    }
    String netTicketCost(){
        if(passengers == 0) return "No passengers, Breakdown not applicable.";
        final double fuelCostPerPass = totalFuelCost()/passengers;
        final double offsetCostPerPass = carbonOffsetCost()/passengers;
        var res = "\nNet Ticket Cost Breakdown:\n";
        res += String.format("- Fuel Cost per Passenger: Rs.%.2f\n", fuelCostPerPass);
        res += String.format("- Emission Cost per Passenger: Rs.%.2f" , offsetCostPerPass);
        return res;
    }
    double getDistanceKm() {return distanceKm;}
    void setDistanceKm(double d) {distanceKm = d;}
    int getPassengers() {return passengers;}
    void setPassengers(int p) {passengers = p;}
    double getFuelLiters() {return fuelLiters;}
    void setFuelLiters(double f) {fuelLiters = f;}
}

public class FlightCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter flight distance in km: ");
        double distance = sc.nextDouble();
        System.out.print("Enter number of passengers: ");
        int passengers = sc.nextInt();
        System.out.println();
        AircraftFlight flt = new AircraftFlight(distance, passengers);
        System.out.printf("Total Fuel Cost: Rs.%.2f\n", flt.totalFuelCost());
        System.out.printf("Per Passenger Fuel Surcharge: Rs.%.2f\n", flt.perPassFuelSur());
        System.out.printf("Carbon Offset Cost: Rs.%.2f\n", flt.carbonOffsetCost());
        System.out.println(flt.netTicketCost());
        sc.close();
    }
}