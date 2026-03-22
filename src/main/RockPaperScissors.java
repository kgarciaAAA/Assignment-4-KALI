package main;

public class RockPaperScissors {
    public static void main(String[] args) {
        int numberOfRounds = 20;
        Player humanPlayer = new HumanPlayer();
        Player computerPlayer = new ComputerPlayer();
        ScoreBoard scoreBoard = new ScoreBoard();
        GameLogic gameLogic = new GameLogic();
        DisplayResult displayResult = new DisplayResult();
        Game game = new Game(numberOfRounds, humanPlayer, computerPlayer, scoreBoard, gameLogic, displayResult);
        game.startGame();
    }
}
