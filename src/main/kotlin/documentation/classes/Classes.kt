package documentation.classes

/**
 * The class declaration consists of the class name,
 * the class header (specifying its type parameters, the primary constructor etc.)
 * and the class body, surrounded by curly braces. Both the header and the body are
 * optional; if the class has no body, curly braces can be omitted.
 */
class Invoice { /*...*/ }

class Empty

/**
 * A class in Kotlin can have a primary constructor and one or more secondary
 * constructors. The primary constructor is part of the class header - it goes after the
 * class name (and optional type parameters). If the primary constructor doesn't have
 * any annotations or visibility modifiers, 'constructor' keyword can be omitted.
 */
class Person constructor(firstName: String) {/*...*/ }

class Person2(firstName: String)

/**
 * The primary constructor cannot contain any code. Initialization code can be placed in
 * initializer blocks - prefixed with the 'init' keyword
 * init blocks are executed in the same order as they appear in the class body
 */
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

/**
 * Parameters of the primary constructor can be used in the initializer blocks.
 * They can also be used in property initializers declared in the class body
 */
class Customer(name: String) {
    val customerKey = name.uppercase()
}

// If the constructor has annotations or visibility modifiers, the constructor keyword
// is required and the modifiers go before it
class Customer2 @SinceKotlin("1.3") private constructor(name: String) { /*...*/ }

fun main() {
    val initOrderDemo = InitOrderDemo("Hello")
    println(initOrderDemo)
}