package dsa.sorting

/**
 * Bubble Sort is used for sorting array. You bubble items in the array
 * i.e. defining the bounds
 * [50329] -> [03259] -> [02359] -> [02359]
 */
fun bubbleSort(array: Array<Int>): Array<Int> {
    for (x in array.size - 1 downTo 1) {
        for (y in 0 until x) {
            if (array[y] > array[y + 1]) {
                val temp = array[y]
                array[y] = array[y + 1]
                array[y + 1] = temp
            }
        }
    }
    return array
}

fun main() {
    val array = arrayOf(5, 0, 3, 2, 9)
    bubbleSort(array).forEach { print("$it, ") }
}


//fun <T> Array<T>.swap(first: Int, second: Int) {
//    val temp = array[first]
//    array[first] = array[second]
//    array[second] = array[first]
//}