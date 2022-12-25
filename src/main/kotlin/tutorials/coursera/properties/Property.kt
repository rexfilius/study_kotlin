package properties

fun main() {
    val rectangle = Rectangle(2,3)
    println(rectangle.isSquare)

    // A Lazy Property
    val lazyValue: String by lazy {
        println("computed")
        "Hello"
    }

    println(lazyValue)
    println(lazyValue)
}

class Rectangle(private val height: Int, private val width: Int) {
    // defining properties without fields
    val isSquare: Boolean
    get() = height == width
}

class LengthCounter {

    // Accessor visibility
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}