import java.lang.Thread.sleep
import kotlin.random.Random

fun main() {

    /* Lazy evaluation */
    val name: String by lazy {
        println("Computed")
        sleep(3000)
        "Donn"
    }

    println(name)
    println(name)
    println(name)
    println("------------------------------------------------------")

    /* Lazy Initializer block */
    val result = lazy { someExpensiveOperation() }
    println(result)
    println("Is initialized: ${result.isInitialized()}")
    println(result.value)
    println(result.value)
    println(result.value)

    /* Type Inference
    *  you cannot infer a type with lateinit variable*/
    val n = "Donn"
    val age = 13
    lateinit var food: String
    println(n)
    println(age)
}

fun nameReversed(name: String): String {
    return name.reversed()
}

fun someExpensiveOperation(): Int {
    println("computed")
    sleep(1000)
    return Random(System.currentTimeMillis()).nextInt()
}