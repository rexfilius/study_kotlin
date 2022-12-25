class OuterClass {
    var name: String = "outer_name"

    class NestedClass {
        var name: String = "nested_name"
        fun foo() = println(this.name)
    }

    inner class InnerClass {
        var name: String = "inner_name"
        fun foo() = println(this@OuterClass.name)
    }
}

fun main() {
    val outerObject = OuterClass()
    val innerObject1 = outerObject.InnerClass()
    val innerObject2 = OuterClass().InnerClass()
    val nestedObject = OuterClass.NestedClass()

    println(outerObject.name)    // outer_name
    println(nestedObject.name)    // nested_name
    println(innerObject1.name)    // inner_name
    println(innerObject2.name)    // inner_name
    nestedObject.foo()    // nested_name
    innerObject1.foo()    // outer_name
    innerObject2.foo()    // outer_name
}