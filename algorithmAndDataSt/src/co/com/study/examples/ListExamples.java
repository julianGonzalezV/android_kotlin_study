package co.com.study.examples;

import javafx.util.Pair;
import kotlin.TuplesKt;

import java.util.*;

public class ListExamples {

    /**
     * Implementar que tienes una lista y el resultado sera 2 listas 1
     * con los repetidos y otra con los no repetidos
     * @param args
     */
    static List<List> duplicatedAndNodupItems(List<Integer> inputList){
        Set tempSet = new HashSet();
        List duplicatedItems = new ArrayList();
        List nonDuplicatedItems = new ArrayList();

        for (Integer i:inputList) {
            if(!tempSet.add(i)) duplicatedItems.add(i);
            else nonDuplicatedItems.add(i);
        }
        return new ArrayList(){{
            add(duplicatedItems);
            add(nonDuplicatedItems);
        }};
    }

    public static void main (String ... args){
        System.out.println(duplicatedAndNodupItems(Arrays.asList(1,2,3,3,4,5,6,5,7,8)));
    }
}
