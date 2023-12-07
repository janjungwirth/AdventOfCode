package org.lecture.dayTwo;

import org.lecture.FileReader;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

        FileReader reader = new FileReader();
        Game game = new Game();
        LinkedHashSet<String> lines = reader.readLines("final.txt",2);

        int result=0;

        for(String line: lines){
            LinkedList<Boolean> valids = new LinkedList<>();
            //        Integer[] gameStatus = {0,0,0};
            Integer[] cubesInGame = {12, 13, 14};
            for (String s : game.getGameParts(line)) {
                valids.add(game.checkGame(game.getRGB(s), cubesInGame));
            }
            if (valids.contains(false))
                continue;
            result+=game.getID(line);
        }
        System.out.println("Result part One:" + result);
        result =0;
        for(String line: lines){
            LinkedList<String> parts = game.getGameParts(line);
//            System.out.println(parts);
            Integer[] smalestRGB = {0,0,0};

            smalestRGB = game.compareSmalestRGB(parts);

//            System.out.println(smalestRGB[0]+" "+smalestRGB[1]+" "+smalestRGB[2]);
            result+=smalestRGB[0]*smalestRGB[1]*smalestRGB[2];
        }
        System.out.println("Result part two:" + result);

    }
}
