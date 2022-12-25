package raywenderlich.trees.binaryTrees

fun main() {
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val rootNode = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    rootNode.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    rootNode.rightChild = nine
    nine.leftChild = eight

    println(rootNode)
    println("Height: ${rootNode.heightExt()}")

    println(rootNode)
    val bList = rootNode.serializeExt()
    println(bList)
    println(bList.deserializeOptimizedExt())
}