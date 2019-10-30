package udacity.training.clase4_object_oriented.aquarium

/**
 *
 */
class AquariumMutable {

    var width: Int = 20
    var height: Int = 40
    var length: Int = 100
    /**
     * Para funciones one line es mejor usarlo como propiedad y re-escribir el
     * metodo get
     */
    val volume:Int
        get() {return width * height * length / 1000}

    //fun volume() =  width * height * length / 1000

}