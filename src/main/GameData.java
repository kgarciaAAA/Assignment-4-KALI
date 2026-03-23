package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GameData {
    private final HashMap<List<Move>, int[]> moveFrequency = new HashMap<>();

    public HashMap<List<Move>, int[]> loadData(){
        try {
            Scanner scanner = new Scanner(new File("data.txt"));
                while (scanner.hasNextLine()) {
                    List<Move> key = new ArrayList<>();
                    String movesLine = scanner.nextLine();
                    String[] stringMoves = movesLine.split(",");
                    for (String string : stringMoves) 
                        key.add(Move.convertFromString(string));

                    String freqLine = scanner.nextLine();
                    String[] freqStrings = freqLine.split(",");
                    int[] freq = new int[3];
                    for (int i = 0; i < 3; i++) {
                        freq[i] = Integer.parseInt(freqStrings[i]);
                    }
                    moveFrequency.put(key, freq);
                }
                scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading data. File cannot be found");
        }
        return moveFrequency;
    }

    public void saveData(HashMap<List<Move>, int[]> updatedMoveFrequency) {
        try {
            PrintWriter write = new PrintWriter(new File("data.txt"));
            for (List<Move> key : moveFrequency.keySet()) {
                for (int i = 0; i < key.size(); i++) {
                    write.print(key.get(i).name());
                    if (i < key.size() - 1) {
                        write.print(",");
                    }
                }
                write.println();

            int[] freq = moveFrequency.get(key);
            write.println(freq[0] + "," + freq[1] + "," + freq[2]);
            }
            write.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error saving data. File not found.");
        }
    }

}
