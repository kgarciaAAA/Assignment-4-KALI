package main;

import java.util.Scanner;

public class UserSelection {

    public static ComputerStrategy getComputerStrategy(Scanner scanner, GameData gameData) {
        System.out.println("Please Select a mode:\n-r = (Random Computer Choice)\n-m = (Machine Learning Choice)");
        while (true) { 
            System.out.print("Your Choice: ");
            String userChoice = scanner.nextLine();
            String validate = verifyInput(userChoice);
            if (validate != null){
                return ComputerStrategyFactory.createStrategy(userChoice, gameData);
            } else {
                System.out.println("\nPlease Try Again.");
            }
        }
    }

    public static String verifyInput(String userChoice) {
        if (userChoice.equalsIgnoreCase("-r" ) || userChoice.equalsIgnoreCase("r")) {
            return "-r";
        } else if (userChoice.equalsIgnoreCase("-m" ) || userChoice.equalsIgnoreCase("m")){
            return "-m";

        } else {
            return null;
        }
    }
}
