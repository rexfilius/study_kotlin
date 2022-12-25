package intro

/**
 * An infix extension function on Int
 */
infix fun Int.time(str: String) = str.repeat(this)

/**
 * An implementation of 'to' infix function from the Pair class
 */
infix fun String.onto(other: String) = Pair(this, other)

/**
 * Member functions and extensions with a single parameter can be turned into infix functions
 */
fun main() {

    println(2 time "Bye")

    /**
     * Creates a Pair calling the infix function 'to' from the standard library
     */
    val pair = "Ferrari" to "Katrina"
    println("pair: $pair")

    val myPair = "McLaren" onto "Lucas"
    println("myPair: $myPair")

    /**
     * Infix notation also works on members functions
     */
    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
}

class Person(val name: String) {
    private val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) = likedPeople.add(other)
}