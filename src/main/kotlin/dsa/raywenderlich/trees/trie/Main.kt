package raywenderlich.trees.trie

import raywenderlich.util.example

fun main() {
    "insert and contains in a Trie" example {
        val aTrie = MyTrie<Char>()
        aTrie.insertChar("cute")

        if (aTrie.containsChar("cute")) {
            println("cute is in the Trie")
        }
    }

    "remove in a Trie" example {
        val bTrie = MyTrie<Char>()
        bTrie.insertChar("cut")
        bTrie.insertChar("cute")

        println("\n*** Before removing ***")
        assert(bTrie.containsChar("cut"))
        println("\"cut\" is in the trie")

        assert(bTrie.containsChar("cute"))
        println("\"cute\" is in the trie")
        println("\n*** After removing cut ***")

        bTrie.removeChar("cut")
        assert(!bTrie.containsChar("cut"))
        assert(bTrie.containsChar("cute"))
        println("\"cute\" is still in the trie")
    }

    "prefix matching" example {
        val trie = MyTrie<Char>().apply {
            insertChar("car")
            insertChar("card")
            insertChar("care")
            insertChar("cared")
            insertChar("cars")
            insertChar("carbs")
            insertChar("carapace")
            insertChar("cargo")
        }
        println("\nCollections starting with \"car\"")
        val prefixedWithCar = trie.collectionsChar("car")
        println(prefixedWithCar)

        println("\nCollections starting with \"care\"")
        val prefixedWithCare = trie.collectionsChar("care")
        println(prefixedWithCare)
    }
}