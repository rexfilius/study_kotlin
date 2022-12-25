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

    graph.add(MyEdgeType.DIRECTED, a, b, 8.0)
    graph.add(MyEdgeType.DIRECTED, a, f, 9.0)
    graph.add(MyEdgeType.DIRECTED, a, g, 1.0)
    graph.add(MyEdgeType.DIRECTED, b, f, 3.0)
    graph.add(MyEdgeType.DIRECTED, b, e, 1.0)
    graph.add(MyEdgeType.DIRECTED, f, a, 2.0)
    graph.add(MyEdgeType.DIRECTED, h, f, 2.0)
    graph.add(MyEdgeType.DIRECTED, h, g, 5.0)
    graph.add(MyEdgeType.DIRECTED, g, c, 3.0)
    graph.add(MyEdgeType.DIRECTED, c, e, 1.0)
    graph.add(MyEdgeType.DIRECTED, c, b, 3.0)
    graph.add(MyEdgeType.UNDIRECTED, e, c, 8.0)
    graph.add(MyEdgeType.DIRECTED, e, b, 1.0)
    graph.add(MyEdgeType.DIRECTED, e, d, 2.0)

    val dijkstra = Dijkstra(graph)

    // Calculate the shortest paths to all the vertices from the start vertex A.
    val pathsFromA = dijkstra.shortestPath(a)

    // Get the shortest path to D.
    val path = dijkstra.shortestPath(d, pathsFromA)

    // Print this path.
    path.forEach {
        println("${it.source.data} --|${it.weight ?: 0.0}|-->  ${it.destination.data}")
    }
}