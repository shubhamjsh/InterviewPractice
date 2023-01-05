package org.example.graph;

import java.util.HashSet;
import java.util.Set;

public class DirectedGraphCycle {

    public boolean hasCycle(Graph<Integer> graph) {
        Set<Vertex<Integer>> white = new HashSet<>();
        Set<Vertex<Integer>> gray = new HashSet<>();
        Set<Vertex<Integer>> black = new HashSet<>();

        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            white.add(vertex);
        }

        while (white.size() > 0) {
            Vertex<Integer> current = white.iterator().next();
            if(dfs(current, white, gray, black)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(Vertex<Integer> current,
                       Set<Vertex<Integer>> white,
                       Set<Vertex<Integer>> gray,
                       Set<Vertex<Integer>> black) {

        moveVertex(current, white, gray);
        for(Vertex<Integer> neighbour : current.getAdjacentVertexes()) {
            if(black.contains(neighbour))
                continue;
            if(gray.contains(neighbour))
                return true;
            if(dfs(neighbour,white, gray, black))
                return true;
        }
        moveVertex(current, gray, black);
        return false;
    }

    public void moveVertex(Vertex<Integer> current,
                           Set<Vertex<Integer>> source,
                           Set<Vertex<Integer>> destination) {
        source.remove(current);
        destination.add(current);
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 3);
//        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);

        DirectedGraphCycle cyc = new DirectedGraphCycle();
        System.out.println(cyc.hasCycle(graph));
    }
}
