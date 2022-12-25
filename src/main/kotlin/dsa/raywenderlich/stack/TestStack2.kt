package raywenderlich.stack

import raywenderlich.util.example
import raywenderlich.linkedList.MyLinkedListIdiomatic

fun main() {

    "reversing a LinkedList using Stack" example {
        val aList = MyLinkedListIdiomatic<Int>()
        aList.pushFluently(1).pushFluently(2).pushFluently(3)
        println("LinkedList: $aList")
        println("In reverse: ${aList.printReverse()}")

        val bList = MyLinkedListIdiomatic<Int>()
        bList.appendFluently(1).appendFluently(2).appendFluently(3)
        println("LinkedList: $bList")
        println("In reverse: ${bList.printReverse()}")
    }

    "checking balanced parentheses in a string" example {
        val aString = "h((e))llo(world)()"
        val bString = "(hello)(world"
        println("$aString: ${aString.checkParentheses()}")
        println("$bString: ${bString.checkParentheses()}")
        println("face: ${"face".checkParentheses()}")  // odd result
    }

}