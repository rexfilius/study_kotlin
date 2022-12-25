package intro

fun main() {
    // TODO: whole code not giving me the output yet
    val bestFriends = arrayListOf("")
    var bestFriendInput = ""
    var deleteBestFriendInput = ""
    var optionPicked = "1"

    while (optionPicked != "3") {
        bestFriendInput =""
        println("1. Add Best Friend")
        println("2. Delete Best Friend")
        println("3. Exit")
        optionPicked = readLine()!!

        if (optionPicked == "1") {
            while (bestFriendInput != "") {
                println("Who's your best friend: ")
                bestFriendInput = readLine()!!
                bestFriends.add(bestFriendInput)
            }
        } else if (optionPicked == "2") {
            println("What index is your best friend at: ")
            deleteBestFriendInput = readLine()!!
            bestFriends.removeAt(deleteBestFriendInput.toInt())
        }
        for (friend in bestFriends) {
            println(friend)
        }
    }
}