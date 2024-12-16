import java.util.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map.Entry;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$',###,##0.00 ");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /*Validate the login information customer number and pin number*/
    public void getlogin() throws IOException {
        int x = 1; 
        do {
            try {
                // Add some users
                data.put(9398671, 70161);
                data.put(8162185, 64485);
                System.out.println("Welcome to the Project! ");
                System.out.print("Enter the customer number: ");
                setCustomerNumber(menuInput.nextInt());
                System.out.print("Enter your pin number: ");
                setPinNumber(menuInput.nextInt());

                boolean isValid = false; // Flag to track if login is successful

                for (Entry<Integer, Integer> entry : data.entrySet()) {
                    if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                        getAccountType(); // If login is successful, call the account menu
                        isValid = true;
                        break;
                    }
                }

                if (!isValid) {
                    System.out.println("\nWrong customer number or pin number.\n");
                }
                
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Only numbers are allowed.\n");
                menuInput.nextLine(); // Consume the invalid input
            }
        } while (x == 1); // Continue looping until valid login
    }

    public void getAccountType() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Select the Account you want to access: ");
            System.out.println("Type 1 - Checking Account");
            System.out.println("Type 2 - Savings Account");
            System.out.println("Type 3 - Exit");
            System.out.print("Choice: ");
            int selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    getChecking();  // Call the checking account menu
                    break;
                case 2:
                    getSaving();  // Call the savings account menu
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid Choice\n");
            }
        }
    }

    // Checking Account Menu
    public void getChecking() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Checking Account: ");
            System.out.println("Type 1 - View Balance ");
            System.out.println("Type 2 - Withdraw Amount");
            System.out.println("Type 3 - Deposit Funds");
            System.out.println("Type 4 - Exit");
            System.out.print("Choice: ");
            int selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    getCheckingWithdrawInput();
                    break;
                case 3:
                    getCheckingDepositInput();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Adios!");
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid Choice\n");
            }
        }
    }

    // Savings Account Menu
    public void getSaving() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Savings Account: ");
            System.out.println("Type 1 - View Balance");
            System.out.println("Type 2 - Withdraw Funds");
            System.out.println("Type 3 - Add Funds");
            System.out.println("Type 4 - Exit");
            System.out.print("Choice: ");
            int selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                    break;
                case 2:
                    getSavingWithdrawInput();
                    break;
                case 3:
                    getSavingDepositInput();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid Choice\n");
            }
        }
    }
}
