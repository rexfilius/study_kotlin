package collections

fun main() {

    // list
    /*val result = listOf(1,3,4,7)
    println(result)

    val city = listOf("Lagos", "Abuja", "PH", "Warri", "Kano")
    for ((index, element) in city.withIndex()) {
        println("$element at index $index")
    }*/

    // mutable list
    /*val numbers = mutableListOf(3,45,6,7,8,45,33)
    numbers.add(5)
    println(numbers)
    numbers.removeAt(1)
    println(numbers)
    numbers[0] = 100
    println(numbers)
    numbers.shuffle()
    println(numbers)*/

    val figures = setOf(3,3,45,5,4,3,2,4,5)
    println("elements in figures are ${figures.size}")
    println()

    val maps = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
    println("all keys = ${maps.keys}")
    println("all values = ${maps.values}")
}
