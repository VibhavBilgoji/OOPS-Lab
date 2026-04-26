import java.util.Scanner;

class ShoppingException extends Exception {
    public ShoppingException(String message) { super(message); }
}

interface Billable {
    double generateBill() throws ShoppingException;
}

abstract class Product {
    String id;
    String name;
    double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public abstract void showDetails();
}

class Electronics extends Product {
    int warrantyMonths;

    public Electronics(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void showDetails() {
        System.out.println("[" + id + "] " + name + " (Electronics) - $" + price + " | Warranty: " + warrantyMonths + "m");
    }
}

class Clothing extends Product {
    String size;

    public Clothing(String id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("[" + id + "] " + name + " (Clothing) - $" + price + " | Size: " + size);
    }
}

class Cart implements Billable {
    private Product[] items = new Product[10];
    private int[] quantities = new int[10];
    private int itemCount = 0;

    public void addProduct(Product p, int qty) throws ShoppingException {
        if (qty <= 0) throw new ShoppingException("Quantity must be greater than zero.");
        if (itemCount >= items.length) throw new ShoppingException("Cart is full.");
        items[itemCount] = p;
        quantities[itemCount] = qty;
        itemCount++;
        System.out.println(p.name + " added to cart.");
    }

    public void removeProduct(String id) throws ShoppingException {
        if (itemCount == 0) throw new ShoppingException("Cart is already empty.");
        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (items[i].id.equals(id)) {
                found = true;
                for (int j = i; j < itemCount - 1; j++) {
                    items[j] = items[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                items[itemCount - 1] = null;
                quantities[itemCount - 1] = 0;
                itemCount--;
                System.out.println("Product removed.");
                break;
            }
        }
        if (!found) throw new ShoppingException("Product ID not found in cart.");
    }

    @Override
    public double generateBill() throws ShoppingException {
        if (itemCount == 0) throw new ShoppingException("Cannot generate bill for an empty cart.");
        double total = 0;
        System.out.println("\n--- Final Bill ---");
        for (int i = 0; i < itemCount; i++) {
            double cost = items[i].price * quantities[i];
            System.out.println(items[i].name + " x" + quantities[i] + " : $" + cost);
            total += cost;
        }
        System.out.println("Total: $" + total);
        return total;
    }
}

public class ShoppingDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        Product p1 = new Electronics("E1", "Laptop", 999.99, 12);
        Product p2 = new Clothing("C1", "T-Shirt", 19.99, "L");

        boolean running = true;
        while (running) {
            System.out.println("\n1. View Products\n2. Add to Cart\n3. Remove from Cart\n4. Checkout\n5. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                if (choice == 1) {
                    p1.showDetails();
                    p2.showDetails();
                } else if (choice == 2) {
                    System.out.print("Enter Product ID to add (E1/C1): ");
                    String id = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    if (id.equals("E1")) cart.addProduct(p1, qty);
                    else if (id.equals("C1")) cart.addProduct(p2, qty);
                    else System.out.println("Invalid ID.");
                } else if (choice == 3) {
                    System.out.print("Enter Product ID to remove: ");
                    String id = scanner.nextLine();
                    cart.removeProduct(id);
                } else if (choice == 4) {
                    cart.generateBill();
                    running = false;
                } else if (choice == 5) {
                    running = false;
                }
            } catch (ShoppingException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}