package documentation.dataStructures

fun main() {

    /**
     * For more specific cases, there are the functions reduce() and fold() that apply the
     * provided operation to the collection elements sequentially and return the
     * accumulated result. The operation takes two arguments: the previously accumulated
     * value and the collection element.
     * The difference between the two functions is that fold() takes an initial value and
     * uses it as the accumulated value on the first step, whereas the first step of
     * reduce() uses the first and the second elements as operation arguments on the
     * first step
     */
    val numbers = listOf(5, 2, 10, 4)

    val sum = numbers.reduce { sum, element -> sum + element }
    println(sum)
    val sumDoubled = numbers.fold(0) { som, element -> som + element * 2 }
    println(sumDoubled)
    println()

    //val sumDoubledReduce = numbers.reduce { sum, element -> sum + element * 2 }
    // incorrect: the first element isn't doubled in the result
    //println(sumDoubledReduce)

    /**
     * To apply a function to elements in the reverse order, use functions reduceRight()
     * and foldRight(). They work in a way similar to fold() and reduce() but start from
     * the last element and then continue to previous. Note that when folding or reducing
     * right, the operation arguments change their order: first goes the element,
     * and then the accumulated value.
     */
    val num = listOf(5, 2, 10, 4)
    val sumDoubledRight = num.foldRight(0) { element, sm -> sm + element * 2 }
    println(sumDoubledRight)
    println()

    /**
     * You can also apply operations that take element indices as parameters. For this
     * purpose, use functions reduceIndexed() and foldIndexed() passing element index as
     * the first argument of the operation.
     * Finally, there are functions that apply such operations to collection elements from
     * right to left - reduceRightIndexed() and foldRightIndexed().
     * ...
     * All reduce operations throw an exception on empty collections. To receive null
     * instead, use their *OrNull() counterparts: reduceOrNull(), reduceRightOrNull(),
     * reduceIndexedOrNull(), reduceRightIndexedOrNull()
     */
    val code = listOf(5, 2, 10, 4)
    val sumEven = code.foldIndexed(0) { i, s, e ->
        if (i % 2 == 0) s + e else s
    }
    println(sumEven)

    val sumEvenRight = numbers.foldRightIndexed(0) { idx, element, s ->
        if (idx % 2 == 0) s + element else s
    }
    println(sumEvenRight)
    println()

    /**
     * For cases where you want to save intermediate accumulator values, there are
     * functions runningFold() (or its synonym scan()) and runningReduce().
     * If you need an index in the operation parameter, use runningFoldIndexed()
     * or runningReduceIndexed()
     */
    val n = listOf(0, 1, 2, 3, 4, 5)
    val runningReduceSum = n.runningReduce { sum, item -> sum + item }
    val runningFoldSum = n.runningFold(10) { sum, item -> sum + item }
}