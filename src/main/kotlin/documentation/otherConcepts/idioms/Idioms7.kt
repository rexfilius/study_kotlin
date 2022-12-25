package basics.idioms

import java.math.BigDecimal
import java.nio.file.Files
import java.nio.file.Paths

fun main() {

    // Nullable Boolean
    val bool: Boolean? = false
    if (bool == true) {
        // ...
    } else {
        // b is false or null
    }

    // Swap two variables
    var a = 1
    var b = 2
    a = b.also { b = a }
    println(a)

    calcTaxes()
}

// Java 7's try-with-resources
fun printTextFile() {
    val stream = Files.newInputStream(Paths.get("/some/file.txt"))
    stream.buffered().reader().use { reader ->
        println(reader.readText())
    }
}

// Mark code as incomplete
fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")