package org.lecture.dayTwo;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Game {
    public Integer getID(String line){
        return Integer.parseInt(line.split(":")[0].substring(5));
    }

    public LinkedList<String> getGameParts(String lines){
        LinkedList<String> parts = new LinkedList<>();
        lines = lines.split(":")[1].trim();

        for(String s: lines.split(";")){
            parts.add(s.trim());
        }
        return parts;

    }

    public Integer[] getRGB(String line){
        Integer[] rgb = {0,0,0};
        String[] elements = line.split(",");

        int index=0;
        for(String s:elements){
            if(s.contains("red"))
                rgb[0]=Integer.parseInt(s.replace("red","").trim());
            if(s.contains("green"))
                rgb[1]=Integer.parseInt(s.replace("green","").trim());
            if(s.contains("blue"))
                rgb[2]=Integer.parseInt(s.replace("blue","").trim());
        }
        return rgb;

    }


    public boolean checkGame(Integer[] rgbCurrent, Integer[] rgbCheck){
        return rgbCheck[0]>=rgbCurrent[0] && rgbCheck[1]>=rgbCurrent[1] && rgbCheck[2]>=rgbCurrent[2];
    }


    public Integer[] compareSmalestRGB(LinkedList<String> parts) {
        Integer[] rgb = {-1,-1,-1};
        LinkedList<String> elements = new LinkedList<>();
        for(String s: parts)
            elements.addAll(Arrays.stream(s.split(",")).toList());

        for(String s:elements){
            if(s.contains("red")){
                Integer i = Integer.parseInt(s.replace("red","").trim());
                rgb[0] = (rgb[0] > i) ? rgb[0]  : i;
            }
            if(s.contains("green")){
                Integer i = Integer.parseInt(s.replace("green","").trim());
                rgb[1] = (rgb[1] > i) ? rgb[1]  : i;
            }
            if(s.contains("blue")){
                Integer i = Integer.parseInt(s.replace("blue","").trim());
                rgb[2] = (rgb[2] > i) ? rgb[2]  : i;
            }
        }
        return rgb;
    }
}
