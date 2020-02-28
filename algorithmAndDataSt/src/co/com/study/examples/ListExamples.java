package co.com.study.examples;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ListExamples {


    /**
     * Metodo para contar los elementos que están repetidos en la lista de
     * entrada input
     * @return
     */
    public static int example1(List<Integer> inputList){
        System.out.println("example1 Input  => "+inputList);
        /**
         * Por qué Set? R/ Porque ofrece el método add que retorna
         * si el elemento ya existía o no
         *
         */
        Set<Integer> set = new HashSet<>();
        int counter = 0;
        /*
        La funcion add del set retorna un booleano donde
        true: Si el elemento se insertó correctamente, dado que no existía
        false: contrario a lo anterior
         */
        for (Integer i: inputList ) {
            if(!set.add(i)){
                counter++;
            }
        }
        System.out.println("example1 Result => "+ set );

        System.out.println("example1 Result => "+ counter );
        return counter;
    }


    /**
     * Método que retorna un Map en donde el key es igual al elemento en la lista de entrada
     * y el value es la cantidad de veces que se repite el mismo elemento en la
     * lista de entrada
     * @param strList
     * @return
     */
    public static  Map<String, Integer> example2(  List<String> strList){
        System.out.println("example2 Input  => "+strList);
        /**
         * POr que treeMao?
         *
         */
        Map<String, Integer> map = new TreeMap<>();
        for (String i: strList ) {
            /*
             Note como la operacio put devuelve null si el Key no existía
             de lo contrario devuelve el valor del Key antes de ser actualizado
             */
            if(map.put(i, 1)!=null) map.replace(i, map.get(i)+1);
        }
        System.out.println("example2 Result => "+map);
        return map;
    }

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
        Map<Integer,HashSet> maR = new HashMap<>();
        map.forEach((k,v)->{
                  if(maR.containsKey(v)) {
                      HashSet value = maR.get(v);
                      value.add(k);
                      maR.put(v,value);
                  }else{
                      maR.put(v,new HashSet(){{add(k);}});
                  }
        });

       Integer val1 = Collections.max(maR.keySet());

        System.out.println("values"+maR);
        return (int) maR.get(val1).iterator().next();
    }


    static int mostRepeatedJava8(List<Integer> input){
        Map<Integer, Long> frecuenciaPorValor = input.stream().collect(groupingBy(Function.identity(), counting()));
        System.out.println(frecuenciaPorValor);
        return 0;
    }


    /**
     * Método que dado un array de enteros devuelve este ordenado pero ordenado por la cantidad de
     * veces que se repite (de mayor a menor)
     * Ejemplo
     * Dado [123452] el resultado será [134522]
     * @param arr
     * @return
     */
    public static Collection<ArrayList<Integer>> customSort(List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> valueFrecuency = arr.stream().collect(groupingBy(x -> x, summingInt(x ->1)));
        Map <Integer, ArrayList<Integer>> frecuencyValue = new TreeMap<>();
        valueFrecuency.forEach((key,value)-> frecuencyValue.put(value, new ArrayList()));
        arr.forEach(x->frecuencyValue.get(valueFrecuency.get(x)).add(x));
        frecuencyValue.values().stream().forEach(x -> x.sort(Comparator.naturalOrder()));
        frecuencyValue.values().stream().flatMap(x->x.stream()).forEach(System.out::println);
        return frecuencyValue.values();
    }

    /*
     * Complete the 'customSort' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */



    public static void main (String ... args){
        System.out.println(duplicatedAndNodupItems(Arrays.asList(1,2,3,3,4,5,6,5,7,8)));
        System.out.println(duplicatedAndNodupItemsStream(Arrays.asList(1,2,3,3,4,5,6,5,7,8)));
        System.out.println(mostRepeated(Arrays.asList(1,2,4,5,6,5,7,3,8,3)));
        System.out.println(mostRepeated(Arrays.asList(1,2,4,5,6,5,7,3,8,3)));
        System.out.println(":::::::customSort:::::::");
        System.out.println(customSort(Arrays.asList(1,2,3,4,5,2)));

        System.out.println(":::::::mostRepeatedJava8:::::::");
        System.out.println(mostRepeatedJava8(Arrays.asList(1,2,4,5,6,5,7,3,8,3)));

        List l1 = Arrays.asList(1,2,4,5,6,5,7,3,8,3);
        l1.sort(Comparator.naturalOrder());
        System.out.println("Sorted"+l1);
    }
}
