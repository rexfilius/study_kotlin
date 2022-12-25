package classes

interface A {
    fun foo() = print("A")
    fun bar()
}

interface B {
    fun foo() = print("B")
    fun bar() = print("bar")
}

/**
 * Interfaces A and B both declare functions foo() and bar(). Both of them implement
 * foo(), but only B implements bar() (bar() is not marked abstract in A, because this
 * is the default for interfaces, if the function has no body). Now, if you derive a
 * concrete class C from A, you, obviously, have to override bar() and provide an
 * implementation...However, if you derive D from A and B, you need to implement
 * all the methods which you have inherited from multiple interfaces, and to specify
 * how exactly D should implement them. This rule applies both to methods for which
 * you've inherited a single implementation - bar() and multiple implementations foo()
 */

class C : A {
    override fun bar() = print("bar")
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}
