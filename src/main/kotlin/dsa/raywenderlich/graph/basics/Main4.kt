package raywenderlich.graph.basics

import raywenderlich.graph.Prim

fun main() {
    val graph = AdjacencyList<Int>()
    val one = graph.createVertex(1)
    val two = graph.createVertex(2)
    val three = graph.createVertex(3)
    val four = graph.createVertex(4)
    val five = graph.createVertex(5)
    val six = graph.createVertex(6)

    graph.add(MyEdgeType.UNDIRECTED, one, two, 6.0)
    graph.add(MyEdgeType.UNDIRECTED, one, three, 1.0)
    graph.add(MyEdgeType.UNDIRECTED, one, four, 5.0)
    graph.add(MyEdgeType.UNDIRECTED, two, three, 5.0)
    graph.add(MyEdgeType.UNDIRECTED, two, five, 3.0)
    graph.add(MyEdgeType.UNDIRECTED, three, four, 5.0)
    graph.add(MyEdgeType.UNDIRECTED, three, five, 6.0)
    graph.add(MyEdgeType.UNDIRECTED, three, six, 4.0)
    graph.add(MyEdgeType.UNDIRECTED, four, six, 2.0)
    graph.add(MyEdgeType.UNDIRECTED, five, six, 6.0)

    // not giving the same output as in the book
    val (cost, minSpanTree) = Prim.produceMinimumSpanningTree(graph)
    println("Cost: $cost")
    println("min span tree:")
    println(minSpanTree)
}