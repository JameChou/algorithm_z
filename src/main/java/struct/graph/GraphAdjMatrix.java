package struct.graph;

import struct.utils.PrintUtil;

import java.util.List;
import java.util.ArrayList;

/**
 * 使用邻接矩阵来实现图的数据结构
 */
public class GraphAdjMatrix {

    // 顶点列表
    private List<Integer> vertexs;
    // 图矩阵
    private List<List<Integer>> adjMatrix;

    /**
     * 默认的构造函数，传入的两个值一个顶点的列表，一个为连接的关系
     *
     * @param vertexs 顶点列表
     * @param edges   边之间的关系
     */
    public GraphAdjMatrix(int[] vertexs, int[][] edges) {
        this.vertexs = new ArrayList<>();
        this.adjMatrix = new ArrayList<>();

        // 添加顶点至列表
        for (int v : vertexs) {
            addVertex(v);
        }

        // 添加边连接的数据到列表中
        for (int e[] : edges) {
            addEdge(e[0], e[1]);
        }

    }

    /**
     * 获得现在表的大小
     *
     * @return 大小值
     */
    public int size() {
        return this.vertexs.size();
    }

    /**
     * 添加顶点
     *
     * @param value 顶点值
     */
    public void addVertex(int value) {
        int n = size();

        vertexs.add(value);
        List<Integer> newRow = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newRow.add(0);
        }

        adjMatrix.add(newRow);
        for (List<Integer> row : adjMatrix) {
            row.add(0);
        }
    }

    /**
     * 添加处理数组边的信息
     *
     * @param i 横边
     * @param j 竖边
     */
    public void addEdge(int i, int j) {
        // 边界判断处理
        // 注意中间的判断i == j即对角线位置都应该是0，不应该做任何处理
        if (i < 0 || j < 0 || i == j || i >= size() || j >= size()) {
            throw new IndexOutOfBoundsException();
        }

        adjMatrix.get(i).set(j, 1);
        adjMatrix.get(j).set(i, 1);
    }

    /**
     * 删除顶点
     *
     * @param index 删除顶点的坐标
     */
    public void removeVertex(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        vertexs.remove(index);
        adjMatrix.remove(index);

        // 有关的所有边对应的index都需要remove掉
        for (List<Integer> row : adjMatrix) {
            row.remove(index);
        }
    }

    /**
     * 删除边，因为我们是使用1 或 0来表示两个顶点是否有边连通，所以这里只需要更新边为0就可以了
     *
     * @param i 横边坐标
     * @param j 竖边坐标
     */
    public void removeEdge(int i, int j) {
        if (i < 0 || j < 0 || i == j || i >= size() || j >= size()) {
            throw new IndexOutOfBoundsException();
        }

        // 将边数据更新为0就是表示删除了这个边
        adjMatrix.get(i).set(j, 0);
        adjMatrix.get(j).set(i, 0);
    }

    public static void main(String[] args) {
        // 顶点数组
        int[] vertexs = { 1, 5, -4, 6, 7 };
        // 边二维数组
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 0 }, { 1, 3 }, { 1, 4 }, { 2, 0 }, { 2, 3 }, { 3, 4 } };

        // 测试打印最终形成的matrix
        GraphAdjMatrix matrix = new GraphAdjMatrix(vertexs, edges);
        PrintUtil.printMatrix(matrix.adjMatrix);
    }

}
