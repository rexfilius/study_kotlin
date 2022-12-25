package raywenderlich.trees.binaryTrees

import raywenderlich.util.example

fun main() {
    val exampleTree = BST<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }

    "Building a BST" example {
        println(exampleTree)
    }

    "Finding a node" example {
        if (exampleTree.contains(5)) println("Found 5")
        else println("Couldn't find 5")
    }

    "Removing a node" example {
        println("Tree before removal:")
        println(exampleTree)
        exampleTree.remove(3)
        println("Tree after removing root:")
        println(exampleTree)
    }
}