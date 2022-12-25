package raywenderlich.arrays.sort.nSquaredSorts

import raywenderlich.util.example

fun main() {
    "bubble sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.myBubbleSort(true)
        println("Bubble sorted: $list")
    }

    "selection sort" example {
        val bList = arrayListOf(9, 4, 10, 3)
        println("Original: $bList")
        bList.mySelectionSort(true)
        println("Selection sorted: $bList")
    }

    "insertion sort" example {
        val cList = arrayListOf(9, 4, 10, 3)
        println("Original: $cList")
        cList.myInsertionSort(true)
        println("Insertion sorted: $cList")
    }

}