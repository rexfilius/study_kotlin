package documentation.typeSystem

import getAStringNull
import getAnyObject

/**
 * Kotlin's type system is aimed to eliminate NullPointerException from our code.
 * The only possible causes of NPEs may be:
 * 1. An explicit call to throw NullPointerException().
 * 2. Usage of the not-null assertion (!!) operator.
 * 3. Some data inconsistency with regard to initialization, such as when:
 *    - An uninitialized this available in a constructor is passed and used somewhere
 *    ("leaking this ").
 *    - A superclass constructor calls an open member whose implementation in the derived
 *    class uses uninitialized state.
 * 4. Java interoperation:
 *    - Attempts to access a member on a null reference of a platform type.
 *    - Generic types used for Java interoperation with incorrect nullability, e.g.
 *    a piece of Java code might add null into a Kotlin MutableList<String>, meaning
 *    that MutableList<String?> should be used for working with it.
 *    - Other issues caused by external Java code
 * ...you can declare a variable as nullable to allow nulls e.g val typeSystem.getX: String? = null
 */
fun main() {

    var aWord = "Coding"
    //aWord = null // compilation error

    var bWord: String? = "Programming"
    bWord = null // okay
    println(bWord)

    /**
     * CHECKING FOR NULL CONDITIONS.
     * Note that this only works where a variable is immutable (that means a local variable
     * which is not modified between the check and the usage or a member val which has a
     * backing field and is not overridable), because otherwise it might happen
     * that the variable changes to null after the check
     */
    val d: String? = getAStringNull()
    val printD = if (d != null) d.length else -1    // can be an Elvis expression

    val lang: String? = getAStringNull()
    if (lang != null && lang.isNotEmpty()) {
        println("String of length ${lang.length}")
    } else {
        println("Empty string")
    }

    /**
     * SAFE CALLS.
     * To perform a certain operation only for non-null values, you can use
     * the safe call operator together with let
     */
    val sm = "Kotlin"
    val f: String? = getAStringNull()
    println(f?.length)
    println(sm?.length)    // Unnecessary safe call
    println()

    val listWithNulls: List<String?> = listOf("Kotlin", null, "Scala")
    for (item in listWithNulls) {
        item?.let { println(it) }
        // ignores null and prints other items in list if you use a "safe call"
    }
    println()

    /**
     * ELVIS OPERATOR
     * - When you have a nullable reference, you can say "if value is not null, use it,
     * otherwise use some non-null value".
     * - If the expression to the left of - ?: - isn't null, the elvis operator returns
     * it, otherwise it returns the expression to the right.
     * - Note that the right-hand side expression is evaluated only if the left-hand
     * side is null.
     */
    val city = getAStringNull()
    val t = city?.length ?: "No value"

    /**
     * NOT-NULL ASSERTION OPERATOR
     * converts any value to a non-null type and throws an exception if the value is null.
     * You can write b!!, and this will return a non-null value of b or throw an NPE if
     * b is null. Thus, if you want an NPE, you can have it, but you have to ask for
     * it explicitly, and it does not appear out of the blue
     */
    //val ch = city!!.length
    //println(ch)   // NullPointerException is thrown if 'ch' is null

    /**
     * SAFE CASTS
     * Regular casts may result into a ClassCastException if the object is not of the
     * target type. Another option is to use safe casts that return null if the attempt
     * was not successful
     */
    val a = getAnyObject()
    val aInt: Int? = a as? Int

    // If you have a collection of elements of a nullable type and want to filter
    // non-null elements, you can do so by using filterNotNull:
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()
    println(intList)

}

/**
 * Since throw and return are expressions in Kotlin, they can also be used on the right
 * hand side of the elvis operator. This can be very handy, for example, for checking
 * function arguments
 */

/*fun foo(node: Node): String? {
    val parent = node.getParent() ?: return null
    val name = node.getName() ?: throw IllegalArgumentException("name expected")
    // ...
}*/
