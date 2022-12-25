package typeSystem

// Top level variables
val PI = 3.14
var x = 0

fun main() {

    // Read-only local variables are defined using the keyword val.
    // They can be assigned a value only once.
    // >>>
    val a: Int = 1  // immediate assignment
    val b = 2   // int type is inferred
    val c: Int  // type is required when no initializer is provided
    c = 3   // deferred assignment

    // Variables that can be reassigned use the var keyword
    var x = 5
    x += 1
}

fun incrementX() {
    x += 1
}