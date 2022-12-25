package functions

fun max(a: Int, b: Int): Int {
    return if(a > b) a else b
}

fun printMyName(name: String) {
    println("Hey $name")
}

fun displaySeparator(character: Char = '*', size: Int = 10) {
    repeat(size) {
        print(character)
    }
    println()
}

fun main() {
    printMyName("Josh")

    println(listOf('a', 'b', 'c').joinToString(
        separator = "", prefix = "(", postfix = ")"))

    displaySeparator()
    displaySeparator(size = 3)
    displaySeparator('+',3)
}