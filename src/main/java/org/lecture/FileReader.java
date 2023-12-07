package org.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;

public class FileReader {
    public LinkedHashSet<String> readLines(String fileName, int day){
        LinkedHashSet<String> lines = new LinkedHashSet<>();
        Path path = Paths.get("src","main", "resources" , day+"", fileName);

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
}
