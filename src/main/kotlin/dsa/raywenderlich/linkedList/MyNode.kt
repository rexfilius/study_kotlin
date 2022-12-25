package raywenderlich.linkedList

/**
 * - A linked list is a chain of nodes. Nodes have two responsibilities:
 * (1) Hold a value.
 * (2) Hold a reference to the next node. The absence of a reference to the next node,
 * null, marks the end of the list.
 */
data class MyNode<T>(
    var value: T,
    var next: MyNode<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

data class MyDoubleNode<T>(
    var value: T,
    var next: MyDoubleNode<T>? = null,
    var previous: MyDoubleNode<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}
