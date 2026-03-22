package main;

public class ComputerStrategyFactory {
    public static ComputerStrategy createStrategy(String choice) {
        return switch (choice) {
            case "-r" -> new RandomStrategy();
            case "-m" -> new MLStrategy();
            default -> new RandomStrategy();
        };
    }
}
