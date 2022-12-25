package higherOrderFunctions

/**
 * - Lambdas are normally compiled to anonymous classes. But that means every time you
 * use a lambda expression, an extra class is created; and if the lambda captures some
 * variables, then a new object is created on every invocation. This introduces runtime
 * overhead, causing an implementation that uses a lambda to be less efficient
 * than a function that executes the same code directly.
 * - If you mark a function with the inline modifier, the compiler won't generate a
 * function call when this function is used and instead will replace every call to
 * the function with the actual code implementing the function
 * - When you declare a function as inline, its body is inlined - in other words,
 * it's substituted directly into places where the function is called instead
 * of being invoked normally.
 */

/**
 * RESTRICTIONS ON INLINE FUNCTIONS
 * - Due to the way inlining is performed, not every function that uses lambdas can be
 * inlined. When the function is inlined, the body of the lambda expression that's
 * passed as an argument is substituted directly into the resulting code.
 * - That restricts the possible uses of the corresponding parameter in the function
 * body. If this parameter is called, such code can be easily inlined. But if the
 * parameter is stored somewhere for further use, the code of the lambda expression
 * can't be inlined, because there must be an object that contains this code.
 * - Generally, the parameter can be inlined if it's called directly or passed as an
 * argument to another inline function. Otherwise, the compiler will prohibit the
 * inlining of the parameter with an error message.
 */