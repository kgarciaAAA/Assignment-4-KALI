package main;

public class ComputerPlayer extends Player {
    private final ComputerStrategy strat;

    //Default Constructor
    public ComputerPlayer(ComputerStrategy strat) {
        this.strat = strat;
    }

    /**
     * Uses the random library to generate a random number from 0-2,
     * and returns a Move based on the number selected.
     * @return the computer's randomly selected move
     */
    @Override
    public Move getPlayerMove() {
        return strat.computerStrategyMove();
    }

    /**
     * Processes the result of a completed round by delegating round information to the strategy
     */
    @Override
    public void processRound(Move playerMove, Move computerMove) {
        strat.addGameRoundHistory(playerMove, computerMove);
    }

    /**
     * Triggers the strategy to persist any stored data.
     */
    @Override
    public void saveData(){
        strat.saveData();
    }
}
