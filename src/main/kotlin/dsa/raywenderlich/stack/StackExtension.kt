package raywenderlich.stack

import raywenderlich.linkedList.MyLinkedListIdiomatic

/**
 * - Reversing a LinkedList
 *
 * - One of the prime use cases for stacks is to facilitate backtracking. If you push
 * a sequence of values into the stack, sequentially popping the stack will give you
 * the values in reverse order
 *
 * - Overall, the time complexity is O(n) - pushing the nodes into the stack, and
 * popping the stack to print the values. Since you're allocating a container
 * (the stack) inside the function, you also incur an O(n) space complexity cost
 */
fun <T : Any> MyLinkedListIdiomatic<T>.printReverse() {
    val stack = Stack<T>()

    // copy the content of the list into a stack, carefully putting the nodes
    // on top of each other
    for (node in this) stack.push(node)

    // remove and print the nodes from the stack one by one, starting from the top
    var node = stack.pop()
    while (node != null) {
        println(node)
        node = stack.pop()
    }
}

/**
 * - CHALLENGE: Check for balanced parentheses. Given a String, check if there are
 * '(' and ')' characters, and return true if the parentheses in the string are balanced.
 * ...
 * - To check if there are balanced parentheses in the string, you need to go through
 * each character of the string. When you encounter an opening parenthesis, you'll
 * push that into a stack. Vice versa, if you encounter a closing parenthesis,
 * you should pop the stack.
 * ...
 * - Time complexity is O(n), where n is the number of characters in the string.
 * This algorithm also incurs an O(n) space complexity due to the usage of the Stack
 * data structure
 */
fun String.checkParentheses(): Boolean {
    // create a new stack
    val stack = Stack<Char>()

    // go through the string, character by character
    for (character in this) {
        when (character) {
            // push every opening parentheses into the stack
            '(' -> stack.push(character)

            // pop one item from the stack for every closing parentheses. If out of
            // item on the stack, string is imbalanced, return from function
            ')' -> {
                if (stack.isEmpty) return false
                else stack.pop()
            }
        }
    }

    // In the end, a balanced string is one that has popped all the opening
    // parentheses it’s pushed (and not a single item more). That would leave the
    // stack empty because you popped all the parentheses you pushed before.
    return stack.isEmpty // this will return true for a balanced parentheses
}