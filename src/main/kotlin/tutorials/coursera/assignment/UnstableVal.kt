package assignment

import kotlin.random.Random

// Method 1
val foo: Int
    get() = Random.nextInt()

// Method 2
/*var counter = 0
val foo: Int
    get() = counter++*/

fun main() {
    // foo will print out different values
    println(foo)
    println(foo)
    println(foo)
}