import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Expense {
    String description;
    double amount;
    
    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
}

public class SocietaLedger {
    public static void main(String[] args) {
        ArrayList<Expense> ledger = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Societa Ledger (Day 12) ---");
        while (true) {
            System.out.println("\n1. Add Maintenance Entry");
            System.out.println("2. Save and Exit");
            System.out.print("Choose option: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                if (choice == 1) {
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    
                    System.out.print("Enter amount: ");
                    double amt = scanner.nextDouble();
                    
                    ledger.add(new Expense(desc, amt));
                    System.out.println("Entry added!");
                } else if (choice == 2) {
                    saveToCSV(ledger);
                    System.out.println("Exiting Societa Ledger...");
                    break;
                } else {
                    System.out.println("Invalid option, try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number!");
                scanner.nextLine(); // clear bad input
            }
        }
        scanner.close();
    }
    
    public static void saveToCSV(ArrayList<Expense> expenses) {
        try (FileWriter writer = new FileWriter("societa_data.csv")) {
            writer.write("Description,Amount\n");
            for (Expense exp : expenses) {
                writer.write(exp.description + "," + exp.amount + "\n");
            }
            System.out.println("Data successfully saved to societa_data.csv!");
        } catch (IOException e) {
            System.out.println("Failed to save data: " + e.getMessage());
        }
    }
}