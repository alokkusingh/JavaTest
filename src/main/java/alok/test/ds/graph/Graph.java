package alok.test.ds.graph;

import java.util.*;

public abstract class Graph<T> {

    private final Map<T, List<T>> map = new HashMap<>();
    private final boolean bidirectional;

    public Graph() {
        this.bidirectional = false;
    }

    public Graph(boolean bidirectional) {
        this.bidirectional = bidirectional;
    }

    private void addVertex(T v) {
        if (!map.containsKey(v))
            map.put(v, new LinkedList<>());
    }


    public void addEdge(T s, T t) {
        addVertex(s);
        addVertex(t);

        map.get(s).add(t);

        if (bidirectional)
            map.get(t).add(s);
    }

    public void addEdge(Edge e) {
        addEdge(e.getS(), e.getT());
    }

    public void addEdges(List<Edge> edges) {
        for (Edge e: edges) {
            addEdge(e.getS(), e.getT());
        }
    }

    public List<T> getAdjEdges(T current) {
        return map.get(current);
    }

    public Set<T> getAllNodes() {
        return map.keySet();
    }

    public int getVertexCount() {
        return map.keySet().size();
    }

    public int getEdgeCount() {

        int edgeCount = 0;

        for (T v: map.keySet()) {
            edgeCount += map.get(v).size();
        }

        if (bidirectional)
            edgeCount = edgeCount * 2;

        return edgeCount;
    }

    // Prints the adjacency list of each vertex.
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString()).append(": ");
            for (T w : map.get(v)) {
                builder.append(w.toString()).append(" ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }

    class Edge {

        private T s;
        private T t;

        public Edge(T s, T t) {
            this.s = s;
            this.t = t;
        }

        public T getS() {
            return s;
        }

        public void setS(T s) {
            this.s = s;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }
}
