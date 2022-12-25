package functions

/**
 * - Using higher-order functions imposes certain runtime penalties: each function is an
 * object, and it captures a closure. A closure means those variables that are accessed in
 * the body of the function. Memory allocations (both for function objects and classes)
 * and virtual calls introduce runtime overhead
 * - The inline modifier affects both the function itself and the lambdas passed to it: all
 * of those will be inlined into the call site. Inlining may cause the generated code to
 * grow; however, if you do it in a reasonable way (avoiding inlining large functions),
 * it will pay off in performance, especially at "mega-morphic" call-sites inside loops.
 */
fun docNotes() {}

/**
 * In case you want only some of the lambdas passed to an inline function to be inlined,
 * you can mark some of your function parameters with the noinline modifier
 */
inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {}

/**
 * NON-LOCAL RETURNS
 * In Kotlin, you can only use a normal, unqualified return to exit a named function or
 * an anonymous function. To exit a lambda, use a label. A bare return is forbidden inside
 * a lambda because a lambda cannot make the enclosing function return
 * ...
 * But if the function the lambda is passed to is inlined, the return can be inlined as
 * well. So it is allowed. Such returns (located in a lambda, but exiting the enclosing
 * function) are called non-local returns.
 */
fun hasZeros(ints: List<Int>): Boolean {
    ints.forEach {
        if (it == 0) return true    // returns from hasZeros
    }
    return false
}

/**
 * Note that some inline functions may call the lambdas passed to them as parameters not
 * directly from the function body, but from another execution context, such as a local
 * object or a nested function. In such cases, non-local control flow is also not allowed
 * in the lambdas. To indicate that, the lambda parameter needs to be marked with
 * the 'crossinline' modifier
 */
inline fun f(crossinline body: () -> Unit) {
    val f = object : Runnable {
        override fun run() = body()
    }
    // ...
}


