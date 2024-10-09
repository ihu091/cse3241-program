package Menus;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Random;

import Entities.MemberEntity;
import Helpers.InputVerifier;
import Helpers.PrintHelpers;
import Models.MemberModel;

public class ManageMembersMenu {
    private static ArrayList<String> menuOptions = new ArrayList<String>() {
        {
            add("1. Add Member");
            add("2. Search Members (by ID)");
            add("3. Check Member Status");
            add("4. Edit Member Info\n");

            add("5. Exit to Main Menu");
        }
    };

    private Scanner scanner;

    // TODO: delete. Temp for checkpoint 2, generate random data...
    private MemberEntity memberEntity;

    public ManageMembersMenu(Scanner scanner) {
        this.scanner = scanner;
        memberEntity = new MemberEntity();

        // TODO: delete, generates data
        memberEntity.add(new MemberModel(1, "John", "Doe", "123 Main St", "555-1234", "john.doe@example.com",
                new Date(), "Active"));
        memberEntity.add(new MemberModel(2, "Jane", "Smith", "456 Oak St", "555-5678", "jane.smith@example.com",
                new Date(), "Active"));
        memberEntity.add(new MemberModel(3, "Alex", "Johnson", "789 Pine St", "555-8765", "alex.johnson@example.com",
                new Date(), "Active"));
        memberEntity.add(new MemberModel(4, "Emily", "Davis", "321 Birch St", "555-4321", "emily.davis@example.com",
                new Date(), "Active"));
        memberEntity.add(new MemberModel(5, "Michael", "Brown", "654 Cedar St", "555-9876", "michael.brown@example.com",
                new Date(), "Active"));
        memberEntity.add(new MemberModel(6, "Sarah", "Wilson", "987 Elm St", "555-3456", "sarah.wilson@example.com",
                new Date(), "Active"));
    }

    public void prompt() {
        boolean continueMenu = true;
        while (continueMenu) {
            PrintHelpers.printHeader("Manage Member Menu");
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
                addMember();
                break;
            case 2:
                searchMember();
                break;
            case 3:
                checkMemberStatus();
                break;
            case 4:
                editMember();
                break;

            case 5:
                return false;
        }
        return true;
    }

    private void addMember() {
        int memberId = (new Random()).nextInt(Integer.MAX_VALUE);
        Date startDate = new Date();
        String memberStatus = "Active";

        PrintHelpers.printHeader("Add Member");

        System.out.print("Enter member first name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter member last name: ");
        String lname = scanner.nextLine();

        System.out.print("Enter member address: ");
        String address = scanner.nextLine();

        System.out.print("Enter member phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter member email: ");
        String email = scanner.nextLine();

        MemberModel newMember = new MemberModel(memberId, fname, lname, address, phone, email, startDate, memberStatus);
        memberEntity.add(newMember);

        System.out.println("\nAdded the following member: ");
        printMember(newMember);
    }

    private void searchMember() {
        PrintHelpers.printHeader("Search for Member");

        int id = InputVerifier.getValidIntegerInput(scanner, "Enter ID to search for: ", 0, Integer.MAX_VALUE);
        MemberModel member = memberEntity.findById(id);

        if (member == null) {
            System.out.println("Could not find member with ID: " + id);
            return;
        }

        printMember(member);
    }

    private void checkMemberStatus() {
        PrintHelpers.printHeader("Check Member Status");

        int id = InputVerifier.getValidIntegerInput(scanner, "Enter Member ID: ", 0, Integer.MAX_VALUE);
        MemberModel member = memberEntity.findById(id);

        if (member == null) {
            System.out.println("Could not find member with ID: " + id);
            return;
        }

        System.out.println("\nMember status is: " + member.MembershipStatus);
    }

    private void editMember() {
        PrintHelpers.printHeader("Edit Member");

        int id = InputVerifier.getValidIntegerInput(scanner, "Enter Member ID: ", 0, Integer.MAX_VALUE);
        MemberModel member = memberEntity.findById(id);

        if (member == null) {
            System.out.println("Could not find member with ID: " + id);
            return;
        }

        printMember(member);

        System.out.print("\nEnter new member first name: ");
        member.FName = scanner.nextLine();

        System.out.print("Enter new member last name: ");
        member.LName = scanner.nextLine();

        System.out.print("Enter new member address: ");
        member.Address = scanner.nextLine();

        System.out.print("Enter new member phone number: ");
        member.PhoneNumber = scanner.nextLine();

        System.out.print("Enter new member email: ");
        member.Email = scanner.nextLine();

        memberEntity.update(member);

        System.out.println("\nUpdated Member: ");
        printMember(member);
    }

    private static void printMember(MemberModel member) {
        System.out.println(
                "\tMember ID: " + member.MemberID + "\n" +
                        "\tName: " + member.FName + " " + member.LName + "\n" +
                        "\tAddress: " + member.Address + "\n" +
                        "\tPhone Number: " + member.PhoneNumber + "\n" +
                        "\tEmail: " + member.Email + "\n" +
                        "\tMembership Start: " + member.MembershipStartDt.toString() + "\n" +
                        "\tStatus: " + member.MembershipStatus);
    }
}
