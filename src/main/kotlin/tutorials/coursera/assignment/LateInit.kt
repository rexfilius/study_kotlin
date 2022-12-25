package assignment

class A {
    private lateinit var value: String

    fun setUp() {
        value = "value"
    }

    fun display() {
        println(value)
    }
}

fun main() {
    val a = A()
    a.setUp()   // this fixes the exception
    a.display() // throws UninitializedPropertyAccessException
}