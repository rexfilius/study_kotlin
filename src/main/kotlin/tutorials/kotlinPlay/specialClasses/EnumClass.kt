package specialClasses

import newLine

/**
 * Enum classes are used to model types that represent a finite set of distinct values,
 * such as directions, states, modes, and so forth. The number of instances of an enum
 * class is always finite and they are all distinct
 */
enum class State {
    IDLE, RUNNING, FINISHED
}

/**
 * Enums may contain properties and methods like other classes, separated from the list of
 * instances by a semicolon.
 */
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)
}

fun main() {

    // access an enum instance via the class name
    val state = State.RUNNING

    /**
     * With enums, the compiler can infer if a when-expression is exhaustive so that
     * you don't need the else-case.
     */
    val message = when (state) {
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)
    "" newLine ""

    val red = Color.RED
    println(red)    // toString returns the name of the instance 'RED'
    println(red.containsRed())    // calls a method on an enum instance
    println(Color.BLUE.containsRed())  // calls a method via enum class name
}