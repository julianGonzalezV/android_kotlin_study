package co.com.study.examples;

import javafx.util.Pair;
import kotlin.TuplesKt;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * Primera aprox
     * @param inputList
     * @return
     */
    static List<List> duplicatedAndNodupItemsStream(List<Integer> inputList){
        Set temSet = new HashSet();
        List nonDuplicated = new ArrayList();
        List duplicated = new ArrayList();
        inputList.stream().map(x -> {
            if(temSet.add(x)) nonDuplicated.add(x);
            else duplicated.add(x);
            return x;
        }).collect(Collectors.toList());

        return new ArrayList(){
            {
                add(duplicated);
                add(nonDuplicated);
            }
        };
    }
    static int mostRepeated(List<Integer> input){
        Set  set = new HashSet();
        Map map = new HashMap();
        for (Integer i:input) {
            map.put(i,1);
        }

        return 0;
    }

    public static void main (String ... args){
        System.out.println(duplicatedAndNodupItems(Arrays.asList(1,2,3,3,4,5,6,5,7,8)));
        System.out.println(duplicatedAndNodupItemsStream(Arrays.asList(1,2,3,3,4,5,6,5,7,8)));

    }
}
