package struct.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeDepthSearch {
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

    /**
     * 前序遍历，按照的顺序是中左右
     *
     * @param root  节点
     * @param lists 返回的列表
     */
    public void preOrder(BinaryTree root, List<BinaryTree> lists) {
        if (root == null) {
            return;
        }

        lists.add(root);
        preOrder(root.left, lists);
        preOrder(root.right, lists);
    }

    /**
     * 中序遍历
     *
     * 按照 左中右
     *
     * @param root  节点
     * @param lists 节点列表
     */
    public void inOrder(BinaryTree root, List<BinaryTree> lists) {
        if (root == null) {
            return;
        }

        inOrder(root.left, lists);
        lists.add(root);
        inOrder(root.right, lists);
    }

    /**
     * 后序遍历
     * 按照 左右中的顺序进行遍历
     *
     * @param root  节点
     * @param lists 列表
     */
    public void postOrder(BinaryTree root, List<BinaryTree> lists) {
        if (root == null) {
            return;
        }

        postOrder(root.left, lists);
        postOrder(root.right, lists);
        lists.add(root);
    }

    BinaryTree root;

    public BinaryTreeDepthSearch(BinaryTree root) {
        this.root = root;
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

        BinaryTreeDepthSearch search = new BinaryTreeDepthSearch(root);
        List<BinaryTree> preOrderLists = new ArrayList<>();
        search.preOrder(root, preOrderLists);

        List<BinaryTree> inOrderLists = new ArrayList<>();
        search.inOrder(root, inOrderLists);

        List<BinaryTree> postOrderLists = new ArrayList<>();
        search.postOrder(root, postOrderLists);

        for (BinaryTree bt : preOrderLists) {
            System.out.print(bt.val + " ");
        }
        System.out.println();

        for (BinaryTree bt : inOrderLists) {
            System.out.print(bt.val + " ");
        }
        System.out.println();

        for (BinaryTree bt : postOrderLists) {
            System.out.print(bt.val + " ");
        }
        System.out.println();
    }
}
