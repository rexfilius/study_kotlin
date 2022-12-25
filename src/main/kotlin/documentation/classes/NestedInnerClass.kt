package classes

// Classes can be nested in other classes
class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = println("function in Nested class")
    }
}

/**
 * You can also use interfaces with nesting. All combinations of classes and interfaces
 * are possible: You can nest interfaces in classes, classes in interfaces,
 * and interfaces in interfaces
 */
interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OuterClass {
    class InnerClass
    interface InnerInterface
}

/**
 * A nested class marked as 'inner' can access the members of its outer class.
 * Inner classes carry a reference to an object of an outer class
 */
class OuterString {
    private val printString: String = "property in Outer class"

    inner class InnerString {
        fun foo() = println("accessing object in outer class: $printString")
    }
}

/**
 * Anonymous inner class instances are created using an object expression:
 * ...
 * window.addMouseListener(object : MouseAdapter() {
 *     override fun mouseClicked(e: MouseEvent) { ... }
 *     override fun mouseEntered(e: MouseEvent) { ... }
 * })
 * ...
 * On the JVM, if the object is an instance of a functional Java interface
 * (that means a Java interface with a single abstract method),
 * you can create it using a lambda expression prefixed with the type of the interface.
 * ...
 * val listener = ActionListener { println("clicked") }
 */

fun main() {

    val demo = Outer.Nested().foo()

    val demoString = OuterString().InnerString().foo()
}