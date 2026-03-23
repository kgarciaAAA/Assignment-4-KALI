package main;

public abstract class Player {
    public abstract Move getPlayerMove();
    public void addGameRoundHistory(Move playerMove, Move computerMove){}
    public void saveData(){}
}
