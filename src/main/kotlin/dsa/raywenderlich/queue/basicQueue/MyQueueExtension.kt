package raywenderlich.queue.basicQueue

import raywenderlich.stack.Stack

/**
 * - Creating a board game manager is straightforward. Your primary concern is whose
 * turn it is. A queue data structure is a perfect choice to take care of game turns.
 * - The time complexity depends on the queue implementation you select. For the
 * array-based queue, it's overall O(n) time complexity. dequeue takes O(n) time
 * because it has to shift the elements to the left every time you remove the first element.
 */
fun <T> MyQueueInterface<T>.nextPlayer(): T? {
    // Get the next player by calling dequeue. If the queue is empty, return null,
    // as the game has probably ended anyway.
    val person = this.dequeue() ?: return null

    // enqueue the same person, this puts the player at the end of the queue
    this.enqueue(person)

    // Return the next player.
    return person
}

/**
 * - Implement a method to reverse the contents of a queue using an extension function.
 * A queue uses first in, first out whereas a stack uses last in, first out. You can
 * use a stack to help reverse the contents of a queue. By inserting all the contents
 * of the queue into a stack, you basically reverse the order once you pop every
 * element off the stack.
 * - The time complexity is overall O(n). You loop through the elements twice. Once for
 * removing the elements off the queue, and once for removing the elements off the stack.
 */
fun <T> MyQueueInterface<T>.reverse() {
    // Create a stack.
    val aux = Stack<T>()

    // dequeue all the elements in the queue onto the stack.
    var next = this.dequeue()
    while (next != null) {
        aux.push(next)
        next = this.dequeue()
    }

    // pop all the elements off the stack and insert them into the queue.
    next = aux.pop()
    while (next != null) {
        this.enqueue(next)
        next = aux.pop()
    }
}