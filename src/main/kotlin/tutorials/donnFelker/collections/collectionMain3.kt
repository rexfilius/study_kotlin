package collections

fun main() {

    /* while Loop */
    var x = 0
    while (x < 10) {
        println(x)
        x++
    }
    println("--------------------------------------------")

    /* forEach iteration
    *  preferable mode of iteration on Collections...
    * more idiomatic and easier to read */
    val guys = listOf(
        Guy("Femi"),
        Guy("John"),
        Guy("Brian"),
        Guy("Felix")
    )
    guys.forEach { println(it) }
    println("----------------------------------------------------")

    guys.forEachIndexed { index, guy ->
        println("Index: $index, Guy: $guy")
    }
    println("------------------------------------------------------")

    val guy1 = listOf(
        Guy("Donn"),
        Guy("Jake"),
        Guy("Janet"),
        Guy("Kavita")
    )

    val guy2 = listOf(
        Guy("Donn"),
        Guy("Janet"),
        Guy("Jumo"),
        Guy("kavita"),
        Guy("Kevin"),
        Guy("Cathy")
    )

    val uniqueValues = guy1.union(guy2)
    println(uniqueValues)
    println("---------------------------------------------------")

    /* Kotlin Ranges */
    val i = 12
    if (i in 1..5) {
        println("yes")
    } else {
        println("No")
    }

    for (j in 0..10 step 2) {
        println(j)
    }
}

data class Guy(val name: String)