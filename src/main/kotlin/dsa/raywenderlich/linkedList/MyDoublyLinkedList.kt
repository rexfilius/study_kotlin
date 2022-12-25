package raywenderlich.linkedList

/**
 * A doubly linked list is simply a linked list in which nodes also contain
 * a reference to the previous node.
 */
class MyDoublyLinkedList<T> {

    private var head: MyDoubleNode<T>? = null
    private var tail: MyDoubleNode<T>? = null

    val first: MyDoubleNode<T>?
        get() = head

    fun isEmpty(): Boolean {
        return head == null
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty List"
        }
        return head.toString()
    }

    fun append(value: T) {
        val newNode = MyDoubleNode(value = value, previous = tail)
        if (isEmpty()) {
            head = newNode
            tail = newNode
            return
        }

        tail?.next = newNode
        tail = newNode
    }

    fun nodeAt(index: Int): MyDoubleNode<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex += 1
        }

        return currentNode
    }

    fun remove(node: MyDoubleNode<T>): T {
        // if node is raywenderlich.util.head, prev == null
        val prev = node.previous
        val next = node.next

        if (prev != null) {
            prev.next = node.previous
        } else {
            head = next
        }

        next?.previous = prev

        if (next == null) {
            tail = prev
        }

        // pretty much detaching the node to be removed from the link
        // by making its prev and next reference to be null
        node.previous = null
        node.next = null

        return node.value
    }

}