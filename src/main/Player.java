package main;

public abstract class Player {
    public abstract Move getPlayerMove();
    public void processRound(Move playerMove, Move computerMove){}
    public void saveData(){}
}
