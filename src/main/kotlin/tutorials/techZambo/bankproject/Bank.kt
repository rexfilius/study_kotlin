package bankproject

import java.text.SimpleDateFormat
import java.util.*

class Bank() {

    var moneyInBank: Double = 0.00

    fun deposit(amount: Double) {
        moneyInBank += amount
    }

    fun withdraw(amount: Double) {
        moneyInBank -= amount
    }

    fun getCurrentDate(currentTimeInMilliSeconds: Long): String {
        val date = Date(currentTimeInMilliSeconds)
        val formatter = SimpleDateFormat("MMM/dd/y: h:mm:a")
        return formatter.format(date)
    }
}