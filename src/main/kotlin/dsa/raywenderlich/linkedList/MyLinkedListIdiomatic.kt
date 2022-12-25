package raywenderlich.linkedList

class MyLinkedListIdiomatic<T>
    : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {

    private var head: MyNode<T>? = null
    private var tail: MyNode<T>? = null

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    fun push(value: T) {
        head = MyNode(value = value, next = head)
        if (tail == null) tail = head
        size++
    }

    fun pushFluently(value: T): MyLinkedListIdiomatic<T> {
        head = MyNode(value = value, next = head)
        if (tail == null) tail = head
        size++
        return this
    }

    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = MyNode(value = value)
        tail = tail?.next
        size++
    }

    fun appendFluently(value: T): MyLinkedListIdiomatic<T> {
        if (isEmpty()) {
            pushFluently(value)
            return this
        }
        tail?.next = MyNode(value = value)
        tail = tail?.next
        size++
        return this
    }

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

    fun nodeAt(index: Int): MyNode<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next

        if (isEmpty()) tail = null
        return result
    }

    fun popWithNoReturn() {
        if (!isEmpty()) size--
        head = head?.next
        if (isEmpty()) tail = null
    }

    fun removeLast(): T? {
        // if raywenderlich.util.head is null, nothing to remove, return null
        val head = head ?: return null
        // if list consists of one node, removeLastNode()
        // is functionally equivalent to pop()
        if (head.next == null) return pop()

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

    fun removeLastWithNoReturn() {
        val head = if (head != null) head else null

        if (head?.next == null)
            popWithNoReturn()

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

    fun removeAfter(node: MyNode<T>): T? {
        val result = node.next?.value
        if (node.next == tail) tail = node

        if (node.next != null) size--
        node.next = node.next?.next

        return result
    }

    fun removeAfterWithNoReturn(node: MyNode<T>) {
        if (node.next == tail) tail = node
        if (node.next != null) size--
        node.next = node.next?.next
    }

    // from the Iterable<T> & MutableIterator<T> interface
    override fun iterator(): MutableIterator<T> {
        return MyLinkedListIterator(this)
    }

    // from Collection interface
    override fun isEmpty(): Boolean = size == 0

    // from Collection interface
    override var size = 0
        private set

    // from Collection Interface.
    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false    // contains() has a O(n) complexity
    }

    // from Collection interface
    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched)) return false
        }
        return true    // containsAll() has a O(n^2) complexity. inefficient!!
    }

    // from MutableCollection interface
    override fun add(element: T): Boolean {
        appendFluently(element)
        return true
    }

    // from MutableCollection interface
    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) appendFluently(element)
        return true
    }

    // from MutableCollection interface
    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    // from MutableCollection interface
    override fun remove(element: T): Boolean {
        // get an iterator to help iterate through the collection
        val iterator = iterator()

        // create a loop to check if there are any elements left,
        // and get the next one
        while (iterator.hasNext()) {
            val item = iterator.next()

            // if current element is the one, remove it
            if (item == element) {
                iterator.remove()
                return true
            }
        }
        // return boolean that signals if an element has been removed
        return false
    }

    // from MutableCollection interface
    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        return result    // return value is true if any elements were removed
    }

    /**
     * From MutableCollection interface. Removes any elements
     * in the list besides the ones passed in as the parameter
     */
    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()

        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }

        return result
    }

}