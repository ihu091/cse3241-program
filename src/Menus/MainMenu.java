package Menus;

import java.util.Scanner;
import java.util.ArrayList;

import Helpers.PrintHelpers;

public class MainMenu {
    private Scanner scanner;
    private static ArrayList<String> menuOptions = new ArrayList<String>() {
        {
            add("1. Manage Members");
            add("2. Manage Rentals");
            add("3. Manage Drones");
            add("4. Manage Inventory");
            add("5. Manage Shipments");
            add("6. Manage Payments\n");

            add("7. Rent Equipment");
            add("8. Return Equipment");
            add("9. Delivery of Equipment");
            add("10. Pickup of Equipment\n");

            add("11. Clear Outputs");
            add("12. Exit Program");
        }
    };

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean prompt() {
        PrintHelpers.printHeader("Main Menu");
        printMenu();

        while (true) {
            System.out.print("Your Option: ");
            if (!scanner.hasNextInt()) {
                String input = scanner.nextLine();
                System.out.println(
                        "Unknown option: \"" + input + "\"\n" +
                                "Please enter a number...\n");
                continue;
            }

            int input = scanner.nextInt();
            if (input < 1 || input > menuOptions.size()) {
                System.out.println(
                        "Unknown option: \"" + input + "\"\n" +
                                "Please choose one of the menu options...\n");
                continue;
            }
            return routeInput(input);
        }
    }

    private static void printMenu() {
        System.out.println(
                "\nPlease choose from one of the following options " +
                        "(enter the number corresponding to the desired option):");

        for (String option : menuOptions) {
            System.out.println("\t" + option);
        }
    }

    private static boolean routeInput(int input) {
        switch (input) {
            case 1: // Manage Members
                System.out.println("Option has not been implemented yet...\n");
                break;
            case 2: // Manage Rentals
                System.out.println("Option has not been implemented yet...\n");
                break;

            case 3: // Manage Drones
                System.out.println("Option has not been implemented yet...\n");
                break;

            case 4: // Manage Inventory
                System.out.println("Option has not been implemented yet...\n");
                break;
            case 5: // Manage Shipments
                System.out.println("Option has not been implemented yet...\n");
                break;
            case 6: // Manage Payments
                System.out.println("Option has not been implemented yet...\n");
                break;

            case 7: // Rent Equipment
                System.out.println("Option has not been implemented yet...\n");
                break;
            case 8: // Return Equipment
                System.out.println("Option has not been implemented yet...\n");
                break;
            case 9: // Delivery of Equipment
                System.out.println("Option has not been implemented yet...\n");
                break;
            case 10: // Pickup of Equipment
                System.out.println("Option has not been implemented yet...\n");
                break;

            case 11: // Clear output
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;

            case 12: // Terminate program
                return false;
        }
        return true;
    }
}
