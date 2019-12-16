package book._1_basic

/**
 * Esto es mas expressive
 * además al escribir data class ..
 * incluye de manera implcita funcionalidades
 * gets y sets(aunque no es exlusivo de data class)
 * equals() / hashCode()
 * funciones llamadas componentX(): para destructurting ejemplo:
    val person = Person("x", "y", "z")
    val (n, s, i) = person
 Lo anterior permite entonces aplicar decomposición:
    val map = mapOf(1 to "a", 2 to "b")

    for ((key, value) in map) {
    toast("key: $key, value: $value")
    }

 * Un método copy(), útil en el uso de objetos inmutables, EJEMPLO:
    val person = Person("John", "Smith", "123abc")
    val person2 = person.copy(surname="Rogers")
 */
data class Artist(
        var id: Long,
        var name: String,
        var url: String,
        var mbid: String) {
    fun func1() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun main(args: Array<String>){
    // This does not compile. Artist cannot be null
    // ya que se le está especidficando el tipo "Artist"
    //var notNullArtist: Artist = null

     // Artist can be null
    var artist: Artist? = null

     // Will not compile, artist could be null and we need to deal with that
    //artist.func1()

    // Will execute func1  only if artist != null
    artist?.func1()

    // por lo anterior l45 se evitará lo siguiente
    if (artist != null) {
        artist.func1()
        }

    // Only use it when we are sure it is not null. It throws an exception otherwise.
    artist!!.func1()

    // Use Elvis operator to give an alternative in case the object is null.
    val name = artist?.name ?: "empty"
}