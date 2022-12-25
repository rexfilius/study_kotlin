package delegation

interface SoundBehavior {
    fun makeSound()
}

/**
 * The classes [ScreamBehavior] and [RockAndRollBehavior] implement the interface and
 * contain their own implementations of the method [SoundBehavior.makeSound].
 */
class ScreamBehavior(val n: String) : SoundBehavior {
    override fun makeSound() = println("${n.toUpperCase()} !!!")
}

class RockAndRollBehavior(val n: String) : SoundBehavior {
    override fun makeSound() = println("I'm The King of Rock 'N' Roll: $n")
}

/**
 * The classes [TomAraya] and [ElvisPresley] also implement the interface [SoundBehavior]
 * but not the method. Instead, they delegate the method calls to the responsible
 * implementation. The delegate object is defined after the 'by' keyword.
 */
class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)
class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n)

fun main() {

    /**
     * When makeSound() is called on tomAraya of type TomAraya or elvisPresley of type
     * ElvisPresley, the call is delegated to the corresponding delegate object.
     */
    val tomAraya = TomAraya("Thrash Metal")
    tomAraya.makeSound()

    val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
    elvisPresley.makeSound()

}