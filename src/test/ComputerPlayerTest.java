
package test;

import main.ComputerPlayer;
import main.Move;
import java.util.HashSet;
import java.util.Set;

import main.RandomStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {

    @Test
    public void testRandomness(){
        ComputerPlayer computer = new ComputerPlayer(new RandomStrategy());
        Set<Move> previousMoves = new HashSet<>();
        // Make previousMoves a HashSet so it will store only unique values, no duplicates

        int attempts = 0;
        int maxAttempts = 1000;
        // Safety net

        while (previousMoves.size() < 3 && attempts < maxAttempts){
            Move move = computer.getPlayerMove();
            previousMoves.add(move);
            attempts++;
        }
        //Verify that each move was made at least once in 1000 or less trials
        assertTrue(previousMoves.contains(Move.ROCK), "Rock was not thrown");
        assertTrue(previousMoves.contains(Move.PAPER), "Paper was not thrown");
        assertTrue(previousMoves.contains(Move.SCISSORS), "Scissors was not thrown");
    }
}