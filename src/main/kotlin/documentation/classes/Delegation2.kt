package classes

import kotlin.properties.Delegates

/**
 * Kotlin standard library provides factory methods for several useful kinds of delegates.
 * ...
 * Lazy properties: lazy() is a function that takes a lambda and returns an instance of
 * Lazy<T> which can serve as a delegate for implementing a lazy property: the first call
 * to get() executes the lambda passed to lazy() and remembers the result,
 * subsequent calls to get() simply return the remembered result
 */
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

/**
 * Delegates.observable() takes two arguments: the initial value and a handler for
 * modifications. The handler is called every time you assign to the property
 * (after the assignment has been performed). It has three parameters:
 * a property being assigned to, the old value and the new one
 */
class User2 {
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("$old -> $new")
    }
}

fun main() {
    println(lazyValue)
    println(lazyValue)
    println()

    val user = User2()
    user.name = "first"
    user.name = "second"
}