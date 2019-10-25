package udacity.training.clase2_basics

class StringExamples{

    fun concatExample(){
        println("::::..concatExample:::::::")
        val str1 = "I am"
        val str2 = " a software engineer"
        println("Suma => "+str1+str2)

        /**
         * Tambien se puede concatenar con numeros
         */
        val n1 = 5
        val n2 = 12
        val str3 = "I have $n1 uncles and $n2 cousins"
        println(str3)
        println("str3 => "+str3)
        /**
         * O tambien
         */
        val str4 = "I have ${n1+n2} uncles and cousins"
        println("str4 => "+str4)

    }

    fun whenStatement(){
        val fishName = "Juliancho carrancho"

        when(fishName.length){
            0 -> println("Error")
            in 3..12 -> println("Good fish name")
            else -> println("OK fish name")

        }

    }


}

fun main(args: Array<String>) {
    StringExamples().concatExample()
    StringExamples().whenStatement()
}
