package raywenderlich.heap

/**
 * - A heap is a complete binary tree data structure also known as a binary heap
 * that you can construct using an array. Don't confuse these heaps with memory heaps.
 * The term heap is sometimes confusingly used in computer science to refer to a pool
 * of memory. Memory heaps are a different concept
 * - Heaps come in two flavors:
 * (1) Maxheap, in which elements with a higher value have a higher priority.
 * (2) Minheap, in which elements with a lower value have a higher priority.
 * - Note: It's important to say that the concept of heap is valid for every type of
 * object that can be compared to others of the same type. e.g. types which implement
 * Comparable or Comparator interface.
 * - A heap has an important characteristic that must always be satisfied. This is
 * known as the HEAP INVARIANT or HEAP PROPERTY.
 * - In a MAXHEAP, parent nodes must always contain a value that is greater than or
 * equal to the value in its children. The root node will always contain the highest value.
 * - In a MINHEAP, parent nodes must always contain a value that is less than or equal
 * to the value in its children. The root node will always contain the lowest value.
 * - Another important property of a heap is that it's a complete binary tree. This
 * means that every level must be filled, except for the last level.
 * - Some useful applications of a heap include:
 * (1) Calculating the minimum or maximum element of a collection.
 * (2) Heap sort. (3) Implementing a priority queue.
 * (4) Supporting graph algorithms, like Prim's or Dijkstra's, with a priority queue.
 * - The heap properties imply there must be a way to compare each element and so a
 * way to test if an element A is greater, smaller or equals than the element B.
 * In Kotlin, as well as in Java, this can be achieved in 2 different ways:
 * (1) Element implements the Comparable<Element> interface
 * (2) You can provide a Comparator<Element> implementation
 * - Implementing the Comparable<Element> interface, a type Element can only provide
 * a single way of comparing instances of itself with others of the same type. If
 * you use a Comparator<Element> you can choose different way of sorting simply
 * using different Comparator implementations. In both cases you need to abstract
 * the way you compare different instances.
 */
class MyHeapComparable<Element : Comparable<Element>> : MyHeap<Element>() {

    override fun compare(a: Element, b: Element): Int =
        a.compareTo(b)

    companion object {
        fun <Element : Comparable<Element>> create(
            elements: ArrayList<Element>
        ): MyHeapInterface<Element> {
            val heap = MyHeapComparable<Element>()
            heap.heapify(elements)
            return heap
        }
    }
}

class MyHeapComparator<Element>(
    private val comparator: Comparator<Element>
) : MyHeap<Element>() {

    override fun compare(a: Element, b: Element): Int =
        comparator.compare(a, b)

    companion object {
        fun <Element> create(
            elements: ArrayList<Element>,
            comparator: Comparator<Element>
        ): MyHeapInterface<Element> {
            val heap = MyHeapComparator(comparator)
            heap.heapify(elements)
            return heap
        }
    }
}