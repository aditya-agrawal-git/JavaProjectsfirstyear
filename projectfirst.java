
import java.util.ArrayList;
import java.util.Scanner;

class Expense {

    String title;
    double amount;

    Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }
}

public class expensestrackmanagementsystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Expense> expenses = new ArrayList<>();

    public static void addExpenses() {

        System.out.print("Expense Title: ");
        String title = sc.nextLine();

        System.out.print("Expense Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Expense ex = new Expense(title, amount);

        expenses.add(ex);

        System.out.println("Expense added successfully!");
    }

    public static void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        double total = 0;

        System.out.println("\n----- Your Expenses -----");

        for (Expense e : expenses) {

            System.out.println(e.title + " - Rs. " + e.amount);

            total += e.amount;
        }

        System.out.println("-------------------------");
        System.out.println("Total Expenses: Rs. " + total);
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==== EXPENSE TRACKER ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addExpenses();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    System.out.println("Thank you for using Expense Tracker!");
                    
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
