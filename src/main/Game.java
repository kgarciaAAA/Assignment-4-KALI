package main;

public class Game {
    private final int numberOfRounds;
    private final Player humanPlayer;
    private final Player computerPlayer;
    private final ScoreBoard scoreBoard;
    private final GameLogic gameLogic;
    private final DisplayResult displayResult;

    //Default Constructor
    public Game(int numberOfRounds, Player humanPlayer, Player computerPlayer, ScoreBoard scoreBoard, GameLogic gameLogic, DisplayResult displayResult) {
        this.numberOfRounds = numberOfRounds;
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.scoreBoard = scoreBoard;
        this.gameLogic = gameLogic;
        this.displayResult = displayResult;
    }


    /**
     * Begins and manages the entire game session
     */
    public void startGame() {
        System.out.println("**** Game Start ****\n");
        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.print("Round " + round + " - ");

            GameRound gameRound = new GameRound(humanPlayer, computerPlayer, gameLogic);
            computerPlayer.processRound(gameRound.getHumanMove(), gameRound.getComputerMove());
            Result roundResult = gameRound.getRoundResult();
            displayResult.printRoundResult(gameRound.getHumanMove(), gameRound.getComputerMove(), roundResult);
            scoreBoard.recordResult(roundResult);
            scoreBoard.displayScore();
        }
        Result gameResult = scoreBoard.getGameWinner();
        displayResult.printGameResult(gameResult);
    }

}
