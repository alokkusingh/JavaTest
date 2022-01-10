package alok.test.ds.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graphs {

    public static <T> void bfsTraversal(Graph<T> graph, T s) {

        Queue<T> queue = new LinkedList<>();
        Set<T> visitedNodes = new HashSet<>();

        queue.add(s);

        while (queue.size() > 0) {
            T current = queue.poll();

            if (visitedNodes.contains(current))
                continue;

            visitedNodes.add(current);
            System.out.println(current);

            for (T adj: graph.getEdges(current)) {
               queue.add(adj);
            }
        }


    }

    public static <T> void dfsTraversal(Graph<T> graph, T s) {
        dfsTraversal(graph, s, new HashSet<>());
    }

    private static <T> void dfsTraversal(Graph<T> graph, T s, Set<T> visitedSet) {

        if (visitedSet.contains(s))
            return;

        System.out.println(s);

        visitedSet.add(s);

        for (T adj: graph.getEdges(s)) {
            dfsTraversal(graph, adj, visitedSet);
        }
    }

    public static <T> boolean hasPathBfs(Graph<T> graph, T s, T t) {

        Queue<T> queue = new LinkedList<>();
        Set<T> visited = new HashSet<>();

        queue.add(s);
        while (queue.size() > 0) {
            T current = queue.poll();
            if (visited.contains(current))
                continue;

            visited.add(current);

            for (T adj: graph.getEdges(current)) {
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

        for (T adj: graph.getEdges(s)) {
            if (hasPathDfs(graph, adj, t, visitedSet)) {
                return true;
            }
        }

        return false;
    }
}
