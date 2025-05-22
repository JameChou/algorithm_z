package struct.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有向有权重的图使用邻接表去实现
 * 
 * 实现的方式其实也比较简单，使用map去实现，我们这里不需要去处理顶点
 */
public class WeightedDigraph implements Graph {

    Map<Integer, List<Edge>> adjList;

    @Override
    public int size() {
        return this.adjList.size();
    }

    /**
     * 构造方法，主要是为了初始化邻接表
     */
    public WeightedDigraph() {
        this.adjList = new HashMap<>();
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        List<Edge> edges = null;
        if (!adjList.containsKey(from)) {
            edges = new ArrayList<>();
        } else {
            edges = adjList.get(from);
        }

        for (Edge e : edges) {
            if (e.to == to) {
                e.weight = weight;
                return;
            }
        }

        Edge edge = new Edge(to, weight);
        edges.add(edge);
        adjList.put(from, edges);
    }

    @Override
    public void removeEdge(int from, int to) {
        if (!adjList.containsKey(from)) {
            throw new IllegalArgumentException();
        }

        for (Edge e : adjList.get(from)) {
            if (e.to == to) {
                adjList.get(from).remove(e);
                break;
            }
        }
    }

    @Override
    public int weight(int from, int to) {
        if (!adjList.containsKey(from)) {
            throw new IllegalArgumentException();
        }

        for (Edge e : adjList.get(from)) {
            if (e.to == to) {
                return e.weight;
            }
        }

        return -1;
    }

    @Override
    public boolean hasEdge(int from, int to) {
        if (!adjList.containsKey(from)) {
            throw new IllegalArgumentException();
        }

        for (Edge e : adjList.get(from)) {
            if (e.to == to) {
                return true;
            }
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Edge> neighbors(int from) {
        if (!adjList.containsKey(from)) {
            return Collections.EMPTY_LIST;
        }

        return adjList.get(from);
    }

    public static void main(String[] args) {
        WeightedDigraph graph = new WeightedDigraph();
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
