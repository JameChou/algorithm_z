package tree;

import java.util.List;
import java.util.ArrayList;

public class GraphAdjacencyMatrix {

    // 顶点的列表相当于索引
    private List<Integer> vertices;
    // 邻接矩阵表
    private List<List<Integer>> adjMatrix;

    /**
     * 构造方法，初始化的时候去构造顶点以及邻接的矩阵表
     *
     * @param vertices 顶点数组表
     * @param matrix   邻接表，使用二维数组进行表示
     */
    public GraphAdjacencyMatrix(int vertices[], int matrix[][]) {
        this.vertices = new ArrayList<Integer>(vertices.length);
        for (int v : vertices) {
            this.vertices.add(v);
        }

        for (int arr[] : matrix) {

        }
    }

    /**
     * 添加边到邻接矩阵中
     */
    public void addEdge(int i, int j) {
    }

    // 测试主方法
    public static void main(String[] args) {
    }
}
