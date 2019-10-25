package udacity.training.clase3_functions

object Lambas {

    //#####18 Kotlin lambdas: Expresion para hacer funciones#####################################################
    fun swim(){
        println("Swim function")
    }

    val lambda1 = { println("Swim lambda") }()
    val lambda2 = { println("Swim lambda 2") }
    val suma = {x:Int,y:Int -> x+y}
    /**
     * Note como al decir el tipo de la funcion, entonces
     * no es necesario decirle el tipo en las variables dentro de {}
     * a esto se le conoce como type inference
     */
    val resta: (Int,Int) -> Int = { x,y -> x-y }

    // ACUARIO DIRTY PROCESSOR
    var dirty = 20
    val waterFilter:(Int) -> Int = {dirt -> dirt / 2}
    fun feedFish(dirty: Int) = dirty + 10


    /**
     * Ojo el dirty no es el de afuera en la linea 21
     */
    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }


    /**
     * Aca el dirty SI ES EL DE AFUERA
     */
    fun dirtyProccessor():Int{
        dirty = updateDirty(dirty, waterFilter)
        dirty = updateDirty(dirty, Lambas::feedFish)
        dirty = updateDirty(dirty, {it +50})
        return dirty
    }

}
fun main(args: Array<String>){
    Lambas.swim()
    Lambas.lambda1
    /**
     * Note acá como uso la clase invoke, de lo contratio nunca haría algo
     */
    Lambas.lambda2.invoke()
    val result = Lambas.suma(7,8)
    println("suma $result")
    println("resta ${Lambas.resta(9,4)}")
    println(Lambas.dirtyProccessor())
}