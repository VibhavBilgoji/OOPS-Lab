import java.util.Scanner;
class TransportSystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter transport type (e.g., Bus, Train): ");
        String transportType = sc.nextLine();
        System.out.print("Enter route number: ");
        String routeNumber = sc.nextLine();
        System.out.print("Enter seating capacity: ");
        int seatingCapacity = sc.nextInt();
        System.out.println("\nInitiating object creation...\n");
        Bus myBus = new Bus(transportType, routeNumber, seatingCapacity);
        System.out.println("\n--- Transport Details ---");
        System.out.println(myBus);
        sc.close();
    }
}

class Transport{
    String transportType;
    public Transport(String t) {
        System.out.println("-> Transport (Base Class) Constructor executed.");
        transportType = t;
    }
    public String toString(){
        return "Transport Type: " + transportType;
    }
}

class PublicTransport extends Transport{
    String routeNumber;
    public PublicTransport(String t, String r) {
        super(t);
        System.out.println("-> PublicTransport (Subclass) Constructor executed.");
        routeNumber = r;
    }
    @Override
    public String toString() {
        return super.toString() + "\nRoute Number: " + routeNumber;
    }
}

class Bus extends PublicTransport{
    int seatingCapacity;
    public Bus(String t, String r, int s) {
        super(t, r);
        System.out.println("-> Bus (Sub-Subclass) Constructor executed.");
        seatingCapacity = s;
    }
    @Override
    public String toString(){
        return super.toString() + "\nSeating Capacity: " + seatingCapacity;
    }
}