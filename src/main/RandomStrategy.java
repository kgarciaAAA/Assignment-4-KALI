package main;
import java.util.Random;

public class RandomStrategy implements ComputerStrategy{
    private final Random randomNum = new Random();
    
    /**
     * Generates a random move for the computer.
     * @return a randomly selected Move
     */
    @Override
    public Move computerStrategyMove(){
        int computerMove = randomNum.nextInt(3);
        return Move.convertToMove(computerMove);
    }
    
}
