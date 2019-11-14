package udacity.training.clase4_object_oriented.aquarium

/**
 * Si define constructor como en esta caso entonces este seria el constructor primario
 * osea el this
 *
 * Buenas prácticas en kotlin
 * > no mas de un constructor y en su lugar use bloques init
 * y helper functions como makeDefaultFish por si necesita más flexibilidad
 */
class Fish(val friendly:Boolean, volumeNeeded:Int) {
    val size: Int

    init {
        print("First init block");
    }

    constructor():this(true,9){
        print("Secondary constructor")

    }

    init {
        if (friendly) size = volumeNeeded
        else size = volumeNeeded * 2
    }

    init {
        print("third init block");
    }

    /**
     * Si requiere un segundo constructor como lo puede hacer en java
     * mejor considere una funcion helper como esta
     */
    fun makeDefaultFish() = Fish(true,50)

    fun fishEg1() = {
        val fish1 = Fish(true, 20)
        /**
         * La siguiente línea da error porque volumeNeeded no es una propiedad
         * ya que no es ni "val" ni "var"
         */
        //print("Friendly => ${friendly} and volumeNeeded => ${volumeNeeded} ")

        /**
         * Pero note que size está definido en terminos de volumeNeeded
         * por ende cuando necesite algo así entonces lo correcto sería:
         */
        print("Friendly => ${fish1.friendly} and volumeNeeded => ${fish1.size} ")


    }

}