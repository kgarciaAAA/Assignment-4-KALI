package main;

public class ScoreBoard {
    private int humanScore;
    private int computerScore;
    private int draws;

    /**
     * Records the result of a round.
     * @param result DRAW = draw, HUMAN_WIN = human wins, COMPUTER_WIN = computer wins
     */
    public void recordResult(Result roundResult) {
        switch (roundResult) {
            case DRAW -> draws++;
            case HUMAN_WIN -> humanScore++;
            case COMPUTER_WIN -> computerScore++;
        }
    }

    /**
     * Displays the current score for human wins, computer wins, and draws.
     */
    public void displayScore() {
        System.out.printf("Score: Human: %s. Computer: %s. Draws: %s. \n\n", humanScore, computerScore, draws);
    }

    /**
     * Determines the winner of the game based comparisons between scores.
     * @return DRAW = draw, HUMAN_WIN = human won, COMPUTER_WIN = computer won
     */
    public Result getGameWinner() {
        if (humanScore > computerScore) {
            return Result.HUMAN_WIN;
        } else if (humanScore < computerScore) {
            return Result.COMPUTER_WIN;
        } else {
            return Result.DRAW;
        }
    }
}
