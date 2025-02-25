package documentation.classes
// TODO: Read more on Delegation and Delegated Properties
/**
 * You can declare local variables as delegated properties.
 * For example, you can make a local variable lazy
 * ...
 * fun example(computeFoo: () -> Foo) {
 *     val memoizedFoo by lazy(computeFoo)
 *     if (someCondition && memoizedFoo.isValid()) {
 *         memoizedFoo.doSomething()
 *     }
 * }
 */

// NOTE: I skipped the rest of the doc part on delegation, will revisit later
