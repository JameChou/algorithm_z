package graph;

import java.util.Map;

import graph.GraphAdjMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 使用邻接表来实现图的结构
 */
public class GraphAdjList {
    /**
     * 顶点
     */
    static class Vertex {
        private Integer value;

        public Vertex(int value) {
            this.value = value;
        }

        public Vertex() {
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    // 邻接表
    private Map<Vertex, List<Vertex>> adjList;

    /**
     * 默认的构造函数
     *
     * @param edges 边的关系
     */
    public GraphAdjList(Vertex[][] edges) {
        if (edges == null) {
            return;
        }

        this.adjList = new HashMap<>();

        for (Vertex[] edge : edges) {
            // 添加顶点
            addVertice(edge[0]);
            addVertice(edge[1]);

            // 添加两个顶点的边
            addEdge(edge[0], edge[1]);
        }
    }

    /**
     * 添加顶点
     *
     * @param vertex 顶点数据对象
     */
    public void addVertice(Vertex vertex) {
        if (adjList.containsKey(vertex)) {
            return;
        }

        List<Vertex> vertices = new ArrayList<>();
        adjList.put(vertex, vertices);
    }

    /**
     * 获得当前表的大小
     */
    public int size() {
        return this.adjList.size();
    }

    /**
     * 添加边的关系，现在是使用链表来实现的，所以这里的数据要注意两边都需要进行添加操作
     *
     * @param v1 顶点1
     * @param v2 顶点2
     *
     * @throws IllegalArgumentException 如果现在表中已经没有这个顶点了，则会地抛出这个Exception
     */
    public void addEdge(Vertex v1, Vertex v2) {
        // 判断一些异常参数
        if (v1 == null || v2 == null || !adjList.containsKey(v1) || !adjList.containsKey(v2)) {
            throw new IllegalArgumentException();
        }

        // 添加边的关系到链表中去
        if (!adjList.get(v1).contains(v2)) {
            adjList.get(v1).add(v2);
        }
        if (!adjList.get(v2).contains(v1)) {
            adjList.get(v2).add(v1);
        }
    }

    /**
     * 删除一个顶点
     *
     * @param vertex
     */
    public void removeVertice(Vertex vertex) {
        if (!adjList.containsKey(vertex)) {
            return;
        }

        List<Vertex> edges = adjList.get(vertex);
        // 删除其他的顶点
        for (Vertex v : edges) {
            adjList.get(v).remove(vertex);
        }

        // 删除这个顶点
        adjList.remove(vertex);
    }

    /**
     * 删除边
     * 
     * @param v1 边的顶点1
     * @param v2 边的顶点2
     *
     * @throws IllegalArgumentException 如果传入的两个参数为null，或现在adjList当中没有这个顶点则会向外抛出传参错误的Exception
     */
    public void removeEdge(Vertex v1, Vertex v2) {
        if (v1 == null || v2 == null || !adjList.containsKey(v1) || !adjList.containsKey(v2)) {
            throw new IllegalArgumentException();
        }

        // 从两个表中将两个顶点删除
        adjList.get(v1).remove(v2);
        adjList.get(v2).remove(v1);
    }

    /**
     * 简单的打印数据
     */
    public void print() {
        for (Map.Entry<Vertex, List<Vertex>> entry : this.adjList.entrySet()) {
            Vertex key = entry.getKey();

            System.out.print(key.getValue() + "\t -> ");

            for (Vertex v : entry.getValue()) {
                System.out.print(v.getValue() + "  ");
            }

            System.out.println();
        }
    }

    // 测试主函数
    public static void main(String[] args) {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(5);
        Vertex vertex3 = new Vertex(-4);
        Vertex vertex4 = new Vertex(6);
        Vertex vertex5 = new Vertex(7);

        Vertex[][] edges = { { vertex1, vertex2 }, { vertex1, vertex3 }, { vertex1, vertex4 },
                { vertex2, vertex4 }, { vertex2, vertex5 }, { vertex3, vertex4 },
                { vertex4, vertex5 } };

        GraphAdjList graphList = new GraphAdjList(edges);
        graphList.print();

        graphList.removeVertice(vertex1);
        System.out.println("after remove vertex1 -> 1");
        graphList.print();

        graphList.removeEdge(vertex2, vertex4);
        System.out.println("after remove edge vertex2 and vertex4, 5 & 6");
        graphList.print();

    }

}
