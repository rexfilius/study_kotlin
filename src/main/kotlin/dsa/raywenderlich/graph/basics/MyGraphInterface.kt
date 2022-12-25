package raywenderlich.graph.basics

import raywenderlich.graph.MyQueueStack
import raywenderlich.stack.Stack

/**
 * - A graph is a data structure that captures relationships between objects. It's
 * made up of VERTICES connected by EDGES
 * - In a WEIGHTED GRAPH, every edge has a weight associated with it that represents
 * the cost of using this edge. This lets you choose the cheapest or shortest path
 * between two vertices.
 * - As well as assigning a weight to an edge, graphs can also have direction.
 * DIRECTED GRAPHS are more restrictive to traverse, as an edge may only permit
 * traversal in one direction
 * - An UNDIRECTED GRAPH is a directed graph where all the edges are bidirectional.
 * - In an undirected graph:
 * (1) Two connected vertices have edges going back and forth.
 * (2) The weight of an edge applies to both directions.
 * - This Graph interface can be implemented in two ways:
 * (1) Using an adjacency list.
 * (2) Using an adjacency matrix.
 * - You can represent real-world relationships through vertices and edges. Think of
 * vertices as objects and edges as the relationship between the objects.
 */
interface MyGraphInterface<T> {

    /**Creates a vertex and add it to a graph*/
    fun createVertex(data: T): MyVertex<T>

    /** Add a directed edge between two vertices */
    fun addDirectedEdge(
        source: MyVertex<T>,
        destination: MyVertex<T>,
        weight: Double?
    )

    /** Add an undirected edge between two vertices */
    fun addUnDirectedEdge(
        source: MyVertex<T>,
        destination: MyVertex<T>,
        weight: Double?
    ) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    /**
     * A convenient helper method that uses EdgeType to add either a directed
     * or undirected edge between two vertices.
     */
    fun add(
        edge: MyEdgeType,
        source: MyVertex<T>,
        destination: MyVertex<T>,
        weight: Double?
    ) {
        when (edge) {
            MyEdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            MyEdgeType.UNDIRECTED -> addUnDirectedEdge(source, destination, weight)
        }
    }

    /**Returns a list of outgoing edges from a specific vertex.*/
    fun edges(source: MyVertex<T>): ArrayList<MyEdge<T>>

    /**Returns the weight of the edge between two vertices*/
    fun weight(source: MyVertex<T>, destination: MyVertex<T>): Double?

    /**
     * - You can use BFS to solve a wide variety of problems: (1) Generating a
     * minimum-spanning tree. (2) Finding potential paths between vertices.
     * (3) Finding the shortest path between two vertices.
     * - BFS starts by selecting any vertex in a graph. The algorithm then explores
     * all neighbors of this vertex before traversing the neighbors of said
     * neighbors and so forth. As the name suggests, this algorithm takes a
     * breadth-first approach because it doesn't visit the children until
     * all the siblings are visited.
     * - The space complexity of BFS is O(V) since you have to store the vertices
     * in three separate structures: queue, enqueued and visited.
     * - It's generally good to use this algorithm when your graph structure has a
     * lot of neighboring vertices or when you need to find out every
     * possible outcome.
     */
    fun breadthFirstSearch(source: MyVertex<T>): ArrayList<MyVertex<T>> {
        // Keeps track of the neighboring vertices to visit next.
        val queue = MyQueueStack<MyVertex<T>>()
        // Remembers which vertices have been enqueued, so you don't enqueue
        // the same vertex twice.
        val enqueued = ArrayList<MyVertex<T>>()
        // An array list that stores the order in which the vertices were explored.
        val visited = ArrayList<MyVertex<T>>()
        // initiate the BFS algorithm by first enqueuing the source vertex.
        queue.enqueue(source)
        enqueued.add(source)

        while (true) {
            // Continue to dequeue a vertex from the queue until the queue is empty.
            val vertex = queue.dequeue() ?: break
            // Every time you dequeue a vertex from the queue, you add it to
            // the list of visited vertices.
            visited.add(vertex)
            // Find all edges that start from the current vertex & iterate over them.
            val neighbourEdges = edges(vertex)
            neighbourEdges.forEach {
                // For each edge, you check to see if its destination vertex has
                // been enqueued before, and if not, you add it to the code.
                if (!enqueued.contains(it.destination)) {
                    queue.enqueue(it.destination)
                    enqueued.add(it.destination)
                }
            }
        }
        return visited
    }

    /**
     * - There are many applications for DFS: (1) Topological sorting.
     * (2) Detecting a cycle. (3) Pathfinding, such as in maze puzzles.
     * (4) Finding connected components in a sparse graph.
     * - To perform a DFS, you start with a given source vertex and attempt to
     * explore a branch as far as possible until you reach the end. At this point,
     * you’d backtrack (move a step back) and explore the next available branch until
     * you find what you’re looking for or until you’ve visited all the vertices.
     */
    fun depthFirstSearch(source: MyVertex<T>): ArrayList<MyVertex<T>> {
        // Used to store your path through the graph.
        val stack = Stack<MyVertex<T>>()
        // A list that stores the order in which the vertices were visited
        val visited = arrayListOf<MyVertex<T>>()
        // Remembers which vertices were already pushed so that you don't visit
        // the same vertex twice. It's a MutableSet to ensure fast O(1) lookup
        val pushed = mutableSetOf<MyVertex<T>>()

        stack.push(source)
        pushed.add(source)
        visited.add(source)

        outer@ while (true) {
            if (stack.isEmpty) break
            // check the top of the stack for a vertex until the stack is empty
            val vertex = stack.peek()!!
            // find all the neighboring edges for the current vertex
            val neighbors = edges(vertex)
            // If there are no edges, you pop the vertex off the stack and
            // continue to the next one.
            if (neighbors.isEmpty()) {
                stack.pop()
                continue
            }
            // Loop through every edge connected to the current vertex and check to
            // see if the neighboring vertex has been seen. If not, you push it onto
            // the stack and add it to the visited list.
            for (i in 0 until neighbors.size) {
                val destination = neighbors[i].destination
                if (destination !in pushed) {
                    stack.push(destination)
                    pushed.add(destination)
                    visited.add(destination)
                    // Now that you've found a neighbor to visit, you continue the
                    // outer loop and move to the newly pushed neighbor.
                    continue@outer
                }
            }
            // If the current vertex did not have any unvisited neighbors, you know
            // that you reached a dead end and can pop it off the stack.
            stack.pop()
        }
        return visited
    }

    /**
     * Write a function to count the number of paths between two vertices in a
     * directed graph. One solution is to perform a depth-first traversal and keep
     * track of the visited vertices.
     */
    fun numberOfPaths(
        source: MyVertex<T>,
        destination: MyVertex<T>
    ): Int {
        val numberOfPaths = Ref(0) // 1
        val visited: MutableSet<MyVertex<T>> = mutableSetOf() // 2
        paths(source, destination, visited, numberOfPaths) // 3
        return numberOfPaths.value
    }

    fun paths(
        source: MyVertex<T>,
        destination: MyVertex<T>,
        visited: MutableSet<MyVertex<T>>,
        pathCount: Ref<Int>
    ) {
        // Initiate the algorithm by marking the source vertex as visited
        visited.add(source)

        // Check to see if the source is the destination. If it is, you have found
        // a path, so increment the count by one.
        if (source == destination) {
            pathCount.value += 1
        } else {
            // If the destination has not been found, get all the edges adjacent to
            // the source vertex.
            val neighbors = edges(source)
            neighbors.forEach { edge ->
                // For every edge, if it has not been visited before, recursively
                // traverse the neighboring vertices to find a path to the
                // destination vertex.
                if (edge.destination !in visited) {
                    paths(edge.destination, destination, visited, pathCount)
                }
            }
        }
        // Remove the source vertex from the visited list so that you can continue
        // to find other paths to that node.
        visited.remove(source)
    }

}