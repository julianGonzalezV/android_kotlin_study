package udacity.training.clase3_functions

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
        /*
        When sin parámetros actua como una secuencia de if -else y se puede
        entonces coparar por varios parámetros combinados o por separado,
        e este caso por separado
         */
        return when{
            temperature > 30 -> true
            dirty > 30 -> true
            day == "Sunday" -> true
            else -> false
        }
    }

    fun canAddFish(tankSize:Double, currentFish:List<Int>, fishSize:Int = 2, hasDecorations:Boolean = true):Boolean{
        val result = (currentFish.sum()+fishSize)/tankSize <= if(hasDecorations) 0.8 else 1.0
        println(result)
        return result
    }


    //############################################
    // Practice Time
    // Create a program that suggests an activity based on various parameters.

    fun whatShouldIDoToday(mood: String, weather:String = "sunny", temperature: Int = 24){

        val result = when{
            mood == "happy" && weather == "Sunny" -> "go for a walk"
            else -> "Stay home and read."
        }

        println(result);
    }

    //Practice Time: Improve your whatShouldIDoToday() program with the new
    //knowledge from this segment.

    fun whatShouldIDoToday2(weather:String = "sunny", temperature: Int = 24):String{
        print("Enter mood text: ")
        //val mood = readLine()!!
        val mood = "sad"
        println("You entered: $mood")

        return when {
            //validate1(mood,weather,temperature)-> "stay in bed"
            validate2(temperature) -> "go swimming"

            else -> "Stay home and read."

        }

    }

    fun validate1(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0

    fun validate2(temperature: Int) = temperature == 0 || temperature > 35



    //############################################





    //kotlin filters############################################
    fun filterEx(){
        println("filterEx")
        val decorations = listOf("roc","pagoda","plastic plant","alligator","flowerpot")
        // Imprime todo
        println(decorations.filter { true })

        println(decorations.filter { it[0] == 'p' })

        // La siguiente linea no funciona como quizás si suceda en otros lenguajes
        // porque no permite usar strings donde char debe ser usado
        //println(decorations.filter { it[0] == "p" })

        // IMPORTANTE, PODEMOS USAR FILTER DE FORMA LAZY O EAGER
        //EAGER:
        val eager = decorations.filter { it[0] == 'p' }
        println("eager example -> ${eager}")


        //LAZY: De la forma laizy pide que sea sequence, para no usar it si no entiende
        // entonces aplique el filter
        val lazy =decorations.asSequence().filter { x ->
            // note que las imprime todas porque lo que hace es recorrer todo el arreglo y le aplica el filter
            // volviendo cada registro el true o false (si cumple o no el filter)
            println("lazy Imprimiento ${x}")
            x[0]=='p'
        }
        println("lazy filter note que se imprime la especiicacion ->${lazy}")
        println("lazy execution ->${lazy.toList()}")

        // sequence apalanca LAZY MAP
        val lazyMap = decorations.asSequence().map { x ->
            println("Imprimiento ${x}")
            x
         }
        println("lazy Map->${lazyMap}")
        println("lazy map execution ->${lazyMap.first()}")


    }


    //#####FILTERS#####################################################
    fun filter(){
        println("17.Quiz: Practice Timefilter")
        val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
        val curries = spices.filter { it.contains("curry") }.sortedBy { it.length }
        println("currries ${curries}")

        val ce1 = spices.filter { it.startsWith("c") && it.endsWith("e")}
        val ce2 = spices.filter { x -> x.startsWith("c")  && x.endsWith("e")}
        println("ce1 ${ce1}")
        println("ce2 ${ce2}")

        val threeAndStartWithC = spices.take(3).filter { it.startsWith("c") }
        println("threeAndStartWithC ${threeAndStartWithC}")
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
    Functions.swim(5, "leento")

   // Functions.getFortuneCookie2()

    println("===========canAddFish=================")
    Functions.canAddFish(10.0, listOf(3, 3, 3))//debe resolver a false
    Functions.canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false)//debe resolver a true
    Functions.canAddFish(9.0, listOf(1, 1, 3), 3)//debe resolver a false
    Functions.canAddFish(10.0, listOf(), 7, true)//debe resolver a true
    Functions.whatShouldIDoToday("sad")
    val wsid = Functions.whatShouldIDoToday2(temperature = 36)
    println("whatShouldIDoToday2 -> ${wsid}")

    Functions.filterEx()

    Functions.filter()
}