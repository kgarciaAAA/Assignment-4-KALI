package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Calls validateInput() to get users Choice as an int and returns the choice
     * as a Move enum value
     * @return the human player's selected move as a Move enum value
     */
    @Override
    public Move getPlayerMove() {
        int choice = validateInput();
        return Move.convertToMove(choice);
    }

    /**
     * Validates the user input and returns the users Choice
     * @return an int containing the users choice
     */
    private int validateInput() {
        while (true) {
            try {
                System.out.print("Choose (1=rock, 2=paper, 3=scissors): ");
                int choice = scanner.nextInt();
                
                if (choice >= 1 && choice <= 3) {
                    scanner.nextLine();
                    return choice - 1;
                } else {
                    scanner.nextLine();
                    System.out.println("Invalid Choice. Try Again...");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid Choice. Try Again...");
            }
        }
    }
}
