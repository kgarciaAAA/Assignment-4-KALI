package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class MLStrategy implements ComputerStrategy {
    
    private final int PATTERN_SIZE = 4; // the amount of moves considered in a pattern
    
    private final GameLogic gameLogic;
    private final GameData gameData;
    private final HashMap<List<Move>, int[]> moveFrequency; // key = move history, value = frequency of the moves
    private final Queue<Move> moveHistory; // queue of the move history
    
    /**
     * Constructor for the MLStrategy class.
     * @param gameData the stored game data to be uploaded to the ML 
     */
    public MLStrategy(GameData gameData) {
        this.gameLogic = new GameLogic();
        this.gameData = gameData;
        this.moveFrequency = gameData.loadData();
        this.moveHistory = new LinkedList<>();
    }

    /**
     * Uses the move frequency to predict the next move.
     * @return the computer's predicted move based on the move frequency
     */
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

    /**
     * Adds the move history of the round to the queue and updates the move frequency.
     * @param humanMove the human player's move
     * @param computerMove the computer player's move
     */
    @Override
    public void addGameRoundHistory(Move humanMove, Move computerMove) {

        // If the move history is the same as the pattern size, we can update the move frequency
        if (moveHistory.size() == PATTERN_SIZE) {
            List<Move> key = buildKey();
            int[] freq = moveFrequency.computeIfAbsent(key, k -> new int[3]); // create a new array if the pattern is not found
            freq[humanMove.ordinal()]++; // increment the frequency of the human move RPS order (0 = Rock, 1 = Paper, 2 = Scissors)
        }
        // Safely update the move history queue by adding the new moves
        updateMoveHistory(humanMove);
        updateMoveHistory(computerMove);        
    }
    
    /**
     * Looks up the expected player move based on the move frequency. 
     * If the pattern is not found, returns null.
     * @param key the key of the move history (list of moves)
     * @return the expected player move based on the move frequency
     */
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

    
    /**
     * Builds the key of the move history.
     * @return a list of the last 4 moves in the move history
     */
    private List<Move> buildKey() {
        return new ArrayList<>(moveHistory);
    }
    
    /**
     * Updates the move history queue by adding the new move and removing the oldest move if the queue is full.
     * Utilizes PATTERN_SIZE to determine the size of the queue.
     * @param move the new move to be added to the move history
     */
    private void updateMoveHistory(Move move) {
        moveHistory.add(move);
        if (moveHistory.size() > PATTERN_SIZE) {
            moveHistory.poll();
        }
    }

    /**
     * Generates a random move.
     * @return a random move
     */
    private Move getRandomMove() {
        return Move.convertToMove(new Random().nextInt(3));
    }

    /**
     * Saves the move frequency to the game data.
     */
    @Override
    public void saveData() {
        gameData.saveData(moveFrequency);
    }
}
