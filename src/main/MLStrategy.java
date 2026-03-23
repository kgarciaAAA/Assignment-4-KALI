package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class MLStrategy implements ComputerStrategy {
    
    private final int PATTERN_SIZE = 4; // allows people to choose the amount of moves in a pattern

    private final HashMap<List<Move>, int[]> moveFrequency;
    private final Queue<Move> moveHistory;
    private final GameLogic gameLogic;

    public MLStrategy() {
        this.moveFrequency = new HashMap<>();
        this.moveHistory = new LinkedList<>();
        this.gameLogic = new GameLogic();
    }

    @Override
    public Move computerStrategyMove() {
        Move computerMove;

        // If the move history is the same as the pattern size, we can try topredict the next move
        if (moveHistory.size() == PATTERN_SIZE) {
            List<Move> key = buildKey();
            Move predicted = getExpectedPlayerMove(key);
            // get random move if pattern first encountered, else ask gameLogic to get the winning move
            computerMove = (predicted == null) ? getRandomMove() : gameLogic.getWinningMove(predicted);
        } else {
            computerMove = getRandomMove();
        }

        return computerMove;
    }

    public void addGameRoundHistory(Move humanMove, Move computerMove) {

        // If the move history is the same as the pattern size, we can update the move frequency
        if (moveHistory.size() == PATTERN_SIZE) {
            List<Move> key = buildKey();
            int[] freq = moveFrequency.computeIfAbsent(key, k -> new int[3]); // create a new array if the pattern is not found
            freq[humanMove.ordinal()]++; // increment the frequency of the human move RPS order (0 = Rock, 1 = Paper, 2 = Scissors)
        }

        updateMoveHistory(humanMove);
        updateMoveHistory(computerMove);        
    }

    private Move getExpectedPlayerMove(List<Move> key) {
        int[] freq = moveFrequency.get(key);
        if (freq == null) return null;

        int maxFreq = 0;
        int maxIndex = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxIndex = i;
            }
        }

        return (maxIndex == -1) ? null : Move.values()[maxIndex];
    }

    

    private List<Move> buildKey() {
        return new ArrayList<>(moveHistory);
    }

    private void updateMoveHistory(Move move) {
        moveHistory.add(move);
        if (moveHistory.size() > PATTERN_SIZE) {
            moveHistory.poll();
        }
    }

    private Move getRandomMove() {
        return Move.convertToMove(new Random().nextInt(3));
    }
}
