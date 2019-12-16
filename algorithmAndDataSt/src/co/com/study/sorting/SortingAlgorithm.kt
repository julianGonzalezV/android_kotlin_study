package co.com.study.sorting

import kotlin.random.Random

/**
 * Theory:
 * https://brilliant.org/wiki/big-o-notation/
 * https://dev.to/b0nbon1/understanding-big-o-notation-with-javascript-25mc
 *Big O Notation:
 * Said that an algorithm has an specific running time as a function on its input size
 * Examples:
 * https://developerlife.com/2018/08/16/algorithms-in-kotlin-1/
 * https://medium.com/@sabbir044/algorithm-and-data-structures-in-kotlin-sorting-1-bubble-sort-b4f65b7a00ad
 *
 *
 * https://medium.com/karuna-sehgal/a-simplified-explanation-of-the-big-o-notation-82523585e835
 */
class SortingAlgorithm<T> {
    //O(1): Validar si una lista/archivo etc tiene algún registro en la primera posición

    // O(n): recorrer una colección u validar algo sobre cada elemento

    /**
     * Counting Sort
     * Ordenamiento basado en un key numérico positivo , es decir que se debe tener un key para cada
     * elemento de la colección, ejemplo si tienes un abecdario, que cada letra tengqa su Key antes de
     * iniciar con el ordenamiento
     *
     * Nota: Lo itenté cacoplar a cualquier tipo T pero recordar que solo
     * permite Ints
     *
     * Descripcion del algoritmo:
     *
     * //Obtengo el mayor, tambien lo pude haber inicializado en un valor muy grande
    // pero esto es mala practica porque voy a destinar memoria inncecesaria
    // esta operacion es O(n)
    val greatherVal = inputL.reduce { x,y -> if(x>y) x else y  }
    // sigue siendo O(n)
    val countArray = MutableList(greatherVal,{x -> 0})

     *
     *
     */
    fun countingSort(inputL: MutableList<Int>):MutableList<Int>{
        //val greatherVal = inputL.reduce { x,y -> if(x>y) x else y  } obtener el maximo usando reduce :)
        //val countArray = ifinputL.isNullOrEmpty() 0  MutableList(inputL?.max().plus(1)) { _ -> 0}
        val countArray = MutableList( if(inputL.isNullOrEmpty()) 0 else inputL.max()!!+1) { _ -> 0}

        inputL.forEach{indice ->  ++countArray[indice]} // puede ser un for
        countArray.forEachIndexed{idx,value ->
            if(idx > 0) countArray[idx] += countArray[idx-1]
        }

        val result = MutableList(inputL.size,{_->0})
        inputL.forEachIndexed { idx, value  ->
            result.set(countArray[value]-1,value)
            countArray[value] -= 1// si esta linea no se ejecuta entonces van a faltar
        }

        return result
    }

    /**
     * Example:
     * Given [5,1,4,2,8,9] then steps or swaps(exchanges) are:
     * [1,5,4,2,8,9]->[1,4,5,2,8,9]->[1,4,2,5,8,9]->[1,2,4,5,8,9]->FIN
     */
    fun bubbleSort(input: List<Int>):List<Int>{
        if(input.isEmpty()) return emptyList()
        fun bubbleSortIter(input: List<Int>, i:Int, j:Int, swaps:Int):List<Int>{
            //println("${input} i=${i} j=${j}  sw=${swaps} size ${input.size }")
            if(j>= input.size && swaps>0) return bubbleSortIter(input,0,1,0)
            else if(j>= input.size && swaps==0){
                return input
            }
            else if(input.get(i) > input.get(j)){
                return bubbleSortIter(swap(input,i,j),i+1,j+1,swaps+1)
            }else{
                return bubbleSortIter(input,i+1,j+1,swaps)
            }
        }
        return bubbleSortIter(input,0,1,0)
    }

    fun bubbleSort2(input: List<Int>):List<Int>{
        if(input.isEmpty()) return emptyList()
        fun bubbleSortIter(input: List<Int>, i:Int, j:Int):List<Int>{
            val size = input.size
            if(i == size-1) return input
            if(input.get(i) > input.get(j)){
                return bubbleSortIter(swap(input,i,j),i+1,j+1)
            }else if(j == size) return bubbleSortIter(input,i+1,i+1)
            else return bubbleSortIter(input,i,j+1)
        }
        return bubbleSortIter(input,0,1)
    }

    /**
     * Funcion util para el algoritmo bubbleSort
     */
    fun swap(input: List<Int>, pos1: Int, pos2:Int):List<Int>{
        //Clonando la lista para no modificar la real
        val listResult = input.toMutableList()
        listResult.set(pos1,input.get(pos2))
        listResult.set(pos2,input.get(pos1))
        return listResult;
    }


    fun sortCharList(input: MutableList<Char>):MutableList<Char>{
        val inputToInt = input.map { x -> x.toInt() }
        val inputToIntSorted = countingSort(inputToInt.toMutableList())
        val result = inputToIntSorted.map { x -> x.toChar() }
        return result as MutableList<Char>
    }

    fun sortFunction(inputL: List<Int>){
        val c = 'a'
        println(c.toInt())
        println("inputL $inputL")
        var r1 = inputL.sortedBy { it }
        println("SortedL ${r1}")
    }


    /**
     * O(n^2) quadratic complexity
     * ejemplo de esta complejidad es Bubble sort
     * 
     */

    fun bubble_sort(list: MutableList<String>):MutableList<String> {
        val size = list.size
        for (x in 0 until size) {
            for (y in x + 1 until size) {
                println("\tx=$x, y=$y")
                if (list[y] < list[x]) {
                    list.swap(y, x)
                }
            }
        }
        return  list
    }

    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val tmp = this[index1] // 'this' corresponds to the list
        this[index1] = this[index2]
        this[index2] = tmp
    }


    /**
     * O(2^n)When  growth doubles with each addition
     * Note lo interesante que es fibonacci , pues en cada iteración
     * siempre genera dos ramas (se duplica) el punto de fin es que quede cada rama con el
     * valor de 1 por esta condición  if(n <=1 ) return n y al final se suman toodos los
     * unos :)
     */

    fun fibo(n:Int):Int{
        if(n <=1 ) return n
        else return fibo(n-1) + fibo(n-2)
    }

    /**
     * Esta version es tail-recursive que se trata de evitar tanta propagación del arbol
     * y en su lugar se lleva siempre el valor actual, LA VERSION ANTERIOR DE fibo no es tailR
     * Note lo bacano de como entra menos veces, claro que requiere pensarle más
     * así la complejidad merma, diría que lo bajamos a O(n)
     */

    fun fiboTailR(n:Int):Int{
        fun fiboIter(n:Int, prev:Int, current:Int):Int{
            //println("prev ${prev} - current ${current}")
            if(n <=1 ) return current
            else return fiboIter(n-1, current, prev+current)
        }

        return fiboIter(n,0,1)
    }


    /**
     * O(log n): Logarithmic-time su tiempo de ejecución es proporcional al
     * logaritmo de la entrada ejemplo
     *Binary search:  Useful to search sorted data sets
     */

    fun binarySearch(target: Int, inputL:MutableList<Int>):Boolean{
        val splittedPosValue = inputL.get(inputL.size/2)
        println("target ${target} ; lista ${inputL} ; splittedValue ${splittedPosValue}")
        if(target == splittedPosValue) return true
        else if(inputL.size == 1 ) return false
        else if(target > splittedPosValue){
            return binarySearch(target, inputL.subList(inputL.size/2, inputL.size))
        }else{
            return binarySearch(target, inputL.subList(0, inputL.size/2))
        }
        return false
    }

    /**
     * O(n * log n) linearithmic-time : linearítmica
     * Ejemplos de algoritmos con complejidad lienaritmica:
     * 1) MergeSort
     * 2) QuickSort
     */
    /**
     * 1) Merge sort: Use the divide and conquer strategy, It splits the input list the the half of this in a recursively
     * way, until each resulted list has one (1) element
     * > Ordena cada sublist
     * > Hce merge de cada pedazo y va armando the full list
     * complejidad:
     * Dividir y volver a juntar es O(logn)
     * Por cada subset(que ya es O(lgn) se debe ordenar estos y en le mejor de los casos de ordenamiento es   O(n)
     * Resultado O(n log n)
     * UNA FORMA FÁCIL ES RECORRER LA LISTA DESORDENADA E IRLO METIENDO EN UN TREESET QUE NOS ASEGURA EL ORDENAMIENTO
     * AL INSERTAR
     */

    fun mergeSort(input: List<Int>):List<Int>{
        if(input.size == 1) return input
        else mergeSort()
    }

    fun merge(l1:List<Int>, l2:List<Int>):List<Int>{

    }


}


fun main(args: Array<String>){

    val sortingAlgorithm = SortingAlgorithm<Int>()
    println(sortingAlgorithm.countingSort(mutableListOf(1,7,5,4,1,8)))
    println(sortingAlgorithm.sortCharList(mutableListOf('b','c','a')))
    println(sortingAlgorithm.sortCharList(mutableListOf('i','a','e','o','u')))

    println("BubbleSort")
    println(sortingAlgorithm.bubbleSort2(listOf(6,5,4,3,2,1)))
    //println(sortingAlgorithm.bubbleSort(listOf(2,1)))

    //println(sortingAlgorithm.bubble_sort(mutableListOf("1","7","5","4","1","8")))
    println("Fibo")
    println(sortingAlgorithm.fiboTailR(7))

    println("Binary search: Nota, el arreglo debe estar ordenado")
    println(sortingAlgorithm.binarySearch(5,mutableListOf(1,4,5,7,8,9)))
}