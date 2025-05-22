package struct.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用邻接矩阵实现有权重的有向图
 *
 * <strong>注意如果权重为0的话就表示这个边不存在</strong>
 */
public class WeightedDigraphMatrix implements Graph {
    int matrix[][];

    public WeightedDigraphMatrix(int n) {
        this.matrix = new int[n][n];
    }

    public int size() {
        return this.matrix.length;
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        if (from >= matrix.length || to >= matrix.length || from < 0 || to < 0) {
            throw new IllegalArgumentException("Index out of bound.");
        }

        matrix[from][to] = weight;
    }

    @Override
    public void removeEdge(int from, int to) {
        if (from >= matrix.length || to >= matrix.length || from < 0 || to < 0) {
            throw new IllegalArgumentException("Index out of bound.");
        }

        matrix[from][to] = 0;
    }

    @Override
    public int weight(int from, int to) {
        if (from >= matrix.length || to >= matrix.length || from < 0 || to < 0) {
            throw new IllegalArgumentException("Index out of bound.");
        }

        return matrix[from][to];
    }

    @Override
    public boolean hasEdge(int from, int to) {
        if (from >= matrix.length || to >= matrix.length || from < 0 || to < 0) {
            throw new IllegalArgumentException("Index out of bound.");
        }

        return matrix[from][to] != 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Edge> neighbors(int from) {
        if (from >= matrix.length || from < 0) {
            throw new IllegalArgumentException();
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < matrix[from].length; i++) {
            if (matrix[from][i] == 0) {
                continue;
            }

            int weight = matrix[from][i];
            Edge edge = new Edge(i, weight);
            edges.add(edge);
        }

        return edges;
    }

    public static void main(String[] args) {
        WeightedDigraphMatrix graph = new WeightedDigraphMatrix(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // false

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.to + ", wight: " + edge.weight);
        });
        // 2 -> 0, wight: 3
        // 2 -> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
    }
}
