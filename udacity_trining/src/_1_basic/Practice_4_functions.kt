package _1_basic

import java.util.*

object Functions {
   fun dayOfWeek(){
       val dOfW = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
       println(when(dOfW){
           0 -> "Lunes"
           1 -> "martes"
           2 -> "miercoles"
           3 -> "jueves"
           4 -> "viernes"
           5 -> "sabado"
           6 -> "domingo"
           else -> "Not in range"
       })
   }
}

fun main(args: Array<String>){
    Functions.dayOfWeek()
}