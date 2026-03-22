package main;

public class DisplayResult {
    /**
     * Prints what each player chose and the round outcome.
     * @param result DRAW = draw, HUMAN_WIN = human wins, COMPUTER_WIN = computer wins
     */
    public void printRoundResult(Move humanMove, Move computerMove, Result roundResult) {
        System.out.println("You chose " + humanMove + ":");
        System.out.println(humanMove.getArt());

        System.out.println("Computer chose " + computerMove + ":");
        System.out.println(computerMove.getArt());

        switch (roundResult) {
            case DRAW -> System.out.println("Draw!");
            case HUMAN_WIN -> System.out.println("You Win!");
            case COMPUTER_WIN -> System.out.println("Computer Wins!");
        }
    }

    /**
     * Prints the overall winner of the game.
     * @param gameResult DRAW = draw, HUMAN_WIN = human wins, COMPUTER_WIN = computer wins
     */
    public void printGameResult(Result gameResult) {
        switch(gameResult) {
            case DRAW -> System.out.println("****** Draw. Nobody wins. ******");
            case HUMAN_WIN -> System.out.println("****** Human Wins the Game ******");
            case COMPUTER_WIN -> System.out.println("****** Computer Wins the Game ******");
        }
    }
}
