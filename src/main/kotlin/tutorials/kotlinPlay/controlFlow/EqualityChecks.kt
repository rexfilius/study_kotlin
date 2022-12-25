package controlFlow

import newLine

/**
 * Kotlin uses == for structural comparison and === for referential comparison.
 * More precisely, a == b compiles down to if (a == null) b == null else a.equals(b).
 */
fun main() {

    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    // TRUE because it calls authors.equals(writers) and sets ignore element order
    println(authors == writers)

    // FALSE because authors and writers are distinct references
    println(authors === writers)

    "" newLine ""
}