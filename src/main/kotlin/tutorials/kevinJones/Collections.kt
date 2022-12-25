fun main() {
    var evenNumbers: List<Int>? = listOf(2, 4, 6, 8, 10)

    var oddNumbers: List<Int?> = listOf(3, 5, 7, 9, null)

    doSomething(action)
}

val action = { println("Hello World") }
val multiply = { x: Int, y: Int -> x * y }

fun doSomething(func: () -> Unit) {
    func()
}