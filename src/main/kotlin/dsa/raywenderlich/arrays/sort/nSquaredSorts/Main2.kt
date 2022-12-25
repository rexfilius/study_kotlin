package raywenderlich.arrays.sort.nSquaredSorts

import raywenderlich.util.example

fun main() {
    "right-align" example {
        val aList = arrayListOf(9, 4, 10, 3, 7, 9, 2)
        println("Original: $aList")
        aList.rightAlign(10)
        println(aList)
    }

    "biggest duplicate" example {
        val bList = arrayListOf(9, 4, 4, 4, 10, 3, 11, 11, 11, 7, 9, 2)
        println("Original: $bList")
        println("Biggest duplicate: ${bList.biggestDuplicate()}")
    }

    "reverse a list manually" example {
        val cList = arrayListOf(9, 4, 10, 3, 7, 9, 2)
        println("Original: $cList")
        cList.reverseList()
        println("Reversed: $cList")
    }
}