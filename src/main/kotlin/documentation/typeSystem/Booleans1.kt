package documentation.typeSystem

fun main() {
    /*
    * The type Boolean represents boolean objects that can have two values: true and false.
    * Boolean has a nullable counterpart declared as Boolean?.
    * On the JVM, booleans stored as the primitive boolean type typically use 8 bits.
    * ...
    * Built-in operations on booleans include:
    * || –> disjunction (logical OR)
    * && –> conjunction (logical AND)
    * ! –> negation (logical NOT)
    * ...
    * The OR and 'AND' operators work lazily, which means:
    * If the first operand is true, the || operator does not evaluate the second operand.
    * If the first operand is false, the && operator does not evaluate the second operand.
    */

    val myTrue = true
    val myFalse = false
    val boolNull: Boolean? = null

    println(myTrue || myFalse) // true
    println(myTrue && myFalse) // false
    println(!myTrue) // false
    println(boolNull) // null
}