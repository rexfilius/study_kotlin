typealias AuthToken = String

fun main() {

    val user = UserZ("Donn", "2344JUC56GHU-XDTRYUI87GY")
    Order(user.authToken)

}

data class UserZ(val username: String, val authToken: AuthToken)

data class Account(val authToken: AuthToken)

data class Order(val authToken: AuthToken)