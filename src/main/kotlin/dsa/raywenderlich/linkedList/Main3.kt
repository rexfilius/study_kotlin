package raywenderlich.linkedList

import raywenderlich.util.example

fun main() {

    "LinkedList: print in reverse" example {
        val aList = MyLinkedListIdiomatic<Int>()
        aList.add(3)
        aList.add(2)
        aList.add(1)
        aList.add(4)
        aList.add(5)

        println("LinkedList: $aList")
        aList.printListInReverse()
        println()
    }

    "LinkedList: print middle node" example {
        val bList = MyLinkedListIdiomatic<Int>()
        bList.add(3)
        bList.add(2)
        bList.add(1)
        bList.add(4)
        bList.add(5)

        println("LinkedList: $bList")
        println("Middle node: ${bList.getMiddleNode()?.value}")
    }

    "LinkedList: reverse list" example {
        val cList = MyLinkedListIdiomatic<Int>()
        cList.add(3)
        cList.add(2)
        cList.add(1)
        cList.add(4)
        cList.add(5)

        println("Original: $cList")
        println("Reversed: ${cList.reversed()}")
    }

    "LinkedList: merge lists" example {
        val dList = MyLinkedListIdiomatic<Int>()
        dList.add(1)
        dList.add(2)
        dList.add(3)
        dList.add(4)
        dList.add(5)

        val other = MyLinkedListIdiomatic<Int>()
        other.add(-1)
        other.add(0)
        other.add(2)
        other.add(2)
        other.add(7)

        println("Left: $dList")
        println("Right: $other")
        println("Merged: ${dList.mergeSorted(other)}")
    }

}