package documentation.dataStructures.sequences

/**
 * Along with collections, the Kotlin standard library contains another container type;
 * sequences (Sequence<T> ). Sequences offer the same functions as Iterable but implement
 * another approach to multi-step collection processing.
 * ...
 * When the processing of an Iterable includes multiple steps, they are executed eagerly:
 * each processing step completes and returns its result – an intermediate collection.
 * The following step executes on this collection. In turn, multi-step processing of
 * sequences is executed lazily when possible: actual computing happens only when
 * the result of the whole processing chain is requested.
 * ...
 * The order of operations execution is different as well: Sequence performs all the
 * processing steps one-by-one for every single element. In turn, Iterable completes each
 * step for the whole collection and then proceeds to the next step.
 * ...
 * So, the sequences let you avoid building results of intermediate steps, therefore
 * improving the performance of the whole collection processing chain. However, the lazy
 * nature of sequences adds some overhead which may be significant when processing smaller
 * collections or doing simpler computations. Hence, you should consider both
 * Sequence and Iterable and decide which one is better for your case
 */
fun main() {

    // To create a sequence, call the sequenceOf() function
    // listing the elements as its arguments
    val numbersSequence = sequenceOf("four", "three", "two", "one")

    // If you already have an Iterable object (List or Set), you can create a sequence
    // from it by calling asSequence()
    val names = listOf("Jon", "Jake", "Jane", "Judy", "Jack")
    val namesSequence = names.asSequence()

    /**
     * One more way to create a sequence is by building it with a function that calculates
     * its elements. To build a sequence based on a function, call generateSequence() with
     * this function as an argument. Optionally, you can specify the first element as an
     * explicit value or a result of a function call. The sequence generation stops when
     * the provided function returns null. So, the sequence in the example below is
     * infinite
     */
    val oddNumbers = generateSequence(1) { it + 2 }
    println(oddNumbers.take(5).toList())
    // println(oddNumbers.count()) // error: the sequence is infinite

    // To create a finite sequence with generateSequence(), provide a function
    // that returns null after the last element you need.
    val oddNumbersLessThan10 = generateSequence(1) { if (it < 8) it + 2 else null }
    println(oddNumbersLessThan10.count())
    println()

    /**
     * Finally, there is a function that lets you produce sequence elements one by one or
     * by chunks of arbitrary sizes: the sequence() function. This function takes a lambda
     * expression containing calls of yield() and yieldAll() functions. They return an
     * element to the sequence consumer and suspend the execution of sequence() until the
     * next element is requested by the consumer. yield() takes a single element as an
     * argument; yieldAll() can take an Iterable object, an Iterator, or another Sequence.
     * A Sequence argument of yieldAll() can be infinite. However, such a call must be the
     * last: all subsequent calls will never be executed
     */
    val oddNum = sequence {
        yield(1)
        yieldAll(listOf(3, 5))
        yieldAll(generateSequence(7) { it + 2 })
    }
    println(oddNum.take(5).toList())

}