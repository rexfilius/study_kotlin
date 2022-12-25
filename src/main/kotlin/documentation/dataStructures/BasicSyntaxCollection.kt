package basics.basicSyntax

fun main() {

    val items = listOf("cashew", "orange", "banana", "apple")

    // iterating over a collection
    for (item in items) {
        print("$item. ")
    }
    println("\n")

    // Checking if a collection contains an object using in operator:
    when {
        "orange" in items -> println("orange is juicy")
        "apple" in items -> println("apple is fine too")
    }
    println("\n")

    // Using lambda expressions to filter and map collections
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }

}