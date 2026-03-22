package main;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRounds = 20;
        Player humanPlayer = new HumanPlayer(scanner);
        Player computerPlayer = new ComputerPlayer(UserSelection.getComputerStrategy(scanner));
        ScoreBoard scoreBoard = new ScoreBoard();
        GameLogic gameLogic = new GameLogic();
        DisplayResult displayResult = new DisplayResult();
        Game game = new Game(numberOfRounds, humanPlayer, computerPlayer, scoreBoard, gameLogic, displayResult);
        game.startGame();
        scanner.close();
    }
}
