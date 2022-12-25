package functions

import newLine

fun main() {

    /**
     * WITH
     * A non-extension function: the context object is passed as an argument,
     * but inside the lambda, it's available as a receiver (this ).
     * The return value is the lambda result.
     * We recommend with for calling functions on the context object without providing
     * the lambda result. In the code, with can be read as
     * "with this object, do the following."
     */
    val aNumbers = mutableListOf("one", "two", "three")
    with(aNumbers) {
        println("'with' is called with argument $this")
        println("It contains $size elements")
    }
    "" newLine ""

    /**
     * Another use case for with is introducing a helper object whose properties or
     * functions will be used for calculating a value.
     */
    val bNumbers = mutableListOf("one", "two", "three")
    val firstAndLast = with(bNumbers) {
        "The first element is ${first()}, the last element is ${last()}"
    }
    println(firstAndLast)
    "" newLine ""

    /**
     * RUN
     * The context object is available as a receiver (this ).
     * The return value is the lambda result.
     * run does the same as with but invokes as let - as an extension function of the
     * context object.
     * run is useful when your lambda contains both the object initialization and
     * the computation of the return value.
     */
    val service = MultiportService("https://example.kotlinlang.org", 80)

    val result = service.run {
        port = 8080
        query("${prepareRequest()} to port $port")
    }

    // the same code written with let() function:
    val letResult = service.let {
        it.port = 8080
        it.query("${it.prepareRequest()} to port ${it.port}")
    }
    "" newLine ""

    /**
     * Besides calling run on a receiver object, you can use it as a non-extension
     * function. Non-extension run lets you execute a block of several statements
     * where an expression is required.
     */
    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"

        Regex("[$sign]?[$digits$hexDigits]+")
    }

    for (match in hexNumberRegex.findAll("+1234 -FFFF not-a-number")) {
        println(match.value)
    }
    "" newLine ""

}

class MultiportService(url: String, i: Int) {

    var port: Int = 0

    fun query(s: String) {
        println("Result for query $s")
    }

    fun prepareRequest() {
        println("Default request ")
    }
}