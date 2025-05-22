package struct.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/**
 * 层优先进行遍历，也称广度优先遍历也称广度优先搜索
 *
 * @link https://www.hello-algo.com/chapter_tree/binary_tree_traversal/
 */
public class BinaryTreeLevelOrder {
    static class BinaryTree {
        public int val;
        public BinaryTree left;
        public BinaryTree right;
        // 节点所在深度
        public int depth;

        public BinaryTree(int val) {
            this.val = val;
            right = left = null;
        }

        public BinaryTree() {
            right = left = null;
        }

        public BinaryTree(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }

    BinaryTree root;

    public BinaryTreeLevelOrder(BinaryTree root) {
        this.root = root;
    }

    /**
     * 方法一这种形式
     *
     * 这种方法的缺点是无法得到当前这个节点是在哪个层级
     *
     * @return 按照层序优先的去遍历完的列表
     */
    public List<BinaryTree> levelOrder() {
        Queue<BinaryTree> queue = new LinkedList<>();
        List<BinaryTree> nodesByLevelOrder = new ArrayList<>();

        queue.add(this.root);

        // 使用队列去进行层优先遍历
        while (!queue.isEmpty()) {
            BinaryTree bt = queue.poll();
            nodesByLevelOrder.add(bt);

            if (bt.left != null) {
                queue.add(bt.left);
            }
            if (bt.right != null) {
                queue.add(bt.right);
            }
        }

        return nodesByLevelOrder;
    }

    /**
     * 方法二
     *
     * 这个方法对方法一进行改造了，可以得到层级
     *
     * @return 遍历完的节点
     */
    public List<BinaryTree> levelOrder2() {
        Queue<BinaryTree> queue = new LinkedList<>();

        List<BinaryTree> rtnList = new ArrayList<>();
        // 将根节点加入到队列中
        queue.offer(root);

        int depth = 1;
        // 对节点进行遍历操作
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BinaryTree bt = queue.poll();
                bt.depth = depth;

                rtnList.add(bt);

                if (bt.left != null) {
                    queue.add(bt.left);
                }

                if (bt.right != null) {
                    queue.add(bt.right);
                }

            }

            depth++;

        }

        return rtnList;
    }

    public static void main(String[] args) {
        // 构建一个二叉树进行测试
        BinaryTree root = new BinaryTree(0);

        BinaryTree node1 = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        root.left = node1;
        root.right = node2;
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        node1.left = node3;
        node2.right = node4;

        BinaryTreeLevelOrder order = new BinaryTreeLevelOrder(root);
        List<BinaryTree> lists = order.levelOrder();
        for (BinaryTree bt : lists) {
            System.out.print(bt.val + " ");
        }
        System.out.println();

        lists = order.levelOrder2();
        for (BinaryTree bt : lists) {
            System.out.print(bt.val + " " + ", depth: " + bt.depth + "    ");
        }

    }
}
