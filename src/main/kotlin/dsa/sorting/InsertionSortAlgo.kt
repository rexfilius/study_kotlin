fun insertSort(array: Array<Int>): Array<Int> {
    for (index in array.indices) {
        val currentItem = array[index]  // [6, 1, 5, 4]
        var y = index

        while (y > 0 && array[y - 1] > currentItem) {
            array[y] = array[y - 1]  // [6, 6, 5, 4]
            y--
        }
        array[y] = currentItem  // [1, 6, 5, 4]
    }
    return array
}

fun main() {
    val array = arrayOf(6, 1, 5, 4)
    insertSort(array).forEach { print("$it, ") }
}