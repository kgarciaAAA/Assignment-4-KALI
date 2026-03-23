package main;

import java.util.Scanner;

public class ModeSelect {
    /**
     * Determines the game mode based on command-line arguments or fallsback to user input.
     * @param args command-line arguments passed to the program
     * @param scanner Scanner used for user input
     * @return a validated mode string ("-r" or "-m")
     */
    public static String getMode(String[] args, Scanner scanner) {
        if (args.length > 0) {
            String validated = validate(args[0]);
            if (validated != null) {
                return validated;
            }
            System.out.println("Invalid command-line argument. Switching to manual selection.");
        }
        return promptUser(scanner);
    }

    /**
     * Prompts the user to select a mode until valid input is received.
     * @param scanner Scanner used for user input
     * @return a validated mode string ("-r" or "-m")
     */
    private static String promptUser(Scanner scanner) {
        System.out.println("Please Select a mode:\n-r = (Random Computer Choice)\n-m = (Machine Learning Choice)");

        while (true) {
            System.out.print("Your Choice: ");
            String input = scanner.nextLine();
            String validated = validate(input);
            if (validated != null) return validated;

            System.out.println("Please try again.\n");
        }
    }

    /**
     * Validates the user input or command-line argument.
     * @param input the input string to validate
     * @return converted mode string ("-r" or "-m"), or null if invalid
     */
    private static String validate(String input) {
        if (input.equalsIgnoreCase("-r") || input.equalsIgnoreCase("r")) {
            return "-r";
        } else if (input.equalsIgnoreCase("-m") || input.equalsIgnoreCase("m")) {
            return "-m";
        }
        return null;
    }
}