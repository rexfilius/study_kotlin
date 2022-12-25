package collections

import java.util.concurrent.TimeUnit
import kotlin.system.measureNanoTime

fun main() {

    /* measure {
         /* generate large sequences */
         val list = generateSequence(1) { it + 1 }
             .take(50_000_000)
             .toList()
         // change 'list' to 'sequence' and remove 'toList()'
         // -> time of execution will be lower

         val result = list.filter { it % 3 == 0 }
             .average()
         println("Done!")
         println(result)
     }*/

    /* kotlin sequences
    * for very large lists Sequences are more efficient than List */
    /*listOf("A", "B", "C")
        .filter {
            println("filter: $it")
            true
        }
        .forEach {
            println("forEach: $it")
        }
    println("------------------------------")
    sequenceOf("X", "Y", "Z")
        .filter {
            println("filter: $it")
            true
        }
        .forEach {
            println("forEach: $it")
        }*/
}

fun measure(block: () -> Unit) {
    val nanotime = measureNanoTime(block)
    val millis = TimeUnit.NANOSECONDS.toMillis(nanotime)
    println("$millis ms")
}