package classes

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

/**
 * Note that anonymous objects can be used as types only in local and private declarations.
 * If you use an anonymous object as a return type of a public function or the type of a
 * public property, the actual type of that function or property will be the declared
 * supertype of the anonymous object, or 'Any' if you haven't declared any supertype.
 * Members added in the anonymous object will not be accessible
 */
class C2 {
    // Private function, so the return type is the anonymous object type
    private fun foo() = object {
        val x: String = "typeSystem.getX"
    }

    // Public function, so the return type is Any
    fun publicFoo() = object {
        val x: String = "typeSystem.getX"
    }

    fun bar() {
        val x1 = foo().x        // Works
        //val x2 = publicFoo().typeSystem.getX  // ERROR: Unresolved reference 'typeSystem.getX'
    }
}

// The code in object expressions can access variables from the enclosing scope
fun countClick(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent) {
            enterCount++
        }
    })
}
