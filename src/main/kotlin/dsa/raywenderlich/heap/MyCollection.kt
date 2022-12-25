package raywenderlich.heap

interface MyCollection<Element> {

    val count: Int

    val isEmpty: Boolean
        get() = count == 0

    fun insert(element: Element)

    fun remove(): Element?

    fun removeAt(index: Int): Element?
}

interface MyHeapInterface<Element> : MyCollection<Element> {

    /**
     * The peek operation is a generalization of methods returning the min or the max
     * depending on the implementation. Because of this you can usually find the same
     * operation with name extract-min or extract-max.
     */
    fun peek(): Element?
}