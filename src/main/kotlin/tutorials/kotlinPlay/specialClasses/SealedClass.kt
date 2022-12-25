package specialClasses

/**
 * Sealed classes let you restrict the use of inheritance. Once you declare a class sealed,
 * it can only be subclassed from inside the same file where the sealed class is declared.
 * It cannot be subclassed outside of the file where the sealed class is declared.
 */
sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

/**
 * The else-case is not necessary here since all possible subclasses of the sealed class
 * are covered. With a non-sealed superclass else would be required.
 */
fun greetMammal(mammal: Mammal): String {
    return when (mammal) {
        is Human -> "Hello ${mammal.name}; You're working as a ${mammal.job}"
        is Cat -> "Hello ${mammal.catName}"
    }
}

fun main() {
    println(greetMammal(Cat("Snowy")))
}