package controlFlow

import newLine

/**
 * Kotlin supports all the commonly used loops: 'for' 'while' 'do-while'
 */
fun main() {

    val cakes = listOf("carrot", "cheese", "chocolate")
    for (cake in cakes) {
        println("Yummy, it's a $cake cake")
    }
    "" newLine ""

    var cakesEaten = 0
    var cakesBaked = 0

    /**
     * Executes the block while the condition is true
     */
    while (cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }
    "" newLine ""

    /**
     * Executes the block first and then checking the condition.
     */
    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)

}

fun eatACake() = println("Eat a cake")
fun bakeACake() = println("Bake a cake")