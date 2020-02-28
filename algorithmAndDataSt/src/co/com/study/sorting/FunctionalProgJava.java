package co.com.study.sorting;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Fuentes:
 * https://www.oracle.com/technetwork/es/articles/java/procesamiento-streams-java-se-8-2763402-esa.html
 */
public class FunctionalProgJava {

    static Double distanciaEntrePuntos(Double x1,Double y1,Double x2, Double y2){
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-x1,2));
    }

    static Integer factorial(Integer inputNumber){
        if(inputNumber == 0) return 1;
        else {
            return inputNumber * factorial(inputNumber-1);
        }
    }

    static void printList(List<Integer> list){
        if(!list.isEmpty()){
            System.out.println("n => "+list.get(0));
            printList(list.subList(1,list.size()));
        }
    }


    public static void main(String ... args){
        Punto p1 = new Punto(1,1);
        Punto p2 = new Punto(2,2);
        Punto p3 = new Punto(2,3);

        double dp1p2 = distanciaEntrePuntos(p1.getX(), p1.getY(), p2.getX(),p2.getY());
        double dp1p3 = distanciaEntrePuntos(p1.getX(), p1.getY(), p2.getX(),p2.getY());
        double dp3p3 = distanciaEntrePuntos(p1.getX(), p1.getY(), p2.getX(),p2.getY());
        double promedio = (dp1p2+dp1p3+dp3p3)/3;
        System.out.println("la el promedio de las distancias es"+promedio);

        System.out.println("hola, esto es una impresión sin for o while");
        printList(new ArrayList(){{
            add(1);
            add(15);
            add(30);
        }
        });


        System.out.println("Factorial = "+factorial(6));

        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
        stream.map(x -> factorial(x)).forEach(System.out::println);

        /**
         * Muy bacano: Ponga print en cada operacion y note como no se realiza todas las operaciones en
         * todos los numeros, esto es porque el limit acorta la operacoin y el es inteligente y sabe que
         * no debe seguir más
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> evensToFactorial =numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> factorial(n))
                .limit(2)//solo devuelve 2 :)
                .collect(Collectors.toList());
        System.out.println("evensToFactorial => "+evensToFactorial);


        //Punto1
        double x1 = 1;


    }

}

class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
