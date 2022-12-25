package raywenderlich.util

fun head(s: String) = println("<-- $s -->")

infix fun String.tag(s: String) = println("<-- $s -->")

infix fun String.newLine(s: String) = println(s)

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}

fun <T> MutableList<T>.swapIndexInList(first: Int, second: Int) {
    val aux = this[first]
    this[first] = this[second]
    this[second] = aux
}

fun <T> Array<T>.swapIndexInArray(first: Int, second: Int) {
    val aux = this[first]
    this[first] = this[second]
    this[second] = aux
}