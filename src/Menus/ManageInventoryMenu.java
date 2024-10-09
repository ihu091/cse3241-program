package Menus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import Entities.InventoryEntity;
import Helpers.InputVerifier;
import Helpers.PrintHelpers;
import Models.InventoryModel;

public class ManageInventoryMenu {
    private static ArrayList<String> menuOptions = new ArrayList<String>() {
        {
            add("1. Add Item");
            add("2. Search Item (by ID)");
            add("3. View All Available Items");
            add("4. Remove Item");
            add("5. Exit to Main Menu");
        }
    };

    private Scanner scanner;

    // TODO: delete. Temp for checkpoint 2, generate random data...
    private InventoryEntity inventoryEntity;

    public ManageInventoryMenu(Scanner scanner) {
        this.scanner = scanner;
        inventoryEntity = new InventoryEntity();

        // TODO: delete, generates data
        inventoryEntity.add(new InventoryModel(1, "Projector", "Medium", "Black", 101, 201));
        inventoryEntity.add(new InventoryModel(2, "Lawn Mower", "Standard", "Green", 102, 202));
        inventoryEntity.add(new InventoryModel(3, "Camping Tent", "4-Person", "Orange", 103, 203));
        inventoryEntity.add(new InventoryModel(4, "Bicycle", "Mountain", "Red", 104, 204));
        inventoryEntity.add(new InventoryModel(5, "Power Drill", "Cordless", "Blue", 105, 205));
        inventoryEntity.add(new InventoryModel(6, "Kayak", "Single", "Yellow", 106, 206));
        inventoryEntity.add(new InventoryModel(7, "Audio System", "Portable", "Black", 107, 207));
        inventoryEntity.add(new InventoryModel(8, "Snowboard", "All-Mountain", "White", 108, 208));
        inventoryEntity.add(new InventoryModel(9, "Camera", "DSLR", "Black", 109, 209));
        inventoryEntity.add(new InventoryModel(10, "Generator", "2000W", "Silver", 110, 210));
                
    }

    public void prompt() {
        boolean continueMenu = true;
        while (continueMenu) {
            PrintHelpers.printHeader("Manage Inventory Menu");
            PrintHelpers.printMenu(menuOptions);

            int userInput = InputVerifier.getValidIntegerInput(scanner, "Your Option: ", 1, menuOptions.size());

            System.out.println();
            continueMenu = routeInput(userInput);
            System.out.println();
        }
    }

    private boolean routeInput(int input) {
        switch (input) {
            case 1:
                addItem();
                break;
            case 2:
                searchItem();
                break;
            case 3:
                viewAllItems();
                break;
            case 4:
                removeItem();
                break;

            case 5:
                return false;
        }
        return true;
    }

    private void addItem() {
        PrintHelpers.printHeader("Add Item");
        InventoryModel newItem = new InventoryModel();
        newItem.ItemID = (new Random()).nextInt(Integer.MAX_VALUE);

        System.out.print("Enter item name: ");
        newItem.Name = scanner.nextLine();

        System.out.print("Enter item size: ");
        newItem.Size = scanner.nextLine();

        System.out.print("Enter color: ");
        newItem.Color = scanner.nextLine();

        newItem.WarehouseID = InputVerifier.getValidIntegerInput(scanner, "Enter warehouse ID: ", 0, Integer.MAX_VALUE);

        newItem.ManufacturerID = InputVerifier.getValidIntegerInput(scanner, "EntEnter manufacturer ID: ", 0,
                Integer.MAX_VALUE);

        inventoryEntity.add(newItem);

        System.out.println("\nAdded the following item: ");
        printItem(newItem);
    }

    private void searchItem() {
        PrintHelpers.printHeader("Search for Item");

        int id = InputVerifier.getValidIntegerInput(scanner, "Enter ID to search for: ", 0, Integer.MAX_VALUE);
        InventoryModel item = inventoryEntity.findById(id);

        if (item == null) {
            System.out.println("Could not find item with ID: " + id);
            return;
        }
        System.out.println("Found Item:");
        printItem(item);
    }

    public void viewAllItems() {
        System.out.printf("%-10s %-20s %-10s %-10s %-15s %-15s%n", "Item ID", "Name", "Size", "Color", "Warehouse ID",
                "Manufacturer ID");
        System.out.println("---------------------------------------------------------------------------------");

        for (InventoryModel item : inventoryEntity.getAll()) {
            System.out.printf("%-10d %-20s %-10s %-10s %-15d %-15d%n",
                    item.ItemID, item.Name, item.Size, item.Color,
                    item.WarehouseID, item.ManufacturerID);
        }
    }

    private void removeItem() {
        PrintHelpers.printHeader("Remove Item");

        int id = InputVerifier.getValidIntegerInput(scanner, "Enter Item ID: ", 0, Integer.MAX_VALUE);
        InventoryModel item = inventoryEntity.findById(id);
        printItem(item);
        inventoryEntity.delete(item);
        System.out.println("Deleted item...");
    }

    private static void printItem(InventoryModel item) {
        System.out.println(
            "\tItem ID: " + item.ItemID + "\n" +
            "\tName: : " + item.Name + "\n" +
            "\tSize: " + item.Size + "\n" +
            "\tColor: : " + item.Color + "\n" +
            "\tWarehouse ID: : " + item.WarehouseID + "\n" +
            "\tManufacturer ID: : " + item.ManufacturerID
        );
    }
}