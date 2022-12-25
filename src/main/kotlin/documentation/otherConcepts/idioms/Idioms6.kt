package otherConcepts.idioms

import java.awt.Rectangle

fun main() {

    // Call multiple methods on an object instance (with)
    val myTurtle = Turtle()
    with(myTurtle) {
        // draw a 100 pix square
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }

    // Configure properties of an object (apply). This is useful
    // for configuring properties that aren't present in object constructor
    val myRectangle = Rectangle().apply {
        x = 4
        y = 5
        width = 10
        height = 20
    }

}

class Turtle {
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(pixels: Double) {}
}