package classes

/**
 * Inside a class, you can declare extensions for another class. Inside such an extension,
 * there are multiple implicit receivers- objects members of which can be accessed without
 * a qualifier. The instance of the class in which the extension is declared is called
 * DISPATCH RECEIVER, and the instance of the receiver type of the extension method is
 * called EXTENSION RECEIVER.
 */
class Host(val hostName: String) {
    fun printHostname() = print(hostName)
}

class Connection(val host: Host, val port: Int) {

    fun printPort() = print(port)

    fun Host.printConnectionString() {
        printHostname()  // calls Host.printHostname()
        print(":")
        printPort()  // calls Connection.printPort()
    }

    fun connect() = host.printConnectionString()  // calls the extension function

    fun Host.getConnectionString() {
        toString()    // calls Host.toString()
        this@Connection.toString()    // calls Connection.toString()
    }

    fun connectString() = host.getConnectionString()
}

fun main() {
    Connection(Host("kotl.in"), 443).connect()

    // error: the extension function is unavailable outside Connection class
    //Host("kotl.in").printConnectionString()

    // testing things
    val c = Connection(Host("jvm.all"), 1995)
    c.connectString()
}
