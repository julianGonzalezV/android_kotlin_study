package udacity.training.clase4_object_oriented.aquarium

/**
 * Note que así evita mas escritura de codigo
 * (constructor con parámetros, getters , setters etc)
 * Además desde el main exige que se especifique val o var no hay un por
 * defecto como creo que sucede en scala
 * COmparela con las versiones anteriores de Aquarium y
 * verá que es less boilerplate
 *
 * el open es para poder implementar la heerencia
 */
open class AquariumBase(var width:Int = 100, var height:Int = 20, var length:Int = 40){

    var volume:Int
        get() {return width * height * length / 1000}
        set(value) {height =  (value * 1000) / (width * height )} //el ser es permitodo solo para vars

    var water = volume * 0.9

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

class TowerTank: AquariumBase() {
    override var water = volume * 0.8
    override  var volume: Int
    get() = (width * height * length / 1000 * Math.PI).toInt()
    set(value) {
        height = (value * 1000)/(width * length)
    }
}