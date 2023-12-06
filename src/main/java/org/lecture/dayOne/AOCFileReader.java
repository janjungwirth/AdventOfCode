package org.lecture.dayOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;

public class AOCFileReader {
    public LinkedHashSet<String> readLines(String fileName){
        LinkedHashSet<String> lines = new LinkedHashSet<>();
        Path path = Paths.get("src","main", "resources" , "1", fileName);

        if(Files.notExists(path))
            return lines;

        try(BufferedReader reader = Files.newBufferedReader(path)) {
            lines.addAll(reader.lines().toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }finally{
            return lines;
        }
    }

    public int calculateSum(LinkedHashSet<String> lines){
        int calculate=0;
            for(String s:lines){
                char[] chars = s.toCharArray();
                //von anfang
                for(Character c:chars){
                    if(c>=48&&c<=58){
                        calculate+=(c-48)*10;
//                        System.out.print("b: "+(c-48));

                        break;
                    }
                }

                //von ende
                for(int i=chars.length-1;i>=0;i--){
                    if(chars[i]>=48&&chars[i]<=58){
                        calculate+=(chars[i]-48);
//                        System.out.println(" e: "+(chars[i]-48));
                        break;
                    }
                }
//                System.out.println(calculate);
            }
        return calculate;
    }

    public LinkedHashSet<String> replaceNumbers(LinkedHashSet<String>lines){
        LinkedHashSet<String> newLines = new LinkedHashSet<>();
            for(String s:lines){

                s=s.replaceAll("zero","z0ero");
                s=s.replaceAll("one","o1ne");
                s=s.replaceAll("two","t2wo");
                s=s.replaceAll("three","t3hree");
                s=s.replaceAll("four","f4our");
                s=s.replaceAll("five","f5ive");
                s=s.replaceAll("six","s6ix");
                s=s.replaceAll("seven","s7even");
                s=s.replaceAll("eight","e8ight");
                s=s.replaceAll("nine","n9ine");

                newLines.add(s);
            }
        return newLines;
    }
}
