
import java.util.Scanner;

class BankAccount {
    private String name;
    private long accountNumber;
    private double balance;

    // Constructor
    BankAccount(String name, long accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Money deposited successfully!");
            System.out.println("Current Balance: Rs. " + balance);
        } else {
            System.out.println("Please enter a valid amount.");
        }
    }

    // Withdraw money
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Money withdrawn successfully!");
            System.out.println("Current Balance: Rs. " + balance);
        }
    }

    // Check balance
    void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }

    // Display account details
    void displayDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
    }
}

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANKING MANAGEMENT SYSTEM =====");

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        long accountNumber = sc.nextLong();

        System.out.print("Enter Opening Balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Opening balance cannot be negative.");
            sc.close();
            return;
        }

        BankAccount account =
                new BankAccount(name, accountNumber, balance);

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

