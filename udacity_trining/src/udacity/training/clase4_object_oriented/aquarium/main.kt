package udacity.training.clase4_object_oriented.aquarium

fun main(args: Array<String>){
    buildAquarium()
}

/**
 * private indica que solo será visible en este archivo
 * por defecto todos son public y no default COMO  en java
 *
 * Internal: Le da el nivel de visibilidad a nivel de mopdulo, un modulo es un
 * conjunto de archivos que se compilan juntos, en este caso el proyecto completo
 * podrá visualizarlo pero no otro proyecto, es decir que si se compila y se
 * expone entonces las funciones internal no se podrán visualizar
 *
 * Private: Visibilidad dentro de la clase pero no en subclases
 * Protected: Visibilidad dentro de la clase Y en subclases
 */
private fun buildAquarium(){
    /**
     * Note que no pide la palabra new para crear la nueva instancia
     * Note com usa el constructor sin parámetros
     */
    val aquarium = Aquarium()
    //No es permitodo aquarium.height = 80
    println("length ${aquarium.length} - width ${aquarium.width} -height ${aquarium.height}")

    val mutableAquarium = AquariumMutable()
    mutableAquarium.height = 80
    println("Volume ${mutableAquarium.volume}")
}

/**
 * Note como se puede tener mas de un main pero al darle RUN, nos pedirá que
 * se seleccione el main a ejecutar
 */
fun main2(args: Array<String>){
    println("HLE")
}