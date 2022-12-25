package sequences

fun main() {

    // As Collections
    val list = listOf(1,2,3,4)
            .map { it * it }
            .find { it > 3 }
    println(list)

    // As Sequences
    val list2 = listOf(1,2,3,4)
            .asSequence()
            .map { it * it }
            .find { it > 3 }
    println(list2)

    val list3 = listOf(1,2,3,4)
    list3.map(::m).filter(::f)
    println()
    list3.asSequence().map(::m).filter(::f).toList()
    println()
    list3.asSequence().map(::m).filter(::f) // this prints nothing
    println()
    list3.asSequence().filter(::f).map(::m).toList()
    println()
    println("-----------------------------------")

    val numbers = generateSequence(3) {
        n ->
        println("Generating element...")
        (n + 1).takeIf { it < 7}
    }
    println(numbers.first())
    println(numbers.toList())
    println("----------------------------------------")

    val integer = sequence {
        var x = 0
        while (true) {
            yield(x++)
        }
    }
    println(integer.take(5).toList())
    println("----------------------------------------------")

    println(mySequence()
            .map { it * it }
            .filter { it > 10 }
            .take(1)
            .first())   // if you remove first(), a terminal operation, it prints nothing
}

fun m(i: Int): Int {
    print("m$i ")
    return i
}

fun f(i: Int): Boolean {
    print("f$i ")
    return i % 2 == 0
}

fun mySequence() = sequence {
    println("yield one element")
    yield(1)
    println("yield a range")
    yieldAll(3..5)
    println("yield a list")
    yieldAll(listOf(7,9))
}