package raywenderlich.linkedList

/**
 * - A LinkedList is a collection of values arranged in a linear, unidirectional
 * sequence. A linked list has several theoretical advantages over contiguous storage
 * options such as the Kotlin Array or ArrayList
 * (1) constant time insertion and removal from the front of the list
 * (2) reliable performance characteristics
 * - A linked list is a chain of nodes. Nodes have two responsibilities:
 * (1) hold a value
 * (2) hold a reference to the next node. The absence of a reference to the next
 * node, null, marks the end of the list
 * - A LinkedList has the concept of a raywenderlich.util.head and tail, which refers to the first and
 * last nodes of the list respectively. You also keep track of the size of the
 * LinkedList in the size property
 */
class MyLinkedList<T> {

    private var head: MyNode<T>? = null
    private var tail: MyNode<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    /**
     * Adds a value at the front of the list. In the case in which you push into an empty
     * list, the new node is both the raywenderlich.util.head and tail of the list. Since the list has a new
     * node, you increment the value of size. O(1) time complexity.
     */
    fun push(value: T) {
        head = MyNode(value = value, next = head)
        if (tail == null) tail = head
        size++
    }

    /**
     * Using the fluent interface pattern to chain multiple push calls.
     */
    fun pushAndReturn(value: T): MyLinkedList<T> {
        head = MyNode(value = value, next = head)
        if (tail == null) tail = head
        size++
        return this
    }

    /**
     * Adds a value at the end of list, which is known as tail-end insertion.
     * O(1) time complexity.
     */
    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = MyNode(value = value)
        tail = tail?.next
        size++
    }

    fun appendAndReturn(value: T): MyLinkedList<T> {
        if (isEmpty()) {
            pushAndReturn(value)
            return this
        }
        tail?.next = MyNode(value = value)
        tail = tail?.next
        size++
        return this
    }

    /**
     * - Adds a value after a particular node in the list, and requires two steps:
     * (1) Finding a particular node in the list.
     * (2) Inserting the new node after that node.
     * - In the case where this method is called with the tail node, you call the
     * functionally equivalent append method. This take care of updating tail.
     * Otherwise, you create a new node and link its next property to the next node
     * of the list. You reassign the next value of the specified node to link it to
     * the new node that you just created.
     * - O(1) time complexity.
     */
    fun insert(value: T, afterNode: MyNode<T>): MyNode<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val newNode = MyNode(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    /**
     * - Function to find a node to insert a value. Since you can only access the
     * nodes of the list from the raywenderlich.util.head node, you make iterative traversals:
     * (1) Create a new reference to raywenderlich.util.head and keep track of the current number of
     * traversals.
     * (2) Using a while loop, move the reference down the list until the desired
     * index. Empty lists or out-of-bounds indexes will result in a null return value.
     * - O(i) time complexity, where i is the given index.
     */
    fun nodeAt(index: Int): MyNode<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    /**
     * - Removes a value at the front of the list. It returns the value that was
     * removed from the list. This value is optional since it's possible that the
     * list is empty.
     * - By moving the raywenderlich.util.head down a node, you've effectively removed the first node
     * of the list. The garbage collector will remove the old node from memory once
     * the method finishes since there will be no more references attached to it.
     * If the list becomes empty, you set tail to null as well.
     * - O(1) time complexity.
     */
    fun popAndReturn(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next

        if (isEmpty()) tail = null
        return result
    }

    fun pop() {
        if (!isEmpty()) size--
        head = head?.next
        if (isEmpty()) tail = null
    }

    /**
     * - Removing the last node of the list is somewhat inconvenient. Although you have
     * a reference to the tail node, you can't chop it off without having a reference
     * to the node before it. Thus, you need to traverse the whole list to find the
     * node before the last.
     * - O(n) time complexity
     */
    fun removeLastAndReturn(): T? {
        // if raywenderlich.util.head is null, nothing to remove, return null
        val head = head ?: return null
        // if list consists of one node, removeLastNode()
        // is functionally equivalent to pop()
        if (head.next == null) return popAndReturn()

        // you've removed a node, update the size of the list accordingly
        size--

        // search for the next node until current.next is null. This signifies that
        // current is the last node of the list [ e.g. 1->2->3->4->5->6]
        var previousNode = head    // prev = 1
        var currentNode = head    // curr = 1

        var nextNode = currentNode.next    // next = 2
        while (nextNode != null) { // next = 2-3-4-5-6
            previousNode = currentNode    // prev = 1-2-3-4-5
            currentNode = nextNode    // curr = 2-3-4-5-6
            nextNode = currentNode.next // next = 3-4-5-6-null
        }

        // since current is last node, disconnect it using the prev.next reference
        // update the tail reference
        previousNode.next = null
        tail = previousNode  // tail = prev = 5
        return currentNode.value  // curr = 6
    }

    fun removeLast() {
        val head = if (head != null) head else null

        if (head?.next == null)
            pop()

        // you've removed a node, update the size of the list accordingly
        size--

        var previousNode = head
        var currentNode = head

        var nextNode = currentNode?.next
        while (nextNode != null) {
            previousNode = currentNode
            currentNode = nextNode
            nextNode = currentNode.next
        }

        // since currentNode is last node, disconnect it using the previousNode.next
        // reference. Update the tailNode reference
        previousNode?.next = null
        tail = previousNode
    }

    /**
     * - Removes a value anywhere in the list. This operation involves removing a
     * node at a particular point in the list. This is achieved much like insert().
     * You'll first find the node immediately before the node you wish to remove
     * and then unlink it.
     * - O(1) time complexity.
     */
    fun removeAfterAndReturn(node: MyNode<T>): T? {
        val result = node.next?.value
        if (node.next == tail) tail = node

        if (node.next != null) size--
        node.next = node.next?.next

        return result
    }

    fun removeAfter(node: MyNode<T>) {
        if (node.next == tail) tail = node
        if (node.next != null) size--
        node.next = node.next?.next
    }

}
