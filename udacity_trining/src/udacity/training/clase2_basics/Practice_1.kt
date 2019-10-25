package udacity.training.clase2_basics

class OperatorsExample {
    fun printHello () {
        println ("Hello desde Kotlin")
    }

    /**
     * Note como los primitivos tienen métodos y son tratados como instancia
     */
    fun primitveAsObjects(){
        val fish = 20
        println("Times => "+fish.times(6))
        println("Div => "+ fish.div(10))
        println("Plus => "+fish.plus(3))
        println("Minus => "+fish.minus(3))
        // Note la inmutabilidad de los vals
        // fish = 21, no se puede reasignar
        println("Vals son inmutables => "+fish)
        println("llamado del metodo tostr => "+fish.toString())

    }

    fun boxing(){
        val boxed:Number = 1
        println("boxed => "+boxed)
        boxed.toLong()
    }

    fun boxing2(){
        val b:Byte = 1
        val boxed:Number = b // todos los números proviene de Number
        // val ln:BigInteger = // b no hay boxing
        // se evita implicit numerical conversion por todos los errores que esto ha causado en la historia del java por ejemplo
        // val i:Int = b //no hay boxing
        //println("boxed => "+boxed)
        println("toInt => "+b.toInt()) //mejor usar el casting asi

    }

    fun nullability(){
        // val rock:Int = null , cuando se le dice el tipo de dato, en este caso Int no permite nulos, en su lugar ?
        val rock:Int? = null
        println("rock is  => "+rock)

        /**
         *OJO: importante notar que lotsOfFish NO es null, son sus elementos, por eso el signo ? dentro del diamond
         * por eso sentencia como esta var lotsOfFish: List<String?> = null no va a funcionar , pues se le dijo
         * que puede ser null en sus elementos
         */
        val lotsOfFish: List<String?> = listOf(null,null)
        println("lotsOfFish is  => "+lotsOfFish)


        val lotsOfFish2: List<String>? = null
        println("lotsOfFish2 is  => "+lotsOfFish2) //  La lista pueder ser null
        val lotsOfFish3: List<String?>? = null
        println("lotsOfFish3 is  => "+lotsOfFish3) // ammos, la lista y sus elementos, pueden ser null

    }

    fun bangOperator(){
        var v1:Int? = 2
        /**
         * Con !! (bang operator), validamos la posible nulidad de la variable
         * lo que hace es generar un KotlinNullPointerException, note más abajo
         */
        println("bang v1 is  => "+v1!!.plus(2))

        v1 = null
        /**
         * Note el KotlinNullPointerException
         * LO QUE PARA EL DESARROLLADOR RESULTA MOLESTO, vaya a la siguiente funcion para que vea como se resuelve
         */
       // println("bang v1 is  => "+v1!!.plus(3))

    }

    fun easyNullValidation(){
        var v1: Int? = 5
        println("v1?.dec() #1 is  => "+v1?.dec()) // dec es la funcion para decrementar
        v1 = null
        println("v1?.dec() #2 is  => "+v1?.dec()) // dec es la funcion para decrementar
    }

    /**
     * A partir de acá es realmente la practica 1 lo anterior son bases para poderla realizar
     *
     * 1)
     * If you start with 2 fish, and they breed twice, producing 71 offspring the first time,
     * and 233 offspring the second time, and then 13 fish are swallowed by a hungry moray eel,
     * how many fish do you have left? How many aquariums do you need if you can put 30 fish per aquarium?
     */
    fun basicOperators(){
        println(":::::::::::basicOperators:::::::::::::")
        val fish = 2
        val leftFishes = fish.plus(71).plus(233).minus(13)
        println("leftFishes  => "+leftFishes)
        println("aquariums  => "+ Math.ceil(leftFishes.toDouble().div(30)))
    }

    /**
     * 1) Create a String variable rainbowColor, set its color value, then change it.
     * 2) Create a variable blackColor whose value cannot be changed once assigned. Try changing it anyway.
     */
    fun variables(){
        var rainbowColor = "yellow"
        rainbowColor = "Blue"
        val blackColor = "Black"
        //blackColor = "b"//errror
        // puedo crear otro val a partir de un val anterior, es decir que a pesar de ser uinmutable se puede
        // enviar a otro computo
        val blackAndWhite = blackColor.map{ x -> x+"1" }
        println(" Note el map :) blackAndWhite => "+blackAndWhite)
    }

    /**
     *Try to set rainbowColor to null. Declare two variables, greenColor and blueColor.
     * Use two different ways of setting them to null.
     */
    fun nullabilityExample(){
        var rainbowColor:String? = "yellow"
        rainbowColor = null
        var greenColor:String? = "Green"
        var blueColor = null
        greenColor = null;

        //blackColor = "b"//errror
        // puedo crear otro val a partir de un val anterior, es decir que a pesar de ser uinmutable se puede
        // enviar a otro computo
        println(" Note el map :) blackAndWhite => "+greenColor+blueColor)
    }

    /**
     * 1) Create a list with two elements that are null; do it in two different ways.
     * 2) Next, create a list where the list is null.
     */
    fun nullList(){
        var list1: List<String?> = listOf(null, null)
        val list1_1: List<String?>? = listOf(null, null)
        var list1_2 = listOf(null, null)
        val list2: List<String>? = null
        val list2_2 = null
        println("list1=> "+list1+"list1_1=> "+list1_1+"list2=> "+list2)
    }

    /**
     * > Create a nullable integer variable called nullTest, and set it to null. Use a null-check that increases the value by one if it's not null, otherwise returns 0, and prints the result.
     *       Hint: Use the Elvis operator.
     */
    fun nullChecks(){
        var nullTest:Int? = null
        val result = nullTest?.inc()?:0
        println("nullChecks => "+result)
    }


}

fun main(args: Array<String>) {
    val opVal: OperatorsExample = OperatorsExample()
    opVal.printHello()
    opVal.primitveAsObjects()
    opVal.boxing()
    opVal.boxing2()
    opVal.nullability()
    opVal.bangOperator()
    opVal.easyNullValidation()
    opVal.basicOperators()
    opVal.variables()
    opVal.nullList()
    opVal.nullChecks()
}

