package raywenderlich.trees.basics

fun main() {
    //depthFirstTraversal()
    //levelOrderTraversal()
    //searchTree()
    printTreeByLevel()
}

fun depthFirstTraversal() {
    val tree = makeBeverageTree()
    tree.forEachDepthFirst {
        println(it.value)
    }
}

fun levelOrderTraversal() {
    val tree = makeBeverageTree()
    tree.forEachLevelOrder {
        println(it.value)
    }
}

fun searchTree() {
    val tree = makeBeverageTree()
    tree.search("ginger-ale")?.let {
        println("Found node: ${it.value}")
    }
    tree.search("WKD Blue")?.let {
        println(it.value)
    } ?: println("Couldn't find WKD Blue")
}

fun printTreeByLevel() {
    val tree = makeBeverageTree()
    tree.printEachLevel()
}

fun makeBeverageTree(): MyTreeNode<String> {
    val tree = MyTreeNode("Beverages")

    val hot = MyTreeNode("hot")
    val cold = MyTreeNode("cold")

    val tea = MyTreeNode("tea")
    val coffee = MyTreeNode("coffee")
    val chocolate = MyTreeNode("cocoa")

    val blackTea = MyTreeNode("black")
    val greenTea = MyTreeNode("green")
    val chaiTea = MyTreeNode("chai")

    val soda = MyTreeNode("soda")
    val milk = MyTreeNode("milk")

    val gingerAle = MyTreeNode("ginger-ale")
    val bitterLemon = MyTreeNode("bitter-lemon")

    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}