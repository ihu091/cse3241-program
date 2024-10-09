package Helpers;

import java.util.Scanner;

public class InputVerifier {
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }

        int length = str.length();
        if (length == 0) {
            return false;
        }

        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }

        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }

        return true;
    }

    public static int getValidIntegerInput(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextInt()) {
                String input = scanner.nextLine();
                System.out.println(
                        "Unknown option: \"" + input + "\"\n" +
                                "Please enter a number...\n");
                continue;
            }

            int intInput = scanner.nextInt();
            if (intInput < min || intInput > max) {
                System.out.println(
                        "Unknown option: \"" + intInput + "\"\n" +
                                "Value outside of valid range, please choose number between "
                                + min + "-" + max + "\n");
                continue;
            }
            
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            return intInput;
        }
    }
}
