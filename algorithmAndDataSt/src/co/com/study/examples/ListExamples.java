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
        Set nonDuplicatedItems = new HashSet();
        Set duplicatedItems = new HashSet();

        for (Integer i:inputList) {
            if(!tempSet.add(i)) {
                duplicatedItems.add(i);
            }
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
        Set nonDuplicated = new HashSet();
        Set duplicated = new HashSet();
        inputList.stream().map(x -> {
            if(temSet.add(x))nonDuplicated.add(x);

            else {
                duplicated.add(x);
                nonDuplicated.remove(x);
            }
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
        Map<Integer,Integer> map = new HashMap();
        for (Integer i:input) {
            Integer val = map.remove(i);
            map.put(i, (val != null)? val+1: 1);
        }
        map.keySet();
        System.out.println("map"+map);
        /*Map<Integer, Integer> sortedIdNameMap
                = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
*/
        Map<Integer,ArrayList> maR = new HashMap<>();
        map.forEach((k,v)->{
                  if(maR.containsKey(v)) {
                      ArrayList value = maR.get(v);
                      value.add(k);
                      maR.put(v,value);
                  }else{
                      maR.put(v,new ArrayList(){{add(k);}});
                  }
        });

        System.out.println("values"+maR);
        return 0;
    }

    public static void main (String ... args){
        System.out.println(duplicatedAndNodupItems(Arrays.asList(1,2,3,3,4,5,6,5,7,8)));
        System.out.println(duplicatedAndNodupItemsStream(Arrays.asList(1,2,3,3,4,5,6,5,7,8)));
        System.out.println(mostRepeated(Arrays.asList(1,2,3,3,4,5,6,5,7,8)));


    }
}
