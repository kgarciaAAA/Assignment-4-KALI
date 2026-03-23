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

    public void recordHumanMove(Move humanMove) {

    }

    public void recordComputerMove(Move computerMove) {

    }
}
