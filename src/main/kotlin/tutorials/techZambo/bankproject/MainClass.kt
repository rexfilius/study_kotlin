package bankproject

import java.util.*

const val WITHDRAW = 1
const val DEPOSIT = 2
const val EXIT = 3
var usersChoice: Int = WITHDRAW

fun main() {
    //println("Welcome to Ted's Bank")
    //val bank = Bank()
    //usersChoice = WITHDRAW
    //doBankActionFromUserInput(bank)
}

fun doBankActionFromUserInput(bank: Bank) {
    while (usersChoice != EXIT) {
        greetUserWithChoices()
        displayAmountInBank(bank)
        usersChoice = readLine()!!.toInt()
        if (usersChoice == DEPOSIT) {
            val depositAmount = getDepositAmountFromUser()
            bank.deposit(depositAmount)
            println("Date: ${bank.getCurrentDate(System.currentTimeMillis())}")
        } else if (usersChoice == WITHDRAW) {
            val withdrawAmount = getWithdrawAmountFromUser()
            bank.withdraw(withdrawAmount)
        }
    }
}

fun getWithdrawAmountFromUser(): Double {
    print("how much would you like to withdraw")
    return readLine()!!.toDouble()
}

fun getDepositAmountFromUser(): Double {
    print("How much would you like to deposit")
    return readLine()!!.toDouble()
}

fun greetUserWithChoices() {
    println("Choose what you want to do")
    println("1. Withdraw")
    println("2. Deposit")
    println("3. Exit")
}

fun displayAmountInBank(bank: Bank) {
    println("current amount of money: ${bank.moneyInBank}")
}