package tree;

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

        public BinaryTree(int val) {
            this.val = val;
            right = left = null;
        }

        public BinaryTree() {
            right = left = null;
        }
    }

    BinaryTree root;

    public BinaryTreeLevelOrder(BinaryTree root) {
        this.root = root;
    }

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
    }
}
