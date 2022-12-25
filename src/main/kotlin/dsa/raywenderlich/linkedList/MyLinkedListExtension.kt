package raywenderlich.linkedList

/**
 * - Reverse a LinkedList.
 * - O(n) time complexity, since you have to traverse each node of the list
 * - A better way to using recursion is using Stack [stack.printReverse]
 */
fun <T> MyLinkedListIdiomatic<T>.printListInReverse() {
    this.nodeAt(0)?.printListInReverse()
}

fun <T> MyNode<T>.printListInReverse() {
    this.next?.printListInReverse()

    // check if you've reached the end of the list. the arrow starts with the second
    // element of the reverse output - for pretty formatting
    if (this.next != null) {
        print(" -> ")
    }

    // as the recursive statements unravel, the node data gets printed
    print(this.value.toString())
}

/**
 * - In the while declaration, you bind the next node to fast. If there's a next node,
 * you update fast to the next node of fast, effectively traversing down the list
 * twice. slow is updated only once. This is also known as the RUNNER TECHNIQUE.
 * - O(n) time complexity since the list is traversed in a single pass.
 */
fun <T> MyLinkedListIdiomatic<T>.getMiddleNode(): MyNode<T>? {
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)

    // e.g 1 -> 2 -> 3 -> 4 -> 5 ... slow=1 fast=1
    while (fast != null) {
        fast = fast.next    // fast = 2 - 4 - null
        if (fast != null) {
            fast = fast.next  // fast = 3 - 5
            slow = slow?.next // slow = 2 - 3
        }
    }
    return slow    // slow = 3
}

/**
 * - To reverse a list is to manipulate the nodes so that the nodes of the list
 * are linked in the opposite direction.
 * - this function has O(n) time complexity, the only drawback is that you need
 * a list, which means the space complexity is also O(n). There's a helper function
 * for the drawback in [reversed]
 */
fun <T> addInReverse(list: MyLinkedListIdiomatic<T>, node: MyNode<T>) {
    // get the next node of the list, starting from the one received as a parameter
    val next = node.next

    // if there's a following node, recursively call the same function,
    // now the starting node is the one after the current node
    if (next != null) addInReverse(list, next)

    // when you reach the end, start adding the nodes in the reverse order
    list.appendFluently(node.value)
}

/**
 * - This extension creates a new LinkedList and fills it with nodes by calling
 * [addInReverse], passing in the first node of the current list
 */
fun <T> MyLinkedListIdiomatic<T>.reversed(): MyLinkedListIdiomatic<T> {
    val result = MyLinkedListIdiomatic<T>()
    val head = this.nodeAt(0)

    if (head != null) addInReverse(result, head)
    return result
}

/**
 * - Function that takes two sorted linked lists and merges them into a single
 * sorted linked list
 * - This algorithm has a time complexity of O(m+n), where m is the number of nodes
 * in the first list, and n is the number of nodes in the second list
 */
fun <T : Comparable<T>> MyLinkedListIdiomatic<T>.mergeSorted(
    otherList: MyLinkedListIdiomatic<T>
): MyLinkedListIdiomatic<T> {

    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this

    val result = MyLinkedListIdiomatic<T>()
    // start with the first node of each list
    var left = nodeAt(0)
    var right = otherList.nodeAt(0)

    // loop continues until one of the lists reaches its end
    while (left != null && right != null) {

        // compare the first nodes left and right to append to the result
        if (left.value < right.value) left = append(result, left)
        else right = append(result, right)
    }

    while (left != null) left = append(result, left)
    while (right != null) right = append(result, right)

    return result
}

/**
 * helper function that adds the current node to the result list and returns the next node
 */
fun <T : Comparable<T>> append(
    result: MyLinkedListIdiomatic<T>,
    node: MyNode<T>
): MyNode<T>? {
    result.appendFluently(node.value)
    return node.next
}