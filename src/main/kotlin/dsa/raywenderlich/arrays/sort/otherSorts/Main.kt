package raywenderlich.arrays.sort.otherSorts

import raywenderlich.util.example

fun main() {
    "merge sort" example {
        val list = listOf(7, 2, 6, 3, 9)
        println("Original: $list")
        val result = list.myMergeSort()
        println("Merge sorted: $result")
    }

    "merge iterables" example {
        val list1 = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val list2 = listOf(1, 3, 4, 5, 5, 6, 7, 7)
        println("List 1: $list1")
        println("List 2: $list2")

        val result = mergeIterables(list1, list2)
        println("Merge sorted: $result")
    }

    "Radix sort" example {
        val list = arrayListOf(88, 410, 1772, 20)
        println("Original: $list")
        list.myRadixSort()
        println("Radix sorted: $list")
    }

    "Lexicographical sort - MSD radix sort" example {
        val list = (0..10).map {
            (Math.random() * 10000).toInt()
        }.toMutableList()
        println("Original: $list")
        list.lexicographicalSort()
        println("Radix sorted: $list")
    }

}