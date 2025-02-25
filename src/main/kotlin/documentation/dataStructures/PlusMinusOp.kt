package documentation.dataStructures

/**
 * In Kotlin, plus (+) and minus (-) operators are defined for collections. They take a
 * collection as the first operand; the second operand can be either an element or another
 * collection. The return value is a new read-only collection:
 * The result of plus contains the elements from the original collection and from the
 * second operand.
 * The result of minus contains the elements of the original collection except the
 * elements from the second operand. If it's an element, minus removes its first
 * occurrence; if it's a collection, all occurrences of its elements are removed
 */
fun main() {

    val numbers = listOf("one", "two", "three", "four")

    val plusList = numbers + "five"
    val minusList = numbers - listOf("three", "four")

    println("numbers: $numbers")
    println("plusList: $plusList")
    println("minusList: $minusList")
}

/**
 * For the details on plus and minus operators for maps, see Map specific operations.
 * The augmented assignment operators plusAssign (+=) and minusAssign (-=) are also
 * defined for collections. However, for read-only collections, they actually use the plus
 * or minus operators and try to assign the result to the same variable. Thus, they are
 * available only on var read-only collections. For mutable collections, they modify the
 * collection if it's a val. For more details see Collection write operations
 */