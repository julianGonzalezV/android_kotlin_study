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

    fun passingArgsFromMain(arg: String){
        val hour = arg.toInt()
        println("Good"${if (hour > 12 )})

    }
}

fun main(args: Array<String>){
    Functions.dayOfWeek()
}