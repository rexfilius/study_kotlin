package operators

import newLine

fun main() {
    /**
     * BOOLEAN represents boolean objects that can have two values: true and false.
     * Boolean has a nullable counterpart Boolean? that also has the null value.
     * Built-in operations on booleans include:
     * - || disjunction (logical OR)
     * - && conjunction (logical AND)
     * - ! negation (logical NOT)
     * - || and && work lazily. On JVM: nullable references to boolean objects are boxed
     * similarly to numbers. || and && have infix form.
     */
    val myTrue = true
    val myFalse = false
    val boolNull: Boolean? = null
    println(myTrue || myFalse)
    println(myTrue && myFalse)
    println(!myTrue)
    "" newLine ""
}