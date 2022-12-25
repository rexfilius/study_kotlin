package collections

import newLine
import specialClasses.Human

fun main() {

    /**
     * first, last::
     * These functions return the first and the last element of the collection
     * correspondingly. You can also use them with a predicate; in this case, they return
     * the first or the last element that matches the given predicate. If a collection is
     * empty or doesn't contain elements matching the predicate,
     * the functions throw NoSuchElementException.
     */
    val aNumbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers: $aNumbers")

    println("first: ${aNumbers.first()}")
    println("last: ${aNumbers.last()}")
    println("firstEvenNumber: " + aNumbers.first { it % 2 == 0 })
    println("lastOddNumbers: " + aNumbers.last { it % 2 != 0 })
    "" newLine ""

    /**
     * firstOrNull, lastOrNull::
     * These functions work almost the same way with first() & last() except one
     * difference: they return null if there are no matching elements.
     */
    val words = listOf("foo", "bar", "baz", "faz")
    val empty = emptyList<String>()

    println(empty.firstOrNull())
    println(empty.lastOrNull())

    println(words.firstOrNull { it.startsWith('f') })
    println(words.firstOrNull { it.startsWith('z') })
    println(words.lastOrNull { it.endsWith('f') })
    println(words.lastOrNull { it.endsWith('z') })
    "" newLine ""

    /**
     * count::
     * returns either the total number of elements in a collection or the number of
     * elements matching the given predicate.
     */
    val bNumbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers: $bNumbers")
    println("totalCount: ${bNumbers.count()}")
    println("evenNumbersCount: ${bNumbers.count { it % 2 == 0 }}")
    "" newLine ""

    /**
     * associateBy, groupBy::
     * build maps from the elements of a collection indexed by the specified key. The key
     * is defined in the keySelector parameter. You can also specify an optional
     * valueSelector to define what will be stored in the value of the map element.
     * The difference between associateBy and groupBy is how they process objects with
     * the same key:
     * - associateBy uses the last suitable element as the value.
     * - groupBy builds a list of all suitable elements and puts it in the value.
     * - The returned map preserves the entry iteration order of the original collection.
     */
    val people = listOf(
        Humanoid("John", "Boston", "+1-888-123456"),
        Humanoid("Sarah", "Munich", "+49-777-789123"),
        Humanoid("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
        Humanoid("Vasilisa", "Saint-Petersburg", "+7-999-123456")
    )

    println("associateBy-phone: " + people.associateBy { it.phone })
    println("associateBy-phone-city: " + people.associateBy(Humanoid::phone, Humanoid::city))
    println("groupBy-city-name: " + people.groupBy(Humanoid::city, Humanoid::name))
    println("associateBy-city-name: " + people.associateBy(Humanoid::city, Humanoid::name))
    "" newLine ""

}

data class Humanoid(val name: String, val city: String, val phone: String)