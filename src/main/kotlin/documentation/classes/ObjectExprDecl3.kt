package classes

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

/**
 * SINGLETONS
 * The code below is an object declaration, and it always has a name following the 'object'
 * keyword. Just like a variable declaration, an object declaration is not an expression,
 * and cannot be used on the right hand side of an assignment statement. Object
 * declaration's initialization is thread-safe and done at first access.
 * To refer to the object, use its name directly
 */
object PrintName {
    fun printAName(firstName: String) {
        println("Hello $firstName")
    }
}

fun main() {
    PrintName.printAName("Jake")
}

// Objects can have supertypes
object DefaultListener : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) {/**/
    }

    override fun mouseEntered(e: MouseEvent) {/**/
    }
}

/**
 * Object declarations can't be local (i.e. be nested directly inside a function), but
 * they can be nested into other object declarations or non-inner classes
 */
