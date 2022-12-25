package raywenderlich.stack

/**
 * NOTE: This Stack interface is different from the Stack class provided by Kotlin
 * (or Java) which extends the Vector class and provides methods we don't need here.
 */
interface StackInterface<T> {

    // returns the number of elements in the Stack
    val count: Int

    val isEmpty: Boolean
        get() = count == 0

    fun push(element: T)

    fun pop(): T?

    fun peek(): T?

}