package thirtyDaysOfCode

class PrintArrayKt<T>(private val array: Array<T>) {
    fun printArray() {
        for (element in array) {
            println(element)
        }
    }
}

fun main() {
    val intPrinter = PrintArrayKt<Int>(arrayOf(1, 4, 5, 76))
    val stringPrinter = PrintArrayKt<String>(arrayOf("Jude", "Kyle", "Jane"))

    intPrinter.printArray()
    stringPrinter.printArray()
}