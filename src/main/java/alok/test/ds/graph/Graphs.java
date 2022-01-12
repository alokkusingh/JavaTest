package alok.test.ds.graph;

import java.util.*;

public class Graphs {

    private Graphs() {}

    public static <T> void bfsTraversal(Graph<T> graph, T s) {

        Queue<T> queue = new LinkedList<>();
        Set<T> visitedNodes = new HashSet<>();

        queue.add(s);

        while (!queue.isEmpty()) {
            T current = queue.poll();

            if (visitedNodes.contains(current))
                continue;

            visitedNodes.add(current);
            System.out.print(current + " -> ");

            for (T adj: graph.getAdjEdges(current)) {
               queue.add(adj);
            }
        }
        System.out.println();
    }

    public static <T> void dfsTraversal(Graph<T> graph, T s) {
        dfsTraversal(graph, s, new HashSet<>());
        System.out.println();
    }

    private static <T> void dfsTraversal(Graph<T> graph, T s, Set<T> visitedSet) {

        if (visitedSet.contains(s))
            return;

        System.out.print(s + " -> ");

        visitedSet.add(s);

        for (T adj: graph.getAdjEdges(s)) {
            dfsTraversal(graph, adj, visitedSet);
        }
    }

    public static <T> boolean hasPathBfs(Graph<T> graph, T s, T t) {

        Queue<T> queue = new LinkedList<>();
        Set<T> visited = new HashSet<>();

        queue.add(s);
        while (!queue.isEmpty()) {
            T current = queue.poll();
            if (visited.contains(current))
                continue;

            visited.add(current);

            for (T adj: graph.getAdjEdges(current)) {
                if (adj.equals(t)) {
                    return true;
                }
                queue.add(adj);
            }
        }

        return false;
    }

    public static <T> boolean hasPathDfs(Graph<T> graph, T s, T t) {

        return hasPathDfs(graph, s, t, new HashSet<>());
    }

    private static <T> boolean hasPathDfs(Graph<T> graph, T s, T t, Set<T> visitedSet) {

        if (visitedSet.contains(s))
            return false;

        visitedSet.add(s);

        if (s.equals(t)) {
            return true;
        }

        for (T adj: graph.getAdjEdges(s)) {
            if (hasPathDfs(graph, adj, t, visitedSet)) {
                return true;
            }
        }

        return false;
    }

    public static <T> int largestConnectedNodesSize(Graph<T> graph) {
        int maxsize = 0;
        Set<T> visitedSet = new HashSet<>();

        for (T v: graph.getAllNodes()) {
            int size = exploreSize(graph, v, visitedSet);
            if (size > maxsize)
               maxsize = size;
        }

        return maxsize;
    }

    private static <T> int exploreSize(Graph<T> graph, T v, Set<T> visitedSet) {
        if (visitedSet.contains(v))
            return 0;

        visitedSet.add(v);

        int size = 1;

        List<Integer> nodeSizes = new ArrayList<>(graph.getAdjEdges(v).size());
        for (T adj: graph.getAdjEdges(v)) {
            nodeSizes.add(exploreSize(graph, adj, visitedSet));
        }
        int maxSize = 0;
        for (int nodeSize: nodeSizes) {
            if (nodeSize > maxSize)
                maxSize = nodeSize;
        }

        return size + maxSize;
    }

    public static <T> int shortestPathSize(Graph<T> graph, T start, T end) {
        // BFS has to be used
        // BFS traverse all the adg node first then goes to next level for adj
        // This explores all the possibility from each node rather going in onde direction

        Set<T> visitedSet = new HashSet<>();
        Queue<T> nodeQueue = new LinkedList<>();
        Queue<Integer> sizeQueue = new LinkedList<>();
        nodeQueue.add(start);
        sizeQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            T current = nodeQueue.poll();
            int size = sizeQueue.poll();
            if (visitedSet.contains(current))
                continue;

            visitedSet.add(current);

            if (current.equals(end))
                return size;

            for (T adj: graph.getAdjEdges(current)) {
                nodeQueue.add(adj);
                sizeQueue.add(size + 1);
            }
        }

        // no such path found
        return -1;
    }
}
