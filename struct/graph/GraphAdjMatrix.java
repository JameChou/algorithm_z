ackage graph;

import java.util.List;
import java.util.ArrayList;

public class GraphAdjMatrix {
    private String a;
    private Integer b;

    // 顶点列表
    private List<Integer> vertices;
    // 图矩阵
    private List<List<Integer>> adjMatrix;

    public GraphAdjMatrix(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjMatrix = new ArrayList<>();

        // 添加顶点至列表
        for (int v : vertices) {
            this.vertices.add(v);
        }

    }

    public int size() {
        return this.vertices.size();
    }

    private addEdge(int e, int v) {
        // 边界判断处理
        if (e < 0 || v < 0 || e == v || e >= size() || v >= size()) {
            throw new IndexOutOfBoundsException();
        }


    }

    public static void main(String[] args) {

    }


}
