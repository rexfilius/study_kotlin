package raywenderlich.stack

/**
 * - The stack data structure is identical, in concept, to a physical stack of objects.
 * When you add an item to a stack, you place it on top of the stack. When you remove
 * an item from a stack, you always remove the top-most item.
 * - The main goal of building a stack is to enforce how you access your data.
 *
 * - There are only two essential operations for a stack:
 * (1) push: Adding an element to the top of the stack.
 * (2) pop: Removing the top element of the stack.
 * - This means that you can only add or remove elements from one side of the data
 * structure. In computer science, a stack is known as the LIFO (last-in first-out)
 * data structure. Elements that are pushed in last are the first ones to be popped out.
 *
 * - You can implement your Stack interface in different ways and choosing the right
 * storage type is important. The ArrayList is an obvious choice since it offers
 * constant time insertions and deletions at one end via 'add' & 'removeAt' with the
 * last index as a parameter. Usage of these two operations will facilitate the LIFO
 * nature of stacks.
 *
 * - Stacks are crucial to problems that search trees and graphs. Imagine finding your
 * way through a maze. Each time you come to a decision point of left, right or
 * straight, you can push all possible decisions onto your stack. When you hit a dead
 * end, backtrack by popping from the stack and continuing until you escape or hit
 * another dead end.
 */
class Stack<T> : StackInterface<T> {

    private val storage = arrayListOf<T>()

    override fun toString(): String = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine(it)
        }
        appendLine("-----------")
    }

    /**
     * - Append the value passed as parameter to the end of the ArrayList.
     * - O(1) time complexity.
     */
    override fun push(element: T) {
        storage.add(element)
    }

    /**
     * - Return null if storage is empty or remove and return the last element inserted.
     * - O(1) time complexity.
     */
    override fun pop(): T? {
        if (isEmpty) return null
        return storage.removeAt(count - 1)
    }

    /**
     * - Peek is an operation that's often attributed to the stack interface. The idea
     * of peek is to look at the top element of the stack without mutating its contents
     * - O(n) time complexity??
     */
    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    /**
     * - You may have wondered if you could adopt the Kotlin collection interfaces
     * for the stack. A stack's purpose is to limit the number of ways to access your
     * data, and adopting interfaces such as Iterable would go against this goal by
     * exposing all the elements via iterators. In this case, less is more!
     *
     * - You might want to take an existing list and convert it to a stack so that
     * the access order is guaranteed. Of course, it would be possible to loop
     * through the array elements and push each element. However, you can write a
     * static factory method that directly adds these elements to the Stack implementation
     */
    companion object {
        fun <T : Any> createFromIterable(
            items: Iterable<T>
        ): StackInterface<T> {
            val stack = Stack<T>()
            for (item in items) stack.push(item)
            return stack
        }
    }

}

/**
 * This function makes a stack initializable by listing its elements, similar to
 * listOf() and other standard library collection factory functions
 */
fun <T : Any> myStackOf(vararg elements: T): StackInterface<T> {
    return Stack.createFromIterable(elements.asList())
}