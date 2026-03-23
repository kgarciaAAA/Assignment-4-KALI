package main;

public interface ComputerStrategy {
    Move computerStrategyMove();
    default void recordHumanMove(Move move) {}
    default void recordComputerMove(Move move) {}
}