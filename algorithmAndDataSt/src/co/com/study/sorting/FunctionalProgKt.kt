package co.com.study.sorting

class FunctionalProgKt<T> {
    fun imprimeLista(lista:List<T>) {
        if(!lista.isEmpty()){
            println(lista.get(0))
            imprimeLista(lista.filter { x-> x!= lista.get(0) })
        }
    }


}
fun main(args: Array<String>){
    println("imprime lista")
    val imprimeInts = FunctionalProgKt<Int>()
    val imprimeStr = FunctionalProgKt<String>()
    imprimeInts.imprimeLista(listOf(3, 4, 5, 6))
    imprimeStr.imprimeLista(listOf("ju","li"))
}