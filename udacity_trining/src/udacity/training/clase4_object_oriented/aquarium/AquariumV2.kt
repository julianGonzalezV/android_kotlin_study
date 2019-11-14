package udacity.training.clase4_object_oriented.aquarium

/**
 * Note que así evita mas escritura de codigo
 * (constructor con parámetros, getters , setters etc)
 * Además desde el main exige que se especifique val o var no hay un por
 * defecto como creo que sucede en scala
 * COmparela con las versiones anteriores de Aquarium y
 * verá que es less boilerplate
 */
class AquariumV2(val width:Int = 100,var height:Int = 20, val length:Int = 40){

    val volume:Int
        get() {return width * height * length / 1000}
        //set(value) {return width * height * length / 1000} permitodo solo para vars

    val water = volume * 0.9

    /**
     * OJO: si se quitan los valores por defecto del constructor de la clase con
     * parámetros entonces no funcionará el this() porque pedirá inicializar dichos
     * valores(explore :) )...en este caso this se refiere al constructor con
     * parámetros de arriba
     */
    constructor(numberOfFish:Int) : this(){
        val water = numberOfFish * 2000 //cm3
        val tank = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }

    /**
     * Constructor de más parámetros
     */
    constructor(numberOfFish:Int, oth:Int) : this()

    override fun toString(): String {
        return "AquariumV2(width=$width, height=$height, length=$length, water=$water)"
    }


}