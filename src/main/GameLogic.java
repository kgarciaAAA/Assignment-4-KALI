package main;

public class GameLogic {

    /**
     * Determines the winner of a round between two players.
     * @param humanMove the human player's move
     * @param computerMove the computer player's move
     * @return DRAW = draw, HUMAN_WIN = human wins, COMPUTER_WIN = computer wins
     */
    public Result roundWinner(Move humanMove, Move computerMove) {
        if (humanMove == computerMove)
            return Result.DRAW;
        // A series of if statements to determine if the human wins. 
        boolean humanWins = (humanMove == Move.ROCK && computerMove == Move.SCISSORS) 
                            || (humanMove == Move.PAPER && computerMove == Move.ROCK)
                            || (humanMove == Move.SCISSORS && computerMove == Move.PAPER);

        return humanWins ? Result.HUMAN_WIN : Result.COMPUTER_WIN;
    }

    /**
     * Returns the move that would defeat the opponent's move.
     * @param opponentMove the move to check
     * @return Move that beats the opponent's move
     * @throws IllegalArgumentException if the move is invalid
     */
    public Move getWinningMove(Move opponentMove) {
        return switch (opponentMove) {
            case ROCK -> Move.PAPER;
            case PAPER -> Move.SCISSORS;
            case SCISSORS -> Move.ROCK;
            default -> throw new IllegalArgumentException("Invalid move");
        };
    }
    
}
