package documentation.dataStructures

fun main() {

    /**
     * CHUNKED
     * To break a collection onto parts of a given size, use the chunked() function.
     * chunked() takes a single argument – the size of the chunk – and returns a List of
     * Lists of the given size. The first chunk starts from the first element and contains
     * the size elements, the second chunk holds the next size elements, and so on.
     * The last chunk may have a smaller size
     */
    val num = (0..13).toList()
    println("num: $num")
    println("chunked(3): ${num.chunked(3)}")

    /**
     * You can also apply a transformation for the returned chunks right away. To do this,
     * provide the transformation as a lambda function when calling chunked(). The lambda
     * argument is a chunk of the collection. When chunked() is called with a
     * transformation, the chunks are short-living Lists that should be consumed
     * right in that lambda
     */
    println("chunkedLambda: ${num.chunked(3) { it.sum() }}")
    println()

    /**
     * WINDOWED
     * You can retrieve all possible ranges of the collection elements of a given size.
     * The function for getting them is called windowed(): it returns a list of element
     * ranges that you would see if you were looking at the collection through a sliding
     * window of the given size. Unlike chunked(), windowed() returns element ranges
     * (windows) starting from each collection element. All the windows are returned as
     * elements of a single List
     */
    val words = listOf("one", "two", "three", "four", "five")
    println("words: $words")
    println("windowed(3): ${words.windowed(3)}")
    println()

    val code = (1..10).toList()
    println("code: $code")
    println(code.windowed(3, step = 2, partialWindows = true))
    println(code.windowed(3))
    println(code.windowed(3) { it.sum() })
    println()

    val pint = listOf("one", "two", "three", "four", "five")
    println("pint: $pint")
    println("zipWithNext: ${pint.zipWithNext()}")
    println("zipWithNextLambda: ${pint.zipWithNext { s1, s2 -> s1.length > s2.length }}")

}
