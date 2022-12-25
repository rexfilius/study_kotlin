package classes

/**
 * An interface with only one abstract method is called a functional interface,
 * or a Single Abstract Method (SAM) interface. The functional interface can have
 * several non-abstract members but only one abstract member. To declare a functional
 * interface, use the 'fun' modifier
 */
fun interface KRunnable {
    fun invoke()
    fun done() {
        // code body
    }
}

/**
 * For functional interfaces, you can use SAM conversions that help make your code more
 * concise and readable by using lambda expressions. Instead of creating a class that
 * implements a functional interface manually, you can use a lambda expression.
 * With a SAM conversion, Kotlin can convert any lambda expression whose signature
 * matches the signature of the interface's single method into an instance
 * of a class that implements the interface
 */
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

// without SAM conversion
val isEven = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}

// with SAM conversion
val isEven2 = IntPredicate {
    it % 2 == 0
}

fun main() {
    println("Is 7 even? - ${isEven2.accept(7)}")
    println("Is 4 even? - ${isEven.accept(4)}")
}

/**
 * Functional interfaces and type aliases serve different purposes:
 * ...
 * 1. Type aliases are just names for existing types – they don't create a new type,
 * while functional interfaces do.
 * 2. Type aliases can have only one member, while functional interfaces
 * can have multiple non-abstract members and one abstract member.
 * 3. Functional interfaces can also implement and extend other interfaces.
 * ...
 * Considering the above, functional interfaces are more flexible and
 * provide more capabilities than type aliases
 */