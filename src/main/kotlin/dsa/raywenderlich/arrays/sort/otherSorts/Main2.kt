package raywenderlich.arrays.sort.otherSorts

import raywenderlich.util.example

fun main() {
    "Heap sort - ascending" example {
        val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
        array.myHeapSort(ascending)
        print(array.joinToString())
    }

    "Heap sort descending" example {
        val bArray = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
        bArray.myHeapSort(descending)
        print(bArray.joinToString())
    }
}

val ascending = Comparator { first: Int, second: Int ->
    when {
        first < second -> -1
        first > second -> 1
        else -> 0
    }

}

val descending = Comparator { first: Int, second: Int ->
    when {
        first < second -> 1
        first > second -> -1
        else -> 0
    }
}