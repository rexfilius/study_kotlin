package documentation.classes

/**
 * Interfaces in Kotlin can contain declarations of abstract methods, as well as method
 * implementations. What makes them different from abstract classes is that interfaces
 * cannot store state. They can have properties but these need to be abstract
 * or to provide accessor implementations
 */
interface Childish {
    /**
     * You can declare properties in interfaces. A property declared in an interface
     * can either be abstract, or it can provide implementations for accessors.
     * Properties declared in interfaces can't have backing fields,
     * and therefore accessors declared in interfaces can't reference them
     */
    val energyLevel: Int  // abstract
    val speed: Int
        get() = energyLevel / 20

    fun naughty()
    fun foolish() {
        // optional body
    }
}

interface Babying {
    fun sleeping()
    fun crying()
}

// A class or object can implement one or more interfaces
class Child : Childish, Babying {

    override val energyLevel: Int = 60

    override fun naughty() {
        // ...
    }

    override fun sleeping() {
        // ...
    }

    override fun crying() {
        // ...
    }
}