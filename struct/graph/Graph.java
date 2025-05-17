package graph;

import java.util.List;

public interface Graph {

    static class Edge {
        // 边指向的节点
        int to;
        // 权重
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public Edge() {
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }
    }

    /**
     * 获得当前图的大小
     *
     * @return 图的大小
     */
    public int size();

    /**
     * 添加一条有权重的边
     *
     * @param from   起始点
     * @param to     指向的点
     * @param weight 权重
     */
    public void addEdge(int from, int to, int weight);

    /**
     * 添加一个无权重的边，这是为了实现有权重的类的时候可以不实现了这个方法
     *
     * @param from 开始的顶点
     * @param to   指向的点
     */
    public default void addEdge(int from, int to) {
        this.addEdge(from, to, 1);
    }

    /**
     * 删除一条边
     *
     * @param from 起始点
     * @param to   指向的点
     */
    public void removeEdge(int from, int to);

    /**
     * 获得一个边的权重
     *
     * @param from 起始点
     * @param to   指向的点
     *
     * @return 一条边的权重值
     */
    public int weight(int from, int to);

    /**
     * 获得这个边的所有邻居即所有的边
     *
     * @param from 图的点
     *
     * @return 所有的边列表
     */
    public List<Edge> neighbors(int from);

    /**
     * 判断是否有一个边
     *
     * @param from 起始点
     * @param to   指向的点
     * @return 是否存在边true->有边 false->无边
     */
    public boolean hasEdge(int from, int to);
}
