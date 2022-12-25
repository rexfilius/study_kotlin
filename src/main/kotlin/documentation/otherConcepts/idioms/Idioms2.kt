package basics.idioms

fun main() {

    // Iterating over a Range
    for (i in 1..20) {
        print("$i. ")   // closed range - includes 20
    }
    println()
    for (i in 1 until 20) {
        print("$i. ")   // half open range - does not include 20
    }
    println()
    for (x in 2..10 step 2) {
        print("$x. ")
    }
    println()
    for (x in 10 downTo 1) {
        print("$x. ")
    }
    println()
    for (x in 1..10) {
        print("$x. ")
    }
    println("\n")
}

// Extension functions
fun String.toOppositeCase() {
    val word: String = ""
    for (letter in word) {
        if (letter.isLowerCase())
            letter.isUpperCase()
        if (letter.isUpperCase())
            letter.isLowerCase()
        print("$letter")
    }
}