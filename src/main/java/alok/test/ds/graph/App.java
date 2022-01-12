package alok.test.ds.graph;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Graph<Integer> graph = new UnidirectionalGraph<>();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);

        graph.addEdges(Arrays.asList(
                graph.new Edge(4,5),
                graph.new Edge(4,6),
                graph.new Edge(5,6),
                graph.new Edge(5,7),
                graph.new Edge( 6,7),
                graph.new Edge( 8,9)
        ));
        System.out.println("Edge Size: " + graph.getEdgeCount() + ", Vertex Count: " + graph.getVertexCount());

        System.out.println(graph);

        System.out.println("BFS Traversal from 1: ");
        Graphs.bfsTraversal(graph, 1);
        System.out.println("DFS Traversal from 1: ");
        Graphs.dfsTraversal(graph, 1);

        System.out.println("BFS Traversal from 8: ");
        Graphs.bfsTraversal(graph, 8);
        System.out.println("DFS Traversal from 8: ");
        Graphs.dfsTraversal(graph, 8);

        System.out.println("BFS Traversal from 3: ");
        Graphs.bfsTraversal(graph, 3);
        System.out.println("DFS Traversal from 3: ");
        Graphs.dfsTraversal(graph, 3);

        System.out.println("Has path between 2 and 4: " + Graphs.hasPathBfs(graph, 2, 4));
        System.out.println("Has path between 2 and 4: " + Graphs.hasPathDfs(graph, 2, 4));

        System.out.println("Has path between 2 and 1: " + Graphs.hasPathBfs(graph, 2, 1));
        System.out.println("Has path between 2 and 1: " + Graphs.hasPathDfs(graph, 2, 1));

        System.out.println("Has path between 1 and 7: " + Graphs.hasPathBfs(graph, 1, 7));
        System.out.println("Has path between 1 and 7: " + Graphs.hasPathDfs(graph, 1, 7));

        System.out.println("Has path between 1 and 9: " + Graphs.hasPathBfs(graph, 1, 9));
        System.out.println("Has path between 1 and 9: " + Graphs.hasPathDfs(graph, 1, 9));

        //          (2) -> (3) -> (5)
        // (1) <                      (6)
        //              (4) >
        Graph<Integer> graph2 = new UnidirectionalGraph();
        graph2.addEdges(Arrays.asList(
                graph2.new Edge(1,2),
                graph2.new Edge(1,4),
                graph2.new Edge(2,3),
                graph2.new Edge(3,5),
                graph2.new Edge(5,6),
                graph2.new Edge( 4,6)
        ));
        System.out.println(graph2);
        System.out.println("Has path between 1 and 5: " + Graphs.hasPathBfs(graph2, 1, 5));
        System.out.println("Has path between 1 and 5: " + Graphs.hasPathDfs(graph2, 1, 5));
        System.out.println("Has path between 4 and 5: " + Graphs.hasPathBfs(graph2, 4, 5));
        System.out.println("Has path between 4 and 5: " + Graphs.hasPathDfs(graph2, 4, 5));
        System.out.println("BFS Traversal from 1: ");
        Graphs.bfsTraversal(graph2, 1);
        System.out.println("DFS Traversal from 1: ");
        Graphs.dfsTraversal(graph2, 1);
        System.out.println("Largest connected node size: " + Graphs.largestConnectedNodesSize(graph2));
        System.out.println("Shortest connected node size: " + Graphs.shortestPathSize(graph2, 1, 6));
    }
}
