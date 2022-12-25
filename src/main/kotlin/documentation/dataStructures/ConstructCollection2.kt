package dataStructures

fun main() {

    /**
     * To create a collection with the same elements as an existing collection, you can use
     * copying operations. Collection copying operations from the standard library create
     * shallow copy collections with references to the same elements. Thus, a change made
     * to a collection element reflects in all its copies.
     * ...
     * Collection copying functions, such as toList(), toMutableList(), toSet() etc. create
     * a snapshot of a collection at a specific moment. Their result is a new collection of
     * the same elements. If you add or remove elements from the original collection, this
     * won't affect the copies. Copies may be changed independently of the source as well.
     */
    val sourceList = mutableListOf(1, 2, 3)
    val copyList = sourceList.toMutableList()
    val readOnlyCopyList = sourceList.toList()

    sourceList.add(4)
    println("copyList size: ${copyList.size}")

    //readOnlyCopyList.add(4) // compilation error
    println("readOnlyCopyList size: ${readOnlyCopyList.size}")
    println("sourceList size: ${sourceList.size}")

    // Collection copying functions can be used for converting collections to other types
    // e.g. build a et from a list or vice versa
    val copySet = sourceList.toMutableSet()
    copySet.add(3)
    copySet.add(4)
    println("copySet: (sourceList to Set): $copySet")
    println()

    /**
     * Alternatively, you can create new references to the same collection instance. New
     * references are created when you initialize a collection variable with an existing
     * collection. So, when the collection instance is altered through a reference, the
     * changes are reflected in all its references
     */
    val aList = mutableListOf(1, 2, 3)
    val refList = aList
    refList.add(4)
    println("aList size: ${aList.size}")
    println("refList size: ${refList.size}")
    println()

    /**
     * Collection initialization can be used for restricting mutability. e.g if you create
     * a List reference to a MutableList, the compiler will produce errors if you try to
     * modify the collection through this reference
     */
    val someList = mutableListOf(1,2,3)
    val anotherList: List<Int> = someList

    //anotherList.add(4) // compilation error
    someList.add(4)
    println("anotherList: $anotherList")
    println("someList: $someList")


}