package main;

import java.util.Scanner;

public class UserSelection {
    public static ComputerStrategy getComputerStrategy(Scanner scanner) {
        System.out.println("Please Select a mode:\n-r = (Random Computer Choice)\n-m = (Machine Learning Choice)");
        while (true) { 
            System.out.print("Your Choice: ");
            String userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("-r" ) || userChoice.equalsIgnoreCase("-m")){
                return ComputerStrategyFactory.createStrategy(userChoice.toLowerCase());
            } else {
                System.out.println("\nPlease Try Again.");
            }
        }
    }
}
