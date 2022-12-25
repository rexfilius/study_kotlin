package intro

import newLine

/**
 * 'Vararg' allow you to pass any number of arguments by separating them with commas
 */
fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}

/**
 * Thanks to named parameters, you can add another parameter of the same type after the
 * vararg. This wouldn't be allowed in Java because there's no way to pass a value
 */
fun printAllWithPrefix(vararg messages: String, prefix: String) {
    for (m in messages) println(prefix + m)
}

/**
 * At runtime, a vararg is just an array. To pass it along into a vararg parameter, use
 * the special spread operator '*' that lets you pass in *entries (a vararg of String)
 * instead of entries (an Array<String>)
 */
fun log(vararg entries: String) {
    printAll(*entries)
}

fun main() {

    printAll("Hello", "Hi", "Halo")
    "" newLine ""

    printAllWithPrefix("Hello", "Hi", "Halo", prefix = "Greeting")
    "" newLine ""
}