package thirtyDaysOfCode

class Palindrome(
    val stack: MutableList<Any> = mutableListOf(),
    val queue: MutableList<Any> = mutableListOf()
) {

    fun pushCharacter(char: Char) {
        stack.add(char)
    }

    fun enqueueCharacter(char: Char) {
        queue.add(char)
    }

    fun popCharacter(): Any {
        return stack.removeLast()
    }

    fun dequeueCharacter(): Any {
        return queue.removeFirst()
    }
}

fun main() {
    val input = readln()
    val obj = Palindrome()

    for (i in input.indices) {
        obj.pushCharacter(input[i])
        obj.enqueueCharacter(input[i])
    }

    var isPalindrome = true

    for (i in 0..input.length / 2) {
        if (obj.popCharacter() != obj.dequeueCharacter()) {
            isPalindrome = false
            break
        }
    }

    if (isPalindrome)
        print("The word, $input, is a palindrome.")
    else
        print("The word, $input, is not a palindrome.")
}