package generics

/**
 * - Generics on the JVM are normally implemented through type erasure, meaning the type
 * arguments of an instance of a generic class are not preserved at runtime.
 * - You can declare an inline function so that its type arguments are not erased
 * (or, in Kotlin terms, are reified)
 * - Note that erasing generic type information has its benefits: the overall amount of
 * memory used by your application is smaller, because less type information needs to be
 * saved in memory.
 */
fun main() {
    val list1: List<String> = listOf("a", "b")
    val list2: List<Int> = listOf(1, 2, 3)

    // Compiler states "This is a useless 'is' check"
    if (list1 is List<String>)
        println("list1 is a list of String")
    else
        println("we cannot know if list1 is a list of String")

    // Using a type cast with a generic type - did not work as expected
    printSum(listOf(1, 2, 3))

    // Using a type check with a known type argument
    printSum2(listOf(1, 2, 3))

}

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int>
        ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun printSum2(c: Collection<Int>) {
    if (c is List<Int>) println(c.sum())
}
