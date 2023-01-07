package documentation.classes

// A class can also declare secondary constructors
class Person3(val name: String) {
    var children: MutableList<Person3> = mutableListOf()

    constructor(parent: Person3) : this(name = "") {
        parent.children.add(this)
    }
}

/**
 * If the class has a primary constructor, each secondary constructor needs to delegate
 * to the primary constructor, either directly or indirectly through another secondary
 * constructor(s). Delegation to another constructor of the same class
 * is done using the 'this' keyword
 */
class Person4(val name: String) {
    var children: MutableList<Person4> = mutableListOf()

    constructor(name: String, parent: Person4) : this(name) {
        parent.children.add(this)
    }
}

/**
 * Code in initializer blocks effectively becomes part of the primary constructor.
 * Delegation to the primary constructor happens as the first statement of
 * a secondary constructor, so the code in all initializer blocks
 * and property initializers is executed before the secondary constructor body.
 * Even if the class has no primary constructor, the delegation still happens implicitly,
 * and the initializer blocks are still executed
 */
class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor $i")
    }
}

/**
 * If a non-abstract class does not declare any constructors (primary or secondary),
 * it will have a generated primary constructor with no arguments. The visibility of
 * the constructor will be public. If you don't want your class to have a public
 * constructor, declare an empty primary constructor with non-default visibility
 */
class DoNotCreateMe private constructor() { /*...*/ }

/**
 * A class and some of its members may be declared abstract. An abstract member
 * does not have an implementation in its class. You don't need to annotate
 * an abstract class or function with open.
 * You can override a non-abstract open member with an abstract one.
 */
open class Polygon {
    open fun draw() { /*...*/ }
}
abstract class Rectangle: Polygon() {
    abstract override fun draw()
}

fun main() {
    val constructors = Constructors(1)

    /**
     * To create an instance of a class, call the constructor
     * as if it were a regular function
     */
    val invoice = Invoice()
    val customer = Customer("Joe")

    /**
     * Classes can contain:
     * 1. Constructors and initializer blocks
     * 2. Functions
     * 3. Properties
     * 4. Nested and inner classes
     * 5. Object declarations
     */

}