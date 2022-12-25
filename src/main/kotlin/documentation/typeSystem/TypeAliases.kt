package typeSystem

import java.io.File

/**
 * Type aliases provide alternative names for existing types. If the type name is too long
 * you can introduce a different shorter name and use the new one instead. It's useful to
 * shorten long generic types. For instance, it's often tempting to shrink collection
 * types. And you can provide different aliases for function types.
 * ...
 * Type aliases do not introduce new types. They are equivalent to the corresponding
 * underlying types. When you add 'typealias Predicate<T>' and use 'Predicate<Int>' in
 * your code, the Kotlin compiler always expands it to '(Int) -> Boolean.
 */
typealias FileTable<K> = MutableMap<K, MutableList<File>>
typealias MyHandler = (Int, String, Any) -> Unit
typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Int>) = p(42)

class A3 {
    inner class Inner
}

class B3 {
    inner class Inner
}
typealias AInner = A3.Inner
typealias BInner = B3.Inner

fun main() {
    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f))    // prints 'true'

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p))    // prints '[1]'
}