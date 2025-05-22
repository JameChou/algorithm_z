package struct.graph;

/**
 * 深度优先遍历的方法
 */
public class GraphDFS {
    // 图的对象
    private Graph graph;

    public GraphDFS() {
    }

    /**
     * 深度优先遍历图
     *
     * @param graph   图
     * @param start   开始遍历的节点
     * @param visited 记录节点是否已经被遍历过
     */
    public void dfs(Graph graph, int start, boolean visited[]) {
        if (graph == null || start < 0 || start >= graph.size() || visited[start]) {
            return;
        }

        System.out.println("visited[" + start + "] -> true");
        visited[start] = true;

        for (Graph.Edge edge : graph.neighbors(start)) {
            dfs(graph, edge.to, visited);
        }
    }

    public static void main(String[] args) {
        GraphDFS graphDFS = new GraphDFS();

        // 创建图的对象
        Graph graph = new WeightedDigraph();

        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);
        graphDFS.setGraph(graph);
        boolean[] visited = { false, false, false };

        graphDFS.dfs(graph, 1, visited);
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
