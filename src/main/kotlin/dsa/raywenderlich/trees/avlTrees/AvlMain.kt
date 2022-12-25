package raywenderlich.trees.avlTrees

import raywenderlich.util.example

fun main() {
    "repeated insertions in sequence" example {
        val tree = AVLTree<Int>()
        (0..14).forEach {
            tree.insert(it)
        }
        print(tree)
    }

    "removing a value" example {
        val bTree = AVLTree<Int>()
        bTree.insert(15)
        bTree.insert(10)
        bTree.insert(16)
        bTree.insert(18)
        print(bTree)
        bTree.remove(10)
        print(bTree)
    }

//    "using TraversableBinaryNode" raywenderlich.util.example {
//        val tree = MyAVLTree<Int>()
//        (0..14).forEach {
//            tree.insert(it)
//        }
//        println(tree)
//        tree.root?.traverseInOrder { println(it) }
//    }
}