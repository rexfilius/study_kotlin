package raywenderlich.linkedList

import raywenderlich.util.example

fun main() {

    "LinkedList as Iterable: printing doubles" example {
        val aList = MyLinkedListIdiomatic<Int>()
        aList.pushFluently(3).pushFluently(2).pushFluently(1)
        println(aList)

        for (item in aList) println("Double: ${item * 2}")
    }

    "LinkedList: removing elements" example {
        val bList: MutableCollection<Int> = MyLinkedListIdiomatic()
        bList.add(4)
        bList.add(3)
        bList.add(2)
        bList.add(1)

        println("LinkedList: $bList")
        bList.remove(element = 1)
        println("After removal: $bList")
    }

    "LinkedList: retaining elements" example {
        val cList: MutableCollection<Int> = MyLinkedListIdiomatic()
        cList.add(3)
        cList.add(2)
        cList.add(1)
        cList.add(4)
        cList.add(5)

        println("LinkedList: $cList")
        cList.retainAll(listOf(3, 4, 5))
        println("Retain (3,4,5): $cList")
    }

    "LinkedList: remove all elements" example {
        val dList: MutableCollection<Int> = MyLinkedListIdiomatic()
        dList.add(3)
        dList.add(2)
        dList.add(1)
        dList.add(4)
        dList.add(5)

        println("LinkedList: $dList")
        dList.removeAll(listOf(3, 4, 5))
        println("Remove (3,4,5): $dList")
    }
}