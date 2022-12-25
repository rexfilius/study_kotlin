package classes

/**
 * Sometimes you need to create an object of a slight modification of some class, without
 * explicitly declaring a new subclass for it. Kotlin handles this case with
 * object expressions and object declarations
 */

// To create an object of an anonymous class that inherits from some type(s).
/**
 * window.addMouseListener(object : MouseAdapter() {
 *     override fun mouseClicked(e: MouseEvent) { /*...*/ }
 *     override fun mouseEntered(e: MouseEvent) { /*...*/ }
 * })
 */

// If a supertype has a constructor, appropriate constructor parameters must be passed
// to it. Many supertypes can be specified as a comma-delimited list after the colon.
open class A2(x: Int) {
    open val y: Int = x
}

interface B2 {/**/ }

val ab: A2 = object: A2(1), B2 {
    override val y: Int = 15
}

// when you need just an object, with no nontrivial supertypes
fun printHelloWorld() {
    val p = object  {
        val hello = "Hello"
        val world = "World"
    }
    println(p.hello + p.world)
}

fun main() {
    printHelloWorld()
}