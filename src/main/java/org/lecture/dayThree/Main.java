package org.lecture.dayThree;

import org.lecture.FileReader;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        LinkedHashSet<String> lines = reader.readLines("final.txt", 3);

        char[][] plan = new char[140][140];
        char[][] lookupTable = new char[140][140];
//        char[][] gearTable = new char[140][140];

        int counter=0;
        for(String s: lines){
            plan[counter]=s.toCharArray();
//            System.out.println(plan[counter]);
            counter++;
        }

        for(int y=0;y<140;y++){
            for(int x=0;x<140;x++){
                lookupTable[y][x]=lookupTable[y][x]!='C'?plan[y][x]:lookupTable[y][x];
//                gearTable[y][x]=gearTable[y][x]!='C'?plan[y][x]:gearTable[y][x];
                if(plan[y][x]=='*' || plan[y][x]=='#' || plan[y][x]=='+' || plan[y][x]=='$'
                        || plan[y][x]=='@'||  plan[y][x]=='/'|| plan[y][x]=='&'
                        || plan[y][x]=='-'|| plan[y][x]=='%'|| plan[y][x]=='=') {
//                    System.out.println(" "+plan[y - 1][x - 1] + plan[y - 1][x] + plan[y - 1][x + 1]);
//                    System.out.println(" "+plan[y][x - 1] + plan[y][x] + plan[y][x + 1]);
//                    System.out.println(" "+plan[y + 1][x - 1] + plan[y + 1][x] + plan[y + 1][x + 1]);
//                    System.out.println();


//                    System.out.println(" "+isNumber(plan[y - 1][x - 1]) + isNumber(plan[y - 1][x]) + isNumber(plan[y - 1][x + 1]));
//                    System.out.println(" "+isNumber(plan[y][x - 1]) + plan[y][x] + isNumber(plan[y][x + 1]));
//                    System.out.println(" "+isNumber(plan[y + 1][x - 1]) + isNumber(plan[y + 1][x]) + isNumber(plan[y + 1][x + 1]));
//                    System.out.println();

                    lookupTable[y-1][x-1] = isNumber(plan[y - 1][x - 1])?'C':'.';
                    lookupTable[y-1][x] = isNumber(plan[y - 1][x])?'C':'.';
                    lookupTable[y-1][x+1] = isNumber(plan[y - 1][x + 1])?'C':'.';

                    lookupTable[y][x-1] = isNumber(plan[y][x - 1])?'C':'.';
                    lookupTable[y][x] = isNumber(plan[y][x])?'C':plan[y][x];
                    lookupTable[y][x+1] = isNumber(plan[y][x + 1])?'C':'.';

                    lookupTable[y+1][x-1] = isNumber(plan[y + 1][x - 1])?'C':'.';
                    lookupTable[y+1][x] = isNumber(plan[y + 1][x])?'C':'.';
                    lookupTable[y+1][x+1] = isNumber(plan[y + 1][x + 1])?'C':'.';
                }
/*TODO Gear ration
                gearTable[y][x]=gearTable[y][x]!='C'?plan[y][x]:gearTable[y][x];
                if(plan[y][x]=='*') {
//                    System.out.println(" "+plan[y - 1][x - 1] + plan[y - 1][x] + plan[y - 1][x + 1]);
//                    System.out.println(" "+plan[y][x - 1] + plan[y][x] + plan[y][x + 1]);
//                    System.out.println(" "+plan[y + 1][x - 1] + plan[y + 1][x] + plan[y + 1][x + 1]);
//                    System.out.println();


//                    System.out.println(" "+isNumber(plan[y - 1][x - 1]) + isNumber(plan[y - 1][x]) + isNumber(plan[y - 1][x + 1]));
//                    System.out.println(" "+isNumber(plan[y][x - 1]) + plan[y][x] + isNumber(plan[y][x + 1]));
//                    System.out.println(" "+isNumber(plan[y + 1][x - 1]) + isNumber(plan[y + 1][x]) + isNumber(plan[y + 1][x + 1]));
//                    System.out.println();

                    gearTable[y-1][x-1] = isNumber(plan[y - 1][x - 1])?'C':'.';
                    gearTable[y-1][x] = isNumber(plan[y - 1][x])?'C':'.';
                    gearTable[y-1][x+1] = isNumber(plan[y - 1][x + 1])?'C':'.';

                    gearTable[y][x-1] = isNumber(plan[y][x - 1])?'C':'.';
                    gearTable[y][x] = isNumber(plan[y][x])?'C':plan[y][x];
                    gearTable[y][x+1] = isNumber(plan[y][x + 1])?'C':'.';

                    gearTable[y+1][x-1] = isNumber(plan[y + 1][x - 1])?'C':'.';
                    gearTable[y+1][x] = isNumber(plan[y + 1][x])?'C':'.';
                    gearTable[y+1][x+1] = isNumber(plan[y + 1][x + 1])?'C':'.';
                }
*/

            }
        }
        //        System.out.println(plan[5][7]);
     /*   for(char[] c: gearTable){
            for(char cc: c)
                System.out.print(cc);
            System.out.println();
        }*/

//        //Print lookip Table
//        for(char[] c: lookupTable){
//            for(char cc : c){
//                System.out.print(""+cc);
//            }
//            System.out.println();
//        }

        LinkedHashMap<Integer, String> planMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> planMapLookup = new LinkedHashMap<>();

        int id=0;
        for(char[] c: plan){

            String tempString = String.valueOf(c);
            String[] tempStrings = tempString.split("[.*#$@+/&%=]");
//            System.out.println(tempStrings);
//            for(String y:tempStrings)
//                System.out.println(y);

            for(String s:tempStrings){
                if( s.isEmpty() || s.equals("*") ||  s.equals("#") ||  s.equals("$") ||  s.equals("@") ||
                        s.equals("+")||  s.equals("/")||  s.equals("&")||  s.equals("-")||  s.equals("%") ||  s.equals("="))
                    continue;
                planMap.put(id,s
                        .replace("*","")
                        .replace("#","")
                        .replace("$","")
                        .replace("+","")
                        .replace("/","")
                        .replace("&","")
                        .replace("-","")
                        .replace("%","")
                        .replace("=","")
                        .replace("@",""));
                id++;
            }
        }
        id=0;
        for(char[] c: lookupTable){
            String tempString = String.valueOf(c);
            String[] tempStrings = tempString.split("[.]");
//            System.out.println(tempStrings);
//            for(String y:tempStrings)
//                System.out.println(y);
//
            for(String s:tempStrings){
                if(s.isEmpty() || s.equals("*") ||  s.equals("#") ||  s.equals("$") || s.equals("@") ||
                        s.equals("+")||  s.equals("/")||  s.equals("&")||  s.equals("-")||  s.equals("%")||  s.equals("="))
                    continue;
                planMapLookup.put(id,s
                        .replace("*","")
                        .replace("#","")
                        .replace("$","")
                        .replace("+","")
                        .replace("/","")
                        .replace("&","")
                        .replace("-","")
                        .replace("%","")
                        .replace("=","")
                        .replace("@",""));
                id++;
            }
        }
//        System.out.println(planMap);
//        System.out.println(planMapLookup);
        int result=0;
        for(Map.Entry s: planMapLookup.entrySet()){
            if(String.valueOf(s.getValue()).contains("C")){
                result+=Integer.parseInt(planMap.get(s.getKey()));
            }
        }
        System.out.println("Result part One: " + result);
    }



    public static boolean isNumber(Character c){
        return c>=48&&c<=58;
    }
    
}
