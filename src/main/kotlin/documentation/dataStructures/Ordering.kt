package documentation.dataStructures

/**
 * The order of elements is an important aspect of certain collection types. e.g,
 * two lists of the same elements are not equal if their elements are ordered differently.
 * In Kotlin, the orders of objects can be defined in several ways. First, there is natural
 * order. It is defined for inheritors of the Comparable interface. Natural order is used
 * for sorting them when no other order is specified. Most built-in types are comparable:
 * ...
 * > Numeric types use the traditional numerical order: 1 is greater than 0;
 *   -3.4f is greater than -5f.
 * > Char and String use the lexicographical order: b is greater than a;
 *   world is greater than hello.
 * ...
 * To define a natural order for a user-defined type, make the type an inheritor of
 * Comparable. This requires implementing the compareTo() function. compareTo() must take
 * another object of the same type as an argument and return an integer value showing
 * which object is greater:
 * > Positive values show that the receiver object is greater.
 * > Negative values show that it's less than the argument.
 * > Zero shows that the objects are equal.
 */
fun main() {

    println(Version(1, 2) > Version(1, 3))
    println(Version(2, 0) > Version(1, 5))
    println()

    /**
     * Custom orders let you sort instances of any type in a way you like. Particularly,
     * you can define an order for non-comparable objects or define an order other than
     * natural for a comparable type. To define a custom order for a type, create a
     * Comparator for it. Comparator contains the compare() function: it takes two
     * instances of a class and returns the integer result of the comparison between them.
     * The result is interpreted in the same way as the result of a compareTo()
     * ...
     * In the example below, you're able to arrange strings by their length instead of
     * the default lexicographical order.
     */
    val lengthComparator = Comparator { str1: String, str2: String ->
        str1.length - str2.length
    }
    println(listOf("aaa", "bb", "c").sortedWith(lengthComparator))

    /**
     * A shorter way to define a Comparator is the compareBy() function from the standard
     * library. compareBy() takes a lambda function that produces a Comparable value from
     * an instance and defines the custom order as the natural order of the produced
     * values
     */
    val anotherComparator =
            listOf("aaa", "bb", "c").sortedWith(compareBy { it.length })
    println(anotherComparator)

}

class Version(private val major: Int, private val minor: Int) : Comparable<Version> {
    override fun compareTo(other: Version): Int {
        return when {
            this.major != other.major -> this.major - other.major
            this.minor != other.minor -> this.minor - other.minor
            else -> 0
        }
    }
}