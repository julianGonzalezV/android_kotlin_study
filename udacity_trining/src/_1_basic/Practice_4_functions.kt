package _1_basic

import java.util.*

object Functions {
   fun dayOfWeek(){
       val dOfW = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
       println(dOfW)
       println(when(dOfW){
           2 -> "Lunes"
           3 -> "martes"
           4 -> "miercoles"
           5 -> "jueves"
           6 -> "viernes"
           7 -> "sabado"
           1 -> "domingo"
           else -> "Not in range"
       })
   }

    fun passingArgsFromMain(arg:  Array<String>){
        println("Valor que se pasa por argumentos o run>>editconfiguration>>program argumentgs ---> ${arg[0]}")
        println("Good ${if(arg[0].toInt() < 12) "Morning" else "Afternoon"}")

    }
}

fun main(args: Array<String>){
    Functions.dayOfWeek()
    Functions.passingArgsFromMain(args)
}