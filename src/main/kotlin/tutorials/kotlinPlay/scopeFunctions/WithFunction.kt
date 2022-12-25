package scopeFunctions

fun main() {

    val config = Configure("127.0.0.1", 9000)
    with(config) {
        println("$host: $port")
    }

}

data class Configure(val host: String, var port: Int)