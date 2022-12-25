package raywenderlich.arrays.search

import raywenderlich.util.example

fun main() {
    "binary search" example {
        val array = arrayListOf(1, 5, 15, 17, 19, 22, 24, 31, 105, 150)

        val search31 = array.indexOf(31)
        val binarySearch31 = array.binarySearchExt(31)

        println("indexOf(): $search31")
        println("binarySearch(): $binarySearch31")
    }

    "finding range of indices for an element" example {
        val bArray = arrayListOf(1, 2, 3, 3, 3, 4, 5, 5)
        val indices = bArray.findIndicesExt(3)
        println(bArray)
        println("range of 3: $indices")
    }

    "finding range of indices for an element" example {
        val bArray = arrayListOf(1, 2, 3, 3, 3, 4, 5, 5)
        val indices = bArray.findIndicesExt2(3)
        println(bArray)
        println("range of 3: $indices")
    }
}