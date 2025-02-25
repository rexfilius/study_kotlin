package documentation.functions

// functions in Kotlin are declared using the 'fun' keyword
fun double(x: Int): Int {
    return 2 * x
}

// calling functions uses the traditional approach
val result = double(2)

/**
 * Function parameters are defined using Pascal notation - 'name: type'. Parameters are
 * separated using commas. Each parameter must be explicitly typed
 */
fun powerOf(number: Int, exponent: Int): Int {
    return number.times(exponent) // placeholder code
}

/**
 * Function parameters can have default values, which are used when you skip the
 * corresponding argument. This reduces a number of overloads.
 */
fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {}

/**
 * Overriding methods always use the same default parameter values as the base method.
 * When overriding a method with default parameter values, the default parameter values
 * must be omitted from the signature
 */
open class A5 {
    open fun foo(i: Int = 10) {}
}

class B4 : A5() {
    override fun foo(i: Int) {}
}

/**
 * If a default parameter precedes a parameter with no default value, the default value
 * can only be used by calling the function with named arguments
 */
fun printSomething(greet: String = "Hello", name: String) {}
val printAThing = printSomething(name = "Jake")

/**
 * If the last argument after default parameters is a lambda, you can pass it either as
 * a named arguments or outside the parentheses
 */
fun printHello(greet: String = "Hi", species: String = "Human", words: () -> Unit) {}

// xx uses default value 'species = Human'
val xx = printHello("whats up") { println("How are you") }

// yy uses both default values 'greet = Hi' and 'species = Human'
val yy = printHello(words = { println("Who are you") })

// zz uses both default values 'greet = Hi' and 'species = Human'
val zz = printHello { println("How are you doing") }