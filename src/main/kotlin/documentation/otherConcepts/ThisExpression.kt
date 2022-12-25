package otherConcepts

/**
 * To denote the current receiver, you use "this" expressions:
 * 1. In a member of a class, this refers to the current object of that class.
 * 2. In an extension function or a function literal with receiver this denotes
 *    the receiver parameter that is passed on the left-hand side of a dot.
 * If 'this' has no qualifiers, it refers to the innermost enclosing scope.
 * To refer to 'this' in other scopes, label qualifiers are used
 */
class X { // implicit label @X
    inner class Y { // implicit label @Y
        fun Int.foo() { // implicit label @foo
            val a = this@X // A's this
            val b = this@Y // B's this

            val c = this // foo()'s receiver, an Int
            val c1 = this@foo // foo()'s receiver, an Int

            val funLit = lambda@ fun String.() {
                val d = this // funLit's receiver
            }

            val funLit2 = { s: String ->
                // foo()'s receiver, since enclosing lambda expression
                // doesn't have any receiver
                val d1 = this
            }
        }
    }
}

/**
 * When you call a member function on this, you can skip the 'this.' part.
 * If you have a non-member function with the same name, use this with caution
 * because in some cases it can be called instead
 */
fun printLine() {
    println("Top-level function")
}

class G {
    private fun printLine() {
        println("Member function")
    }

    fun invokePrintLine(omitThis: Boolean = false) {
        if (omitThis)
            printLine()
        else
            this.printLine()
    }
}

fun main() {

    // error - not giving the expected output
    G().invokePrintLine() // Member function
    G().invokePrintLine(omitThis = true) // Top-level function
}