package basics.idioms

fun main() {

    // instantiating an abstract class
    val myObject = object : MyAbstractClass() {
        override fun doSomething() {
            // ...
        }

        override fun sleep() {
            // ...
        }
    }
    myObject.doSomething()

}

// Create a Singleton
object Resource {
    val name = "Name"
}

abstract class MyAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()
}