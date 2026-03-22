package test;

import main.GameLogic;
import main.Move;
import main.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    private final GameLogic logic = new GameLogic();

    @Test
    void testDraws() {
        assertEquals(Result.DRAW, logic.roundWinner(Move.ROCK, Move.ROCK)); // Both Throw Rock
        assertEquals(Result.DRAW, logic.roundWinner(Move.PAPER, Move.PAPER)); // Both Throw Paper
        assertEquals(Result.DRAW, logic.roundWinner(Move.SCISSORS, Move.SCISSORS)); // Both Throw Scissors
    }

    @Test
    void testHumanWinsCases() {
        assertEquals(Result.HUMAN_WIN, logic.roundWinner(Move.ROCK, Move.SCISSORS)); // Human = Rock, Computer = Scissors, expect Human Win
        assertEquals(Result.HUMAN_WIN, logic.roundWinner(Move.PAPER, Move.ROCK)); // Human = Paper, Computer = Rock, expect Human Win
        assertEquals(Result.HUMAN_WIN, logic.roundWinner(Move.SCISSORS, Move.PAPER)); // Human = Scissors, Computer = Paper, expect Human Win
    }

    @Test
    void testComputerWinsCases() {
        assertEquals(Result.COMPUTER_WIN, logic.roundWinner(Move.ROCK, Move.PAPER));  // Human = Rock, Computer = Paper, expect Computer Win
        assertEquals(Result.COMPUTER_WIN, logic.roundWinner(Move.PAPER, Move.SCISSORS)); // Human = Paper, Computer = Scissors, expect Computer Win
        assertEquals(Result.COMPUTER_WIN, logic.roundWinner(Move.SCISSORS, Move.ROCK)); // Human = Scissors, Computer = Rock, expect Computer Win
    }
}
