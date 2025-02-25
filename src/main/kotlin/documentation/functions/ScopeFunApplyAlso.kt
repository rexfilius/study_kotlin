package documentation.functions

import newLine

fun main() {

    /**
     * APPLY
     * The context object is available as a receiver (this ).
     * The return value is the object itself.
     * Use apply for code blocks that don't return a value and mainly operate on the
     * members of the receiver object. The common case for apply is the object
     * configuration. Such calls can be read as:
     * "apply the following assignments to the object"
     * Having the receiver as the return value, you can easily include apply into call
     * chains for more complex processing.
     */
    val adam = Human("Adam").apply {
        age = 32
        city = "London"
    }
    println(adam)
    "" newLine ""

    /**
     * ALSO
     * The context object is available as an argument (it).
     * The return value is the object itself.
     * also is good for performing some actions that take the context object as an
     * argument. Use also for actions that need a reference rather to the object than to
     * its properties and functions, or when you don't want to shadow this reference from
     * an outer scope.
     * When you see also in the code, you can read it as
     * "and also do the following with the object."
     */
    val numbers = mutableListOf("one", "two", "three")
    numbers.also { println("The list elements before adding new one: $it") }
            .add("four")
    println(numbers)


}