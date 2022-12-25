package loops

fun main() {
    val list = listOf("a", "b", "c")
    for(s: String in list) {    // you can opt not to write the type of 's'
        print(s)
    }

    println()

    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    for ((key, value) in map) {
        println("$key = $value")
    }

    println()

    val lists = listOf("a", "b", "c")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    println()

    for (i in 1..9) {   // this prints 123456789
        print(i)
    }

    println()

    for (i in 1 until 9) {  // this prints 12345678
        print(i)
    }

    println()

    for (i in 9 downTo 1 step 2) {  // this prints 97531
        print(i)
    }

    println()

    for (ch in "abc") { // this prints -> bcd
        print(ch + 1)
    }

    println()
}