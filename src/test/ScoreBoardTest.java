package test;

import main.ScoreBoard;
import main.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {

    @Test
    void testRecordResultCountsCorrectly() {
        ScoreBoard sb = new ScoreBoard();

        sb.recordResult(Result.HUMAN_WIN); // human win
        sb.recordResult(Result.COMPUTER_WIN); // computer win
        sb.recordResult(Result.DRAW); // draw
        sb.recordResult(Result.HUMAN_WIN); // human win

        // Winner should be human (2 vs 1)
        assertEquals(Result.HUMAN_WIN, sb.getGameWinner());
    }

    @Test
    void testGameWinnerDraw() {
        ScoreBoard sb = new ScoreBoard();

        sb.recordResult(Result.HUMAN_WIN); // human win
        sb.recordResult(Result.COMPUTER_WIN); // computer win

        // Draw (1 vs 1)
        assertEquals(Result.DRAW, sb.getGameWinner());
    }

    
    @Test
    void testGameWinnerComputerWins() {
        ScoreBoard sb = new ScoreBoard();

        sb.recordResult(Result.COMPUTER_WIN); // computer win
        sb.recordResult(Result.COMPUTER_WIN); // computer win
        sb.recordResult(Result.DRAW); // draw

        // Winner should be computer (2 vs 0)
        assertEquals(Result.COMPUTER_WIN, sb.getGameWinner());
    }
}
