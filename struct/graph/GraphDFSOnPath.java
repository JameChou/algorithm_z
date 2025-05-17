package graph;

import java.util.List;
import java.util.ArrayList;

public class GraphDFSOnPath {
    private Graph graph;

    public GraphDFSOnPath() {
    }

    public GraphDFSOnPath(Graph graph) {
        this.graph = graph;
    }

    List<Integer> path;
    boolean[] onPathCheck;

    /**
     * 得到一个节点到另一个节点的所有路径
     *
     * @param graph       图
     * @param src         源节点
     * @param onPathCheck 标记已经访问过的节点
     */
    public void onPath(Graph graph, int src, int dest) {
        // 递归的边界判断
        if (graph == null || src < 0 || src >= graph.size()) {
            return;

        }

        // 防止死循环已经标记过访问过的节点返回return
        if (onPathCheck[src]) {
            return;
        }
        onPathCheck[src] = true;
        path.add(src);
        if (src == dest) {
            System.out.println("path found: " + path);
        }

        for (Graph.Edge edge : graph.neighbors(src)) {
            onPath(graph, edge.to, dest);
        }

        // 注意这里的这个方法，remove只是这里指定的index下的元素
        // 所以我们需要将这个列表的最后一个元素给删除
        path.remove(path.size() - 1);
        onPathCheck[src] = false;
    }

    public static void main(String[] args) {
        GraphDFSOnPath onPathGraph = new GraphDFSOnPath();

        // 创建图的对象
        Graph graph = new WeightedDigraph();

        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);
        onPathGraph.setGraph(graph);

        List<Integer> path = new ArrayList<>();
        onPathGraph.setPath(path);
        boolean[] onPathCheck = new boolean[graph.size()];

        for (int i = 0; i < onPathCheck.length; i++) {
            onPathCheck[i] = false;
        }
        onPathGraph.setOnPathCheck(onPathCheck);
        onPathGraph.onPath(graph, 2, 0);
    }

    public List<Integer> getPath() {
        return path;
    }

    public void setPath(List<Integer> path) {
        this.path = path;
    }

    public boolean[] getOnPathCheck() {
        return onPathCheck;
    }

    public void setOnPathCheck(boolean[] onPath) {
        this.onPathCheck = onPath;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }
}
