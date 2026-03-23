package main;

public enum Move {

    ROCK("""
        _______
    ---'   ____)
          (_____)
          (_____)
          (____)
    ---.__(___)
    """),


    PAPER("""
        _______
    ---'   ____)____
              ______)
              _______)
             _______)
    ---.__________)
    """),


    SCISSORS("""
        _______
    ---'   ____)____
              ______)
           __________)
          (____)
    ---.__(___)
    """);

    private final String art;

    /**
     * Constructor for a Move enum.
     * @param art The art representation of the move.
     */
    Move(String art) {
        this.art = art;
    }

    /**
     * Returns the art associated with this move.
     * @return String containing art of the move.
     */
    public String getArt() {
        return art;
    }

    /**
     * Converts an integer input into the corresponding Move.
     * @param choice integer (0 = ROCK, 1 = PAPER, 2 = SCISSORS)
     * @return the Move corresponding to the given choice
     * @throws IllegalArgumentException if choice is not 0, 1, or 2
     */
    public static Move convertToMove(int choice) {
        return switch (choice) {
            case 0 -> Move.ROCK;
            case 1 -> Move.PAPER;
            case 2 -> Move.SCISSORS;
            default -> throw new IllegalArgumentException("Invalid move");
        };
    }

    /**
     * Converts a string into the proper corresponding Move.
     * @param strMove string containing a move ("rock", "paper", or "scissors")
     * @return the Move corresponding to the string
     * @throws IllegalArgumentException if the string is not a valid move
     */
    public static Move convertFromString(String strMove) {
        return switch(strMove.toLowerCase()) {
            case "rock" -> Move.ROCK;
            case "paper" -> Move.PAPER;
            case "scissors" -> Move.SCISSORS;
            default -> throw new IllegalArgumentException("Invalid move");
        };
    }

    /**
     * Returns the name of the move with the first letter capitalized
     * and the rest in lowercase ("Rock", "Paper", "Scissors").
     * @return formatted name of the move
     */
    @Override
    public String toString() {
        String n = name();
        return n.charAt(0) + n.substring(1).toLowerCase();
    }
}