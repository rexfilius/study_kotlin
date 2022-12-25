package raywenderlich.linkedList

class MyLinkedListIterator<T>(
    private val list: MyLinkedListIdiomatic<T>
) : Iterator<T>, MutableIterator<T> {

    private var index = 0
    private var lastNode: MyNode<T>? = null

    /**
     * From the Iterator interface. This method indicates whether the Iterable
     * still has values to read.*/
    override fun hasNext(): Boolean {
        return index < list.size
    }

    // from the Iterator interface
    override fun next(): T {
        // if there are no elements to return, throw exception
        if (index >= list.size) throw IndexOutOfBoundsException()

        // If this is first iteration, no lastNode set, take the first node of the
        // list. After the first iteration, get next property of last node
        // to find the next one.
        lastNode = if (index == 0) {
            list.nodeAt(index = 0)
        } else {
            lastNode?.next
        }

        // lastNode is updated, update the index too
        index++
        return lastNode!!.value
    }

    // from the MutableIterator interface
    override fun remove() {
        // at the beginning of the list, use pop()
        if (index == 1) {
            list.pop()
        } else {
            // if iterator is somewhere in the list, find the previous node
            val prevNode = list.nodeAt(index - 2) ?: return

            //re-assign lastNode and decrease index
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
        index--
    }

}