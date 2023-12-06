package org.lecture.dayOne;
import org.lecture.dayOne.AOCFileReader;

import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {

        /**
         * Day One *One
         */
        AOCFileReader aocReader = new AOCFileReader();
        LinkedHashSet<String> lines = aocReader.readLines("finalTwo.txt");
//        System.out.println("***Input:");
//        for(String s:lines)
//            System.out.println(s);
        System.out.print("***Calculated Number: ");
        System.out.println(aocReader.calculateSum(lines));

//        System.out.println("***Refectored Input:");
        lines = aocReader.replaceNumbers(lines);
//        for(String s:lines)
//            System.out.println(s);
        System.out.print("***Calculated Refectored Number: ");
        System.out.println(aocReader.calculateSum(lines));
    }
}