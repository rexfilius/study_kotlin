package functions

/**
 * If a function does not return any useful value, its return type is Unit. Unit is a type
 * with only one value - Unit. This value does not have to be returned explicitly
 */
fun printHi(name: String?) {
    if (name != null)
        println("Hi $name")
    else
        println("Hi there!")
}

/**
 * When a function returns a single expression, the curly braces can be omitted and the
 * body is specified after a '=' symbol. Explicitly declaring the return type is optional
 * when this can be inferred by the compiler
 */
fun triple(x: Int): Int = x * 3
fun printAlph(s: String) = "$s is an alphabet"

/**
 * EXPLICIT RETURN TYPES
 * Functions with block body must always specify return types explicitly, unless it's
 * intended for them to return Unit, in which case it is optional. Kotlin does not infer
 * return types for functions with block bodies because such functions may have complex
 * control flow in the body, and the return type will be non-obvious to
 * the reader (and sometimes even for the compiler)
 */

/**
 * You can mark a parameter of a function (usually the last one) with the 'vararg'
 * modifier. You can pass a variable number of arguments to the function. Only one
 * parameter can be marked as vararg. If a vararg parameter is not the last one in the
 * list, values for the following parameters can be passed using the named argument syntax,
 * or, if the parameter has a function type, by passing a lambda outside parentheses.
 */
fun <T> asAList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts)  // ts is an ArrayList
        result.add(t)
    return result
}

/**
 * INFIX NOTATION
 * Functions marked with the infix keyword can also be called using the infix notation
 * (omitting the dot and the parentheses for the call). Infix functions must meet the
 * following requirements:
 * 1. They must be member functions or extension functions.
 * 2. They must have a single parameter.
 * 3. The parameter must not accept variable number of arguments and must have
 *    no default value
 */

infix fun String.printChars(s: String) {
    for (c in s) {
        println("$c..")
    }
}

/**
 * Note that infix functions always require both the receiver and the parameter to be
 * specified. When you're calling a method on the current receiver using the infix
 * notation, use 'this' explicitly. This is required to ensure unambiguous parsing
 */
class MyStringCollection {
    infix fun add(s: String) {}

    fun build() {
        this add "abc"   // Correct
        add("abc")       // Correct
        //add "abc"        // Incorrect: the receiver must be specified
    }
}


fun main() {

    // "vararg"
    val list = asAList(1, 2, "Name")
    val nameArray = arrayOf("Jon", "Ron", "Jin")
    val finalList = asAList(3, 4, 5, *nameArray, "Kate")

    // infix notation
    val w = "Words"
    w printChars w

}