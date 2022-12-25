package raywenderlich.heap

import java.util.Collections
import kotlin.collections.ArrayList

abstract class MyHeap<Element> : MyHeapInterface<Element> {

    var elements: ArrayList<Element> = ArrayList()

    override val count: Int
        get() = elements.size

    /**
     * This method returns a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the second.
     */
    abstract fun compare(a: Element, b: Element): Int

    override fun peek(): Element? = elements.first()

    private fun leftChildIndex(index: Int) = (2 * index) + 1

    private fun rightChildIndex(index: Int) = (2 * index) + 2

    private fun parentIndex(index: Int) = (index - 1) / 2

    /**
     * The overall complexity of insert() is O(log n). Appending an element in an
     * array takes only O(1), while sifting up elements in a heap takes O(log n).
     */
    override fun insert(element: Element) {
        elements.add(element)
        siftUp(index = count - 1)
    }

    /**
     * [siftUp] swaps the current node with its parent, as long as that node has a
     * higher priority than its parent
     */
    private fun siftUp(index: Int) {
        val child: Int = index
        var parent = parentIndex(child)

        while (child > 0 && compare(elements[child], elements[parent]) > 0) {
            Collections.swap(elements, child, parent)
            parent = parentIndex(child)
        }
    }

    /**
     * The overall complexity of remove() is O(log n). Swapping elements in an array
     * takes only O(1), while sifting down elements in a heap takes O(log n) time.
     */
    override fun remove(): Element? {
        // if the heap is empty, return null.
        if (isEmpty) return null

        // Swap the root with the last element in the heap.
        Collections.swap(elements, 0, count - 1)
        // Remove the last element (the maximum or minimum value) and return it.
        val item = elements.removeAt(count - 1)
        // The heap may not be a maxheap or minheap anymore, so you must perform
        // a sift down to make sure it conforms to the rules.
        siftDown(index = 0)
        return item
    }

    /**
     * Removing an arbitrary element from a heap is an O(log n) operation.
     */
    override fun removeAt(index: Int): Element? {
        // Check to see if the index is within the bounds of the array.
        // If not, return null.
        if (index >= count) return null

        return if (index == count - 1) {
            // If you're removing the last element in the heap, you don't need to
            // do anything special. Simply remove and return the element.
            elements.removeAt(count - 1)
        } else {
            // If you're not removing the last element, first swap the element
            // with the last element.
            Collections.swap(elements, index, count - 1)
            // Then, return and remove the last element.
            val item = elements.removeAt(count - 1)
            // Finally, perform both a sift down and a sift up to adjust the heap.
            siftDown(index)
            siftUp(index)
            item
        }
    }

    private fun siftDown(index: Int) {
        // Store the parent index.
        var parent: Int = index

        // Continue sifting until you return.
        while (true) {
            // Get the parent’s left and right child index.
            val left = leftChildIndex(parent)
            val right = rightChildIndex(parent)

            // candidate is used to keep track of which index
            // to swap with the parent.
            var candidate = parent

            // If there's a left child, and it has a higher priority
            // than its parent, make it the candidate
            if (left < count && compare(elements[left], elements[candidate]) > 0)
                candidate = left

            // If there's a right child, and it has an even greater priority,
            // it will become the candidate instead.
            if (right < count && compare(elements[right], elements[candidate]) > 0)
                candidate = right

            // If candidate is still parent, you have reached the end,
            // and no more sifting is required.
            if (candidate == parent) return

            // Swap candidate with parent and set it as the new parent
            // to continue sifting.
            Collections.swap(elements, parent, candidate)
            parent = candidate
        }
    }

    /**
     * - To find the index of the element that you want to delete, you must perform
     * a search on the heap. Unfortunately, heaps are not designed for fast searches.
     * - With a binary search tree, you can perform a search in O(log n) time, but
     * since heaps are built using an array, and the node ordering in an array is
     * different, you can't even perform a binary search.
     * - Complexity: To search for an element in a heap is, in the worst-case,
     * an O(n) operation, since you may have to check every element in the array.
     */
    private fun index(element: Element, i: Int): Int? {
        // If the index is greater than or equal to the number of elements in
        // the array, the search failed. Return null.
        if (i >= count) return null

        // Check to see if the element that you're looking for has higher priority
        // than the current element at index i. If it does, the element you're
        // looking for cannot possibly be lower in the heap.
        if (compare(element, elements[i]) > 0) return null

        // If the element is equal to the element at index i, return i.
        if (element == elements[i]) return i

        // Recursively search for the element starting from the left child of i.
        val leftChildIndex = index(element, leftChildIndex(i))
        if (leftChildIndex != null) return leftChildIndex

        // Recursively search for the element starting from the right child of i.
        val rightChildIndex = index(element, rightChildIndex(i))
        if (rightChildIndex != null) return rightChildIndex

        // If both searches failed, the search failed. Return null
        return null
    }

    /**
     * - Making an existing array following the heap properties is an operation
     * usually called heapify.
     * - If a non-empty array is provided, you use this as the elements for the
     * heap. To satisfy the heap's property, you loop through the array backward,
     * starting from the first non-leaf node, and sift down all parent nodes.
     * - You loop through only half of the elements because there's no point in
     * sifting down leaf nodes, only parent nodes.
     */
    protected fun heapify(values: ArrayList<Element>) {
        elements = values
        if (elements.isNotEmpty()) {
            (count / 2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }

    /** ADDITIONAL NON-BASIC FUNCTIONS AFTER THIS LINE */

    /**
     * - Write a function to find the nth smallest integer in an unsorted array
     * - Given an arrayList of (3, 10, 18, 5, 21, 100). If n = 3, result = 10
     */
    fun getNthSmallestElement(n: Element): Element? {
        // current tracks the nth smallest element.
        var current = 1

        // As long as the heap is not empty, continue to remove elements.
        while (!isEmpty) {
            // Remove the root element from the heap.
            val element = remove()
            // Check to see if you reached the nth smallest element.
            // If so, return the element
            if (current == n) return element
            // If not, increment current.
            current += 1
        }
        // Return null if the heap is empty
        return null
    }

    /**
     * - Write a method that combines two heaps.
     * - To merge two heaps, you first combine both arrays which takes O(m), where m
     * is the length of the heap you are merging.
     * Building the heap takes O(n). Overall the algorithm runs in O(n).
     */
    fun merge(heap: MyHeap<Element>) {
        elements.addAll(heap.elements)
        buildHeap()
    }

    private fun buildHeap() {
        if (elements.isNotEmpty()) {
            (count / 2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }

    /**
     * - Write a function to check if a given array is a minheap.
     * - The time complexity of this solution is O(n). This is because you still
     * have to go through every element in the array.
     */
    fun isMinHeap(): Boolean {
        // If the array is empty, it’s a minheap.
        if (isEmpty) return true

        // Go through all the parent nodes in the array in reverse order.
        (count / 2 - 1 downTo 0).forEach {
            // Get the left and right child index.
            val left = leftChildIndex(it)
            val right = rightChildIndex(it)

            // Check to see if the left element is less than the parent.
            if (left < count && compare(elements[left], elements[it]) < 0)
                return false
            // Check to see if the right element is less than the parent.
            if (right < count && compare(elements[right], elements[it]) < 0)
                return false
        }

        // If every parent-child relationship satisfies the minheap property,
        // return true.
        return true
    }

}