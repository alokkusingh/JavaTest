package alok.test.ds.graph;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Graph<Integer> graph = new Graph<>();
        graph.addEdge(1, 2);
        System.out.println("Edge Size: " + graph.getEdgeCount() + ", Vertex Count: " + graph.getVertexCount());
        graph.addEdge(1, 3);
        System.out.println("Edge Size: " + graph.getEdgeCount() + ", Vertex Count: " + graph.getVertexCount());
        graph.addEdge(2, 3);
        System.out.println("Edge Size: " + graph.getEdgeCount() + ", Vertex Count: " + graph.getVertexCount());
        graph.addEdge(3, 4);
        System.out.println("Edge Size: " + graph.getEdgeCount() + ", Vertex Count: " + graph.getVertexCount());
        graph.addEdge(2, 4);
        System.out.println("Edge Size: " + graph.getEdgeCount() + ", Vertex Count: " + graph.getVertexCount());

        graph.addEdges(Arrays.asList(
                graph.new Edge(4,5),
                graph.new Edge(4,6),
                graph.new Edge(5,6),
                graph.new Edge(5,7),
                graph.new Edge( 6,7)
        ));
        System.out.println("Edge Size: " + graph.getEdgeCount() + ", Vertex Count: " + graph.getVertexCount());

        System.out.println(graph);

        Graphs.bfsTraversal(graph, 2, 4);
    }
}
