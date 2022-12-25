package controlFlow

fun main() {

    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) print("$item..")
    println("\n")

    val fruits = listOf("apple", "banana", "kiwifruit")
    for (index in fruits.indices) {
        println("fruit at $index is ${fruits[index]}")
    }
    println()

    val names = listOf("John", "Jake", "Jane", "Judy")
    var index = 0
    while (index < names.size) {
        println("name at $index is ${names[index]}")
        index++
    }
    println()

    println(describe(4))

}

fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }