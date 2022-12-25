package classes

fun main() {

    /* abstract class */
    //val v = Vehicle2("Red")

    /* anonymous interface implementation */
    var button = Button()
    button.clickListener = object: OnClickListener {
        override fun onClick() {
            println("This was clicked")
        }
    }
}

interface OnClickListener {
    fun onClick()
}

open abstract class View {
    lateinit var clickListener: OnClickListener

    fun click() = clickListener.onClick()

    fun setMyListener(clickListener: OnClickListener) {
        this.clickListener = clickListener
    }
}

class Button: View()
class Image: View()
class Map: View()
