package _1_basic

import java.util.*
import kotlin.math.*

class ArrysAndLoops{

    /**
     * Mutable list assigned to a inmutable variable
     */
    fun mmutableList(){
        val list1 = mutableListOf("a","b","c")
        //list1 = mutableListOf("d","e") // No se permite sobre val
        /**
         *
         * Peeero si permite
         */
        list1.remove("c")
        println("mmutableList:::::list1 => "+list1)
    }

    fun immutableList(){
        val list1 = listOf("a","b","c")
        //list1 = mutableListOf("d","e") // No se permite sobre val
        /**
         *
         * Acá no se permite   el remove por ser un immutable list
         */
        //list1.remove("c")
        print("InmmutableList:::::list1 => "+list1)
    }


    fun arrayElem(){
        println("::::::arrayElem::::::::.")
        //por inferencia
        val l1 = arrayOf("a","b","c")

        //Tipado
        val l2 = intArrayOf(1,2,3)

        //val l3 = Arrays.toString(intArrayOf(1,2,"3")) no va a funcionar porque como lo tipamos entonces
        // no acepta el string de entrada
        val l4 = Arrays.toString(arrayOf(1,2,"3")) // si funciona porque no está tipado
        println(l4)

        val arrayOfArray = arrayOf(l1,l2)
        println("arrayOfArray => "+arrayOfArray)
        val arrayOfArray2 = arrayOf(Arrays.toString(l1),Arrays.toString(l2))
        println("Printable arrayOfArray2 => "+Arrays.toString(arrayOfArray2))
    }

    fun dynamicArrayElem() {
        println("::::::dynamicArrayElem::::::::.")
        val arr1 = Array(5){}
        /**
         * Note que cada registro en el array es de tipo unit
         */
        println("arr1=> "+Arrays.toString(arr1))

        /**
         * AHOra si el dinamismo :)
         */
        val arr2 = Array(6){it * 2} // a cada elemento lo multiplica por 2, es como un map en functional programming
        println("arr2=> "+Arrays.toString(arr2))
        /**
         * Para evitar lo engorroso del array.tostr use asList
         */
        println("arr2 as list => "+arr2.asList())


    }

    fun loops(){
        println("::::::loops::::::::.")
        val arr1 = arrayListOf("a","e","i")
        for (ele in arr1){
            println(ele)
        }

        println("::::::loops tuple::::::::.")
        /**
         * Ojo importante decirle withIndex para que funcione
         */
        for ((i,e) in arr1.withIndex()){
            println("$i - $e")
        }

        println("::::::Ranges::::::::.")
        for (i in 'b'..'f') println(i)
        for (i in 1..4) println(i)

        println("::::::Ranges downwards::::::::.")
        for (i in 'f' downTo 'b') println(i)

        println("::::::Ranges steps::::::::.")
        for(i in  3..9 step 2) println(i)
    }

    /**
     * Read the code below, and then select the correct array initialization that will display
     * the corresponding output
     *  1 byte = 1 bytes
        1 kilobyte = 1000 bytes
        1 megabyte = 1000000 bytes
        1 gigabyte = 1000000000 bytes
        1 terabyte = 1000000000000 bytes
        1 petabyte = 1000000000000000 bytes
        1 exabyte = 1000000000000000000 bytes
     */
    fun question1(){
        println("Quiz: Arrays and Loops::::::::::")
        //val array = ???
        val v1 = 1000.0
        val array = Array(7){ v1.pow(it) }
        val sizes = arrayOf("byte", "kilobyte", "megabyte", "gigabyte",
                "terabyte", "petabyte", "exabyte")
        for ((i, value) in array.withIndex()) {
            println("1 ${sizes[i]} = ${value.toLong()} bytes")
        }
    }

    /**
     * How can you use a for loop to create (a list of)
     * the numbers between 0 and 100 that are divisible by 7?
     */
    fun question2() {
        println("Quiz: question2::::::::::")
        val list1 = mutableListOf<Int>()
        for (i in  0..100 step 7){
            list1.add(i)

        }
        println("question2 => "+list1)
    }

}
fun main(args: Array<String>){
    ArrysAndLoops().mmutableList()
    ArrysAndLoops().immutableList()
    ArrysAndLoops().arrayElem()
    ArrysAndLoops().dynamicArrayElem()
    ArrysAndLoops().loops()
    ArrysAndLoops().question1()
    ArrysAndLoops().question2()

}