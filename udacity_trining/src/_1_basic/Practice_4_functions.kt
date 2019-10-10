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
        print("Today is $day and the fish eats $food ")
        if(shouldChangeWater(day)) println(" And you have to Change the water")
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
     * Versiòn mejorada porque no le corresponde calcular el birthday o recibirlo
     * en su lugar usa a la funcion getBirthday()
     */
    fun getFortuneCookie2():String{
        val mensaje = listOf("You will have a great day!","Things will go well for you today.","Enjoy a wonderful day of success",
                "Be humble and all will turn out well.","Today is a good day for exercising restraint.","Take it easy and enjoy life!"
                ,"Treasure your friends because they are your greatest fortune.")
        print("Enter your birthday: mensaje.size)"+mensaje.size)
        val bDay = getBirthday()
        val indx = when(bDay){
            in 28..31 ->  2
            in 0..7 ->  4
            else ->  bDay.rem(mensaje.size)
        }
        return mensaje[indx]
    }

    fun getBirthday():Int{
        val birthday = readLine()?.toIntOrNull()?:0
        print("birthday is ${birthday}")
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
     * Note que si usted no pasa un valor para speed
     * entonces "fast serà el valor por defecto"
     */
    fun swim(time:Int, speed:String = "fast"){
        println("Swimming $time - $speed")
    }

    /**
     * función para saber si se debe cambiar el agua a los peces
     */
    fun shouldChangeWater(day:String, temperature:Int = 22, dirty:Int = 20):Boolean{
        return true
    }

    fun canAddFish(tankSize:Int, currentFish:List<Int>, fishSize:Int, hasDecorations:Boolean):Boolean{

        return true
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
     * Note como imprime el valor por defecto en la firma del método
     */
    Functions.swim(100)

    /**
     * Con paràmetros
     */
    Functions.swim(5,"leento")

   // Functions.getFortuneCookie2()

}