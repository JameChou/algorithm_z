package struct.graph;

import java.util.List;

public class WeightedUndigraph implements Graph {
    private WeightedDigraph graph;

    public WeightedUndigraph() {
        this.graph = new WeightedDigraph();
    }

    public void addEdge(int from, int to, int weight) {
        graph.addEdge(from, to, weight);
        graph.addEdge(to, from, weight);
    }

    public void removeEdge(int from, int to) {
        graph.removeEdge(from, to);
        graph.removeEdge(to, from);
    }

    public int weight(int from, int to) {
        return graph.weight(from, to);
    }

    public boolean hasEdge(int from, int to) {
        return graph.hasEdge(from, to);
    }

    public int size() {
        return graph.size();
    }

    public List<WeightedDigraph.Edge> neighbors(int from) {
        return graph.neighbors(from);
    }

    public static void main(String[] args) {
        WeightedUndigraph graph = new WeightedUndigraph();
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // true

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " <-> " + edge.to + ", wight: " + edge.weight);
        });
        // 2 <-> 0, wight: 3
        // 2 <-> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
        System.out.println(graph.hasEdge(1, 0)); // false
    }

}
