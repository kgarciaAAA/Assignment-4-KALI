package main;

public class ComputerStrategyFactory {
    public static ComputerStrategy createStrategy(String choice, GameData gameData) {
        return switch (choice) {
            case "-r" -> new RandomStrategy();
            case "-m" -> new MLStrategy(gameData);
            default -> new RandomStrategy();
        };
    }
}
