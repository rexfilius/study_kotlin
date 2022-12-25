package raywenderlich.graph

import raywenderlich.graph.basics.AdjacencyList
import raywenderlich.graph.basics.MyEdgeType

fun main() {
    // AdjacencyList and AdjacencyMatrix have the same interfaces
    val graph = AdjacencyList<String>()
    //val graph = AdjacencyMatrix<String>()

    val singapore = graph.createVertex("Singapore")
    val tokyo = graph.createVertex("Tokyo")
    val hongKong = graph.createVertex("Hong Kong")
    val detroit = graph.createVertex("Detroit")
    val sanFrancisco = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val austin = graph.createVertex("Austin")
    val seattle = graph.createVertex("Seattle")

    graph.add(MyEdgeType.UNDIRECTED, singapore, hongKong, 300.0)
    graph.add(MyEdgeType.UNDIRECTED, singapore, tokyo, 500.0)
    graph.add(MyEdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
    graph.add(MyEdgeType.UNDIRECTED, tokyo, detroit, 450.0)
    graph.add(MyEdgeType.UNDIRECTED, tokyo, washingtonDC, 300.0)
    graph.add(MyEdgeType.UNDIRECTED, hongKong, sanFrancisco, 600.0)
    graph.add(MyEdgeType.UNDIRECTED, detroit, austin, 50.0)
    graph.add(MyEdgeType.UNDIRECTED, austin, washingtonDC, 292.0)
    graph.add(MyEdgeType.UNDIRECTED, sanFrancisco, washingtonDC, 337.0)
    graph.add(MyEdgeType.UNDIRECTED, washingtonDC, seattle, 277.0)
    graph.add(MyEdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
    graph.add(MyEdgeType.UNDIRECTED, austin, sanFrancisco, 297.0)
    println(graph)

    // How much is a flight from Singapore to Tokyo?
    val singToTokyo = graph.weight(source = singapore, destination = tokyo)
    println("Flight from Singapore to Tokyo: $singToTokyo")

    // What are all the outgoing flights from San Francisco?
    println("San Francisco Outgoing Flights:")
    println("--------------------------------")
    graph.edges(sanFrancisco).forEach { edge ->
        println("from: ${edge.source.data} to: ${edge.destination.data}")
    }

}