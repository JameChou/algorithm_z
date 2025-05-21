package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对于图的广度优先算法
 */
public class GraphBFS {
    //
    Graph graph;

    /**
     * 普通的广度优先遍历
     *
     * @param graph 图
     * @param s     起始点位置
     */
    public void method1(Graph graph, int s) {
        // 获得当前的图的大小用于后面初始化访问的数组
        int size = graph.size();

        boolean visited[] = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        visited[s] = true;
        while (!queue.isEmpty()) {
            int nodeValue = queue.poll();
            // 访问节点
            System.out.print(nodeValue + " ");

            // 与多叉树进行对比可知，这里的区别就在于我们需要记录下这个边(节点)是否已经被访问过了。
            for (Graph.Edge edge : graph.neighbors(nodeValue)) {
                if (visited[edge.to]) {
                    continue;
                }

                queue.offer(edge.to);
                visited[edge.to] = true;
            }
        }
    }

    /**
     * 方法二
     * 
     * 这个方法主要是用于对图进行广度优先的遍历方式同时可以记录用到的步数。
     */
    public void method2(Graph graph, int s) {
        boolean visited[] = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(s);

    }

    public void method3() {

    }

    public static void main(String[] args) {

    }

}
