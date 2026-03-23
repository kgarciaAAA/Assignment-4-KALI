package main;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameData gameData = new GameData();
        int numberOfRounds = 20;
        Player humanPlayer = new HumanPlayer(scanner);
        String mode = ModeSelect.getMode(args, scanner);
        Player computerPlayer = new ComputerPlayer(ComputerStrategyFactory.createStrategy(mode, gameData));
        ScoreBoard scoreBoard = new ScoreBoard();
        GameLogic gameLogic = new GameLogic();
        DisplayResult displayResult = new DisplayResult();
        Game game = new Game(numberOfRounds, humanPlayer, computerPlayer, scoreBoard, gameLogic, displayResult);
        game.startGame();
        computerPlayer.saveData();
        scanner.close();
    }
}
