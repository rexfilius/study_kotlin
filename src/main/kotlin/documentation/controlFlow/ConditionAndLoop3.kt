package controlFlow

fun main() {

    // the 'for' loop iterates through anything that provides an iterator
    for (x in 1..24) print("$x ")
    println()
    for (item in listOf("jam", "bag")) {
        print("$item ")
    }
    println()

    for (i in 1..3) print("$i ")
    println()
    for (i in 6 downTo 0 step 2) print("$i ")
    println("\n")

    // A for-loop over a range or an array is compiled to an index-based loop that does
    // not create an iterator object. if you want to iterate through an array or a list
    // with an index, you can do it this way
    val itemArray = arrayOf("Cup", "bag", "Spoon", "Plate")
    for (i in itemArray.indices) {
        print("${itemArray[i]} ")
    }
    println()
    for (i in itemArray) {
        print(i)  // same as above - above recommended by documentation
    }
    println()
    for ((index, value) in itemArray.withIndex()) {
        println("item at $index is $value")
    }
    println()

    /**
     * while and do-while loops execute their body continuously while their condition
     * is satisfied. The difference between them is the condition checking time:
     * 'while' checks the condition and, if it's satisfied,
     * executes the body and then returns to the condition check.
     * 'do-while' executes the body and then checks the condition. If it's satisfies,
     * the loop repeats. So, the body of do-while executes at least once
     * regardless of the condition
     */
    var x = 2 * 3
    while (x > 0) {
        print("$x. ")
        x--
    }
    println()

    // error
//    do {
//        var y = 2 + 8
//        print("$y. ")
//        y--
//    } while (y > 0)


}