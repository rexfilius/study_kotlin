package dataStructures

fun main() {

    /**
     * RANGE
     * A range defines a closed interval in the mathematical sense: it is defined by its
     * two endpoint values which are both included in the range. Ranges are defined for
     * comparable types: having an order, you can define whether an arbitrary instance is
     * in the range between two given instances. The typeSystem.main operation on ranges is 'contains'
     * which is usually used in the form of 'in' and '!in' operators
     */

    /**
     * The ranges of integral types, such as Int, Long, and Char, can be treated as
     * arithmetic progressions of them. In Kotlin, these progressions are defined by
     * special types: IntProgression, LongProgression, and CharProgression. Progressions
     * have three essential properties: the first element, the last element, and a
     * non-zero step. The first element is first, subsequent elements are the previous
     * element plus a step. Iteration over a progression with a positive step is
     * equivalent to an indexed for loop in Java/JavaScript
     * ...
     * When you create a progression implicitly by iterating a range, this progression's
     * first and last elements are the range's endpoints, and the step is 1
     */
    for (p in 1..10) print("$p..")
    println()

    // to define a custom progression step, use the step function on a range
    for (f in 1..8 step 2) print("$f..")
    println()

    // progressions implement Iterable<N>, where N is Int, Long, or Char respectively
    // so you can use them in various collection functions
    print((1..20).filter { it % 2 == 0 })

}
