package raywenderlich.arrays.sort.otherSorts

import raywenderlich.arrays.sort.otherSorts.quickSort.*
import raywenderlich.util.example

fun main() {

    "Quicksort - Naive" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        println("Sorted: ${list.quickSortNaive()}")
    }

    "Quicksort - Lomuto" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quickSortLomuto(0, list.lastIndex)
        println("Sorted: $list")
    }

    "Quicksort - Lomuto iterative" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quickSortLomutoIterative(0, list.lastIndex)
        println("Sorted: $list")
    }

    "Quicksort - Hoare" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quickSortHoare(0, list.lastIndex)
        println("Sorted: $list")
    }

    "QuickSort - Median of three" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quickSortMedian(0, list.lastIndex)
        println("Sorted: $list")
    }

    "Quicksort - Dutch Flag" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quickSortDutchFlag(0, list.lastIndex)
        println("Sorted: $list")
    }
}