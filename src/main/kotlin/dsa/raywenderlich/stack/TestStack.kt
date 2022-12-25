package raywenderlich.stack

import raywenderlich.util.example

fun main() {

    "Using a stack" example {
        val aStack = Stack<Int>().apply {
            push(1)
            push(2)
            push(3)
            push(4)
        }
        print(aStack)

        val poppedElement = aStack.pop()
        if (poppedElement != null)
            println("Popped: $poppedElement")
        print(aStack)
    }

    "initializing a stack from a list" example {
        val aList = listOf("A", "B", "C", "D")
        val bStack = Stack.createFromIterable(aList)
        println(bStack)
        println("Popped: ${bStack.pop()}")
    }

    "initializing a stack from an array literal" example {
        val cStack = myStackOf(1.0, 2.0, 3.0, 4.0)
        println(cStack)
        println("Popped: ${cStack.pop()}")
    }

}