package documentation.classes

/**
 * Overriding properties works in a similar way to overriding methods;
 * properties declared on a superclass that are then re-declared on a derived class
 * must be prefaced with override, and they must have a compatible type.
 * Each declared property can be overridden by a property with an initializer
 * or by a property with a get method
 */
open class Shape2 {
    open val vertexCount: Int = 0
    open val sides: Int = 0
}

class Rectangle2 : Shape2() {
    override val vertexCount: Int = 4
    override val sides: Int
        get() = 4
}

/**
 * You can override a val property with a var property, but not vice versa.
 * Also, you can use the override keyword as part of the property declaration
 * in a primary constructor
 */
interface ShapeX {
    val vertexCount: Int
}
class Rectangle3(override val vertexCount: Int = 4) : ShapeX
class Polygon2 : ShapeX {
    override val vertexCount: Int = 0  // can be set to any number later
}

/**
 * During construction of a new instance of a derived class,
 * the base class initialization is done as the first step
 * (preceded only by evaluation of the arguments for the base class constructor)
 * and thus happens before the initialization logic of the derived class is run
 * ...
 * NOTE - When designing a base class, you should therefore avoid
 * using open members in the constructors, property initializers, and init blocks.
 */
open class Base3(val name: String) {
    init {
        println("Initializing a base class")
    }

    open val size: Int = name.length.also {
        println("Initializing size in the base class: $it")
    }

}

class Derived3(name: String, val lastName: String) :
    Base3(name.capitalize().also { println("Argument for the base class $it") }) {

    init {
        println("Initializing a derived class")
    }

    override val size: Int = (super.size + lastName.length).also {
        println("Initializing size in the derived class $it")
    }

}

fun main() {
    val derived3 = Derived3("hello", "world")
}