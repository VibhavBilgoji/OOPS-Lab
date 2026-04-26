import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    protected double balance;
    protected String[] history;
    protected int txCount;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.history = new String[100];
        this.txCount = 0;
        recordTransaction("Account opened with: " + initialBalance);
    }

    protected void recordTransaction(String details) {
        if (txCount < history.length) {
            history[txCount++] = details;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }
        balance -= amount;
        recordTransaction("Withdrew: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void displayTransactions() {
        System.out.println("--- Standard Account Transactions ---");
        for (int i = 0; i < txCount; i++) {
            System.out.println(history[i]);
        }
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        recordTransaction("Interest added: " + interest);
    }

    @Override
    public void displayTransactions() {
        System.out.println("--- Savings Account Transactions ---");
        for (int i = 0; i < txCount; i++) {
            System.out.println(history[i]);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter initial balance: ");
            double bal = scanner.nextDouble();
            System.out.print("Enter interest rate: ");
            double rate = scanner.nextDouble();

            SavingsAccount acc = new SavingsAccount(bal, rate);

            System.out.print("Enter deposit amount: ");
            acc.deposit(scanner.nextDouble());

            System.out.print("Enter withdrawal amount: ");
            acc.withdraw(scanner.nextDouble());

            acc.addInterest();

            System.out.println("Final Balance: " + acc.getBalance());
            acc.displayTransactions();

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            scanner.close();
        }
    }
}