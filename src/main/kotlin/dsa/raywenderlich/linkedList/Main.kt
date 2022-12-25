package raywenderlich.linkedList

import raywenderlich.util.example

fun main() {

    "Nodes: creating and linking" example {
        val node1 = MyNode(1)
        val node2 = MyNode(2)
        val node3 = MyNode(3)

        node1.next = node2
        node2.next = node3
        println(node1)
    }

    "LinkedList: push" example {
        val aList = MyLinkedList<Int>()
        aList.push(3)
        aList.push(2)
        aList.push(1)
        println(aList)
    }

    "LinkedList: push - fluent interface" example {
        val bList = MyLinkedList<Int>()
        bList.pushAndReturn(3).pushAndReturn(2).pushAndReturn(1)
        println(bList)
    }

    "LinkedList: append" example {
        val cList = MyLinkedList<Int>()
        cList.appendAndReturn(1).appendAndReturn(2).appendAndReturn(3)
        println(cList)
    }

    "LinkedList: inserting at a particular index" example {
        val dList = MyLinkedList<Int>()
        dList.pushAndReturn(3).pushAndReturn(2).pushAndReturn(1)
        println("Before inserting: $dList")

        var middleNode = dList.nodeAt(index = 1)!!
        for (i in 1..3)
            middleNode = dList.insert(value = -1 * i, afterNode = middleNode)
        println("After inserting: $dList")
    }

    "LinkedList: pop" example {
        val eList = MyLinkedList<Int>()
        eList.pushAndReturn(3).pushAndReturn(2).pushAndReturn(1)
        println("Before popping list: $eList")

        val poppedValue = eList.popAndReturn()
        println("After popping list: $eList")
        println("Popped value: $poppedValue")
    }

    "LinkedList: removeLast" example {
        val fList = MyLinkedList<Int>()
        fList.pushAndReturn(3).pushAndReturn(2).pushAndReturn(1)
        println("Before removing last node $fList")

        val removedValue = fList.removeLastAndReturn()
        println("After removing last node: $fList")
        println("Removed value: $removedValue")
    }

    "LinkedList: removeAfter" example {
        val gList = MyLinkedList<Int>()
        gList.pushAndReturn(5).pushAndReturn(4).pushAndReturn(3)
            .pushAndReturn(2).pushAndReturn(1)
        println("Before removing at particular index: $gList")

        val node = gList.nodeAt(index = 1)!!
        val removedNode = gList.removeAfterAndReturn(node)
        println("After removing : $gList")
        println("Removed value: $removedNode")
    }

}