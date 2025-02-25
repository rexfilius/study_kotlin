package documentation.classes

/**
 * Extensions declared as members can be declared as open and overridden in subclasses.
 * This means that the dispatch of such functions is virtual with regard to the dispatch
 * receiver type, but static with regard to the extension receiver type
 */
open class Base4 {/**/ }

class Derived4 : Base4() {/**/ }

open class BaseCaller {
    open fun Base4.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }

    open fun Derived4.printFunctionInfo() {
        println("Derived extension function in BaseCaller")
    }

    fun call(b: Base4) {
        b.printFunctionInfo()
    }
}

class DerivedCaller : BaseCaller() {
    override fun Base4.printFunctionInfo() {
        println("Base extension function in DerivedCaller")
    }

    override fun Derived4.printFunctionInfo() {
        print("Derived extension function in DerivedCaller")
    }
}

fun main() {

    // "Base extension function in BaseCaller"
    BaseCaller().call(Base4())

    // 'Base extension function in DerivedCaller': dispatch receiver is resolved virtually
    DerivedCaller().call(Base4())

    // 'Base extension function in DerivedCaller':extension receiver is resolved statically
    DerivedCaller().call(Derived4())
}

/**
 * EXTENSIONS VISIBILITY
 * Extensions utilize the same visibility of other entities as regular functions declared
 * in the same scope would.
 * 1. An extension declared at the top level of a file has access to the other
 *    private top-level declarations in the same file.
 * 2. If an extension is declared outside its receiver type, such an extension
 *    cannot access the receiver's private members
 */