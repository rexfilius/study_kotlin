package raywenderlich.graph

import raywenderlich.graph.basics.*
import raywenderlich.queue.priorityQueue.MyPriorityQueue
import raywenderlich.queue.priorityQueue.MyPriorityQueueComparator
import kotlin.math.roundToInt

object Prim {

    /**
     * [produceMinimumSpanningTree] takes an undirected graph and returns a
     * minimum spanning tree and its cost.
     */
    fun <T> produceMinimumSpanningTree(
        graph: AdjacencyList<T>
    ): Pair<Double, AdjacencyList<T>> {
        // cost keeps track of the total weight of edges in the minimum spanning tree.
        var cost = 0.0
        // This is a graph that will become your minimum spanning tree.
        val minSpanTree = AdjacencyList<T>()
        // visited stores all vertices that have already been visited.
        val visited = mutableSetOf<MyVertex<T>>()
        // You create the Comparator<Edge<T>> to use for the priority queue.
        val comparator = Comparator<MyEdge<T>> { first, second ->
            val firstWeight = first.weight ?: 0.0
            val secondWeight = second.weight ?: 0.0
            (secondWeight - firstWeight).roundToInt()
        }
        // This is a min-priority queue to store edges.
        val priorityQueue = MyPriorityQueueComparator(comparator)

        // Copy all the vertices from the original graph to the minimum spanning tree.
        minSpanTree.copyVertices(graph)
        // Get the starting vertex from the graph.
        val startVertex = graph.verticesSet.firstOrNull() ?: return Pair(cost, minSpanTree)
        // Mark the starting vertex as visited.
        visited.add(startVertex)
        // Add all potential edges from the start vertex into the priority queue.
        addAvailableEdges(startVertex, graph, visited, priorityQueue)

        while (true) {
            // Continue Prim algorithm until the queue of edges is empty.
            val smallestEdge = priorityQueue.dequeue() ?: break
            // Get the destination vertex.
            val vertex = smallestEdge.destination
            // If this vertex has been visited, restart the loop
            // and get the next smallest edge.
            if (visited.contains(vertex)) continue
            // OR: if (vertex in visited) continue

            // Mark the destination vertex as visited.
            visited.add(vertex)
            // Add the edge’s weight to the total cost.
            cost += smallestEdge.weight ?: 0.0
            // Add the smallest edge to the minimum spanning tree you are constructing
            minSpanTree.add(
                edge = MyEdgeType.UNDIRECTED,
                source = smallestEdge.source,
                destination = smallestEdge.destination,
                weight = smallestEdge.weight
            )
            // Add the available edges from the current vertex.
            addAvailableEdges(vertex, graph, visited, priorityQueue)
        }
        // Once the priorityQueue is empty, return the minimum cost,
        // and minimum spanning tree.
        return Pair(cost, minSpanTree)
    }

    /**
     * - Function to find and store the edges of every vertex you explore.
     * - This method takes in four parameters:
     * (1) vertex - the current vertex.
     * (2) graph - the graph, wherein the current vertex is stored
     * (3) visited - the vertices that have already been visited
     * (4) priorityQueue - the priority queue to add all potential edges
     */
    private fun <T> addAvailableEdges(
        vertex: MyVertex<T>,
        graph: MyGraphInterface<T>,
        visited: Set<MyVertex<T>>,
        priorityQueue: MyPriorityQueue<MyEdge<T>>
    ) {
        // Look at every edge adjacent to the current vertex.
        graph.edges(vertex).forEach { edge: MyEdge<T> ->
            // Check to see if the destination vertex has already been visited
            // If it has not been visited, you add the edge to the priority queue.
            if (edge.destination !in visited)
                priorityQueue.enqueue(edge)
        }
    }

}