package raywenderlich.heap

fun <Element> MyHeap<Element>.getNthSmallestElementExt(
    n: Element
): Element? {
    var current = 1
    while(!isEmpty) {
        val element = remove()
        if (current == n) return element
        current += 1
    }
    return null
}