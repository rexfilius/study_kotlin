package oop

// A Primary Constructor
class Rectangle(val height: Int, val width: Int) {

    // A Secondary Constructor
    constructor(side: Int): this(side, side) { }
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    BLUE(0,0,255), ORANGE(255, 165, 0), RED(255, 0, 0);
    fun rgb() = (r * 256 + g) * 256 + b
}