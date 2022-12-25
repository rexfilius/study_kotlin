package intro

fun main() {
    val names = listOf("Ted", "Billy", "Ryan")
    println(names)
    println("Hello ${names[0]}, ${names[1]} and ${names[2]}")

    val languages = listOf("Java", "Kotlin", "Python", "Go")
    for ((index, element) in languages.withIndex()) {
        println("Hello $element at number $index")
    }

    val cars = listOf("Benz", "BMW", "Audi", "Porsche", "Lexus")
    for (element in cars) {
        print("$element ")
    }
    println()

    // listOf is immutable, arrayListOf is mutable
    val cities = arrayListOf("London", "Paris", "Tokyo", "Sydney")
    println(cities)
    cities.add("Bombay")
    println(cities)

    val grades = mutableListOf(70, 100, 40, 65, 80, 70, 30, 40, 20, 10)
    println(grades.filter { it > 50 })
    println("Average Grade: ${grades.average()}")
    grades.swap(0, 1)
    println(grades)
}

// An example of Extension Function
// it helps you to create a function on a class you don't own
fun MutableList<Int>.swap(one: Int, two: Int) {
    val tempIndex = this[one]
    this[one] = this[two]
    this[two] = tempIndex
}