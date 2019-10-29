package udacity.training.clase3_functions;

import java.util.*

object C19Quiz {
    val rollDice = { sides:Int  -> if (sides == 0) 0 else Random().nextInt(12)+1 }

    /**
     * Function type notation
     */
    val rollDice2:(Int) -> Int = { sides:Int ->
        if (sides == 0)
            0
        else
            Random().nextInt(12)+1
    }

    fun gamePlay(function:(Int) -> Int){
        println("function result -> ${function.invoke(1)}")
    }


}

fun main(args: Array<String>) {
    /**
     * Note que se debe usar invoke
     */
    println(C19Quiz.rollDice.invoke(1))
    println(C19Quiz.rollDice2(1))
    C19Quiz.gamePlay(C19Quiz.rollDice2)
    C19Quiz.gamePlay(C19Quiz.rollDice)
}
