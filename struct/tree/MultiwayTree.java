package tree;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class MultiwayTree<V> {
    static class Node<V> {
        V val;
        // 子集
        List<Node<V>> children;

        public Node(V val) {
            this.val = val;
        }

        public Node(V val, List<Node<V>> children) {
            this.val = val;
            this.children = children;
        }

        public Node() {
        }
    }

    /**
     * 深度优先遍历
     *
     * @root 根节点
     *
     */
    public void dfs(Node<V> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        if (root.children == null || root.children.isEmpty()) {
            return;
        }

        // 如果子串不为空的情况下，再进行遍历将所有的数据打印出来
        for (int i = 0; i < root.children.size(); i++) {
            Node<V> node = root.children.get(i);
            // System.out.print(node.val + " ");

            dfs(node);
        }
    }

    /**
     * 广度优先遍历
     *
     * 这是第一种写法，无法记录节点的深度
     * 
     * @root 根节点对象
     */
    public void bfs(Node<V> root) {
        if (root == null) {
            return;
        }

        Queue<Node<V>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<V> node = queue.poll();
            System.out.print(node.val + " ");

            if (node.children == null || node.children.isEmpty()) {
                continue;
            }

            for (int i = 0; i < node.children.size(); i++) {
                queue.offer(node.children.get(i));
            }
        }
    }

    /**
     * 层序遍历的第二种写法，主要的目的是记录下深度信息
     *
     * @root 根节点
     */
    public void bfs2(Node<V> root) {
        if (root == null) {
            return;
        }

        Queue<Node<V>> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            // 每一层的先处理掉
            for (int i = 0; i < size; i++) {
                Node<V> node = queue.poll();

                System.out.println("depth == " + depth + ", val == " + node.val);

                if (node.children == null || node.children.size() == 0) {
                    continue;
                }
                for (Node<V> n : node.children) {
                    queue.offer(n);
                }
            }

            depth++;
        }

    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node11 = new Node<>(11);

        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node21 = new Node<>(21);
        Node<Integer> node22 = new Node<>(22);

        Node<Integer> node3 = new Node<>(3);

        List<Node<Integer>> children = new ArrayList<>();
        children.add(node1);
        children.add(node2);
        children.add(node3);
        root.children = children;

        List<Node<Integer>> children1 = new ArrayList<>();
        children1.add(node11);
        node1.children = children1;

        List<Node<Integer>> children2 = new ArrayList<>();
        children2.add(node21);
        children2.add(node22);
        node2.children = children2;

        new MultiwayTree<Integer>().dfs(root);

        System.out.println();
        new MultiwayTree<Integer>().bfs(root);

        System.out.println();
        new MultiwayTree<Integer>().bfs2(root);
    }

}
