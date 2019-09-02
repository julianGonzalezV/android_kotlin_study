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

    fun feedTheFish(){
        val day = randomDay()
        val food = fishFood(day)
        println("Today is $day and the fish eats $food ")
    }

    fun randomDay():String{
        //val day = (0..)
        val week = listOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sábado","Domingo")
        //return week.get((0..6).random())
        //Acá 7 es excluido
        return week.get(Random().nextInt(7))
    }
    fun fishFood(day: String):String{
        val foodMap = mapOf("Lunes" to "flakes",
        "Martes" to "frijoles",
        "Miercoles" to "mondongo",
        "Jueves" to "lentejas",
        "Viernes" to "garbanzo",
        "Sabado" to "sopa",
        "Domingo" to "hamburguesa")
        return foodMap[day]?:"Not found"
    }

    fun getFortuneCookie():String{
        val mensaje = listOf("You will have a great day!","Things will go well for you today.","Enjoy a wonderful day of success",
                "Be humble and all will turn out well.","Today is a good day for exercising restraint.","Take it easy and enjoy life!"
                ,"Treasure your friends because they are your greatest fortune.")
        print("Enter your birthday:")
        val birthday = readLine()?.toIntOrNull()?:0
        return mensaje[birthday.rem(mensaje.size)]
    }

    /**
     * Versiòn mejorada porque no le corresponde calcular el birthay o recibirlo
     * en su lugar usa a la funcion getBirthday()
     */
    fun getFortuneCookie2():String{
        val mensaje = listOf("You will have a great day!","Things will go well for you today.","Enjoy a wonderful day of success",
                "Be humble and all will turn out well.","Today is a good day for exercising restraint.","Take it easy and enjoy life!"
                ,"Treasure your friends because they are your greatest fortune.")
        print("Enter your birthday:")
        when(getBirthday()){
            in 28..31 -> return mensaje[2]
            in 0..7 -> return mensaje[4]
            else -> return mensaje[getBirthday().rem(mensaje.size)]
        }
    }

    fun getBirthday():Int{
        val birthday = readLine()?.toIntOrNull()?:0
        return birthday
    }

    fun runNTime(n:Int){
        for (i in  0..n){
            val message = getFortuneCookie2()
            if (message.contains("Take it easy")){
                println("Congrats $message has been selected ")
                break
            }
        }
        println("End")
    }

    /**
     * Note que si usted no pasa un valor entonces "fast serà el valor por defecto"
     */
    fun swim(speed:String = "fast"){
        println("Swimming $speed")
    }

}

fun main(args: Array<String>){
    Functions.dayOfWeek()
    Functions.passingArgsFromMain(args)
    Functions.feedTheFish()
    //print("day is => "+Functions.randomDay())
    //deshabilite para que prueba :)
    // Functions.runNTime(4)

    /**
     * Sin paràmetros
     * Note como imprime fast
     */
    Functions.swim()

    /**
     * Con paràmetros
     */
    Functions.swim("leento")

}