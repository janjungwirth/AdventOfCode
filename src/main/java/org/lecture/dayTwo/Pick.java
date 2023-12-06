package org.lecture.dayTwo;

import java.util.LinkedHashMap;

public class Pick {
    public LinkedHashMap<String, Integer> getPick(String line){

        LinkedHashMap<String, Integer> colors = new LinkedHashMap<>();
        String[] items = line.split(",");

        for(String s:items){
            if(s.contains("red"))
                colors.put("red", Integer.parseInt(s.replace("red", "").trim()));

            if(s.contains("green"))
                colors.put("green", Integer.parseInt(s.replace("green", "").trim()));


            if(s.contains("blue"))
                colors.put("blue", Integer.parseInt(s.replace("blue", "").trim()));
        }

        return colors;
    }

}
