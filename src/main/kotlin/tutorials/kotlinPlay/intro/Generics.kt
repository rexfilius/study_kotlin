package intro

/**
 * Generics are a genericity mechanism that's become standard in modern languages. Generic
 * classes and functions increase code re-usability by encapsulating common logic that is
 * independent of a particular generic type, like the logic inside a List<T> is independent
 * of what T is. The first way to use generics in Kotlin is creating generics classes.
 * [MutableStack] is a generic class where E is called the GENERIC TYPE PARAMETER. At
 * use-site, it is assigned to a specific type such as Int by declaring a MutableStack<Int>
 */
class MutableStack<E>(vararg items: E) {

    private val elements = items.toMutableList()

    /**
     * Inside this generic class, E can be used as a parameter like any other type.
     * You can also use E as a return type
     */
    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.size

    fun size() = elements.size
}

/**
 * You can also generify functions if their logic is independent of a specific type. For
 * instance, you can write a utility function to create mutable stacks. Note that the
 * compiler can infer the generic type from the parameters of mutableStackOf so that
 * you don't have to write mutableStackOf<Double>(...)
 */
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

fun main() {
    val stack = mutableStackOf(0.62, 3.14, 2.7)
    println(stack)
}