package inline

fun main() {

    val foo = run {
        println("Calculating foo...")
        "foo"
    }
    println(foo)

    val number = 42
    println(number.takeIf { it > 10 })

    val num = 5
    println(num.takeIf { it > 10 })

    repeat(10) {
        println("Welcome")
    }

    val name = "Kotlin"
    myRun { println("Hi, $name!") } // brings performance overhead
}

fun myRun(f: () -> Unit) = f()