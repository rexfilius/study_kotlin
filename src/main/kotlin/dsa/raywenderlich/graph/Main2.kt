package raywenderlich.graph

import raywenderlich.graph.basics.AdjacencyList
import raywenderlich.graph.basics.MyEdgeType

fun main() {
    val graph = AdjacencyList<String>()
    val a = graph.createVertex("A")
    val b = graph.createVertex("B")
    val c = graph.createVertex("C")
    val d = graph.createVertex("D")
    val e = graph.createVertex("E")
    val f = graph.createVertex("F")
    val g = graph.createVertex("G")
    val h = graph.createVertex("H")

    graph.add(MyEdgeType.UNDIRECTED, a, b, null)
    graph.add(MyEdgeType.UNDIRECTED, a, c, null)
    graph.add(MyEdgeType.UNDIRECTED, a, d, null)
    graph.add(MyEdgeType.UNDIRECTED, b, e, null)
    graph.add(MyEdgeType.UNDIRECTED, c, f, null)
    graph.add(MyEdgeType.UNDIRECTED, c, g, null)
    graph.add(MyEdgeType.UNDIRECTED, e, h, null)
    graph.add(MyEdgeType.UNDIRECTED, e, f, null)
    graph.add(MyEdgeType.UNDIRECTED, f, g, null)

    val vertices = graph.breadthFirstSearch(a)
    println("----Breadth first search----")
    vertices.forEach {
        println(it.data)
    }

    val cVertices = graph.depthFirstSearch(a)
    println("----Depth first search----")
    cVertices.forEach {
        println(it.data)
    }
}