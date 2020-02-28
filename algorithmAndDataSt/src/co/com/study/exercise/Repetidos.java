package co.com.study.exercise;

import java.util.*;

public class Repetidos {
    public static int numMasPopular(  List<Integer> strList, int size){
        System.out.println("example2 Input  => "+strList);
        /**
         * POr que treeMao?
         *
         */
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer i: strList ) {
            /*
             Note como la operacio put devuelve null si el Key no existía
             de lo contrario devuelve el valor del Key antes de ser actualizado
             */
            if(map.put(i, 1)!=null) map.replace(i, map.get(i)+1);
        }
        int key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Map es  => "+map);
        System.out.println("example2 Result => "+key);
        return key;
    }

    public static void main(String ... args){
        numMasPopular( Arrays.asList(1,2,2,2,3,3,3,3,3,3,4),9);

    }
}


