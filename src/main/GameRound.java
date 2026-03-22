package main;

public class GameRound {
    private final Move humanMove;
    private final Move computerMove;
    private final Result roundResult;

    //Default Constructor
    public GameRound(Player humanPlayer, Player computerPlayer, GameLogic gameLogic) {
        humanMove = humanPlayer.getPlayerMove();
        computerMove = computerPlayer.getPlayerMove();
        this.roundResult = gameLogic.roundWinner(humanMove, computerMove);
    }


    //Getters
    public Move getHumanMove() {
        return humanMove;
    }

    public Move getComputerMove() {
        return computerMove;
    }

    public Result getRoundResult() {
        return roundResult;
    }

}
