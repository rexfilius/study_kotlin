package documentation.typeSystem

import java.io.File

fun main() {

    // Unsafe cast
    /*val y: Any = getAnObject()
    val typeSystem.getX: String = y as String

    val p = getAnObject()
    val q: String = p as String

    // To avoid exceptions, use the safe cast operator 'as?'
    // that returns 'null' on failure
    val yy: Any = getAnObject()
    val xx: String? = yy as? String

    // Type erasure and generic type checks
    val something: Any = getAnObject()
    if (something is List<*>) {
        something.forEach { println(it) } // the items are typed as 'Any?'
    }*/

    // Type erasure and generic type checks
    val somePair: Pair<Any?, Any?> = "items" to listOf(1, 2, 3)
    val stringToSomething = somePair.asPairOf<String, Any>()
    val stringToInt = somePair.asPairOf<String, Int>()
    val stringToList = somePair.asPairOf<String, List<*>>()
    val stringToStringList = somePair.asPairOf<String, List<String>>()

    println("somePair: $somePair")
    println("stringToSomething: $stringToSomething")
    println("stringToInt: $stringToInt")
    println("stringToList: $stringToList")
    println("stringToStringList: $stringToStringList")

    // ... Unchecked casts ...
    // We saved a map with `Int`s into that file
    val intsFile = File("ints.dictionary")
    // Warning: Unchecked cast: `Map<String, *>` to `Map<String, Int>`
    val intsDictionary: Map<String, Int> = readDictionary(intsFile) as Map<String, Int>

}

// Type erasure and generic type checks
fun handleStrings(list: List<String>) {
    if (list is ArrayList) {
        list.trimToSize() // smart-cast to to 'ArrayList<String>
    }
    // safe casting
    val s = list as? ArrayList
}

// Type erasure and generic type checks
inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
    if (first !is A || second !is B) return null
    return first as A to second as B
}

fun readDictionary(file: File): Map<String, *> = file.inputStream().use {
    TODO("Read a mapping of strings to arbitrary elements")
}