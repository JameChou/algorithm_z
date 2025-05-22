package struct.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeAllRoad<V> {
    static class TreeNode<V> {
        V val;
        TreeNode<V> left;
        TreeNode<V> right;

        public TreeNode(V val) {
            this.val = val;
        }

        public TreeNode(V val, TreeNode<V> left, TreeNode<V> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }
    }

    List<List<V>> list;
    Stack<V> stacks;

    public BinaryTreeAllRoad() {
        list = new ArrayList<>();
        stacks = new Stack<>();
    }

    public void dfsAllRoads(TreeNode<V> root) {
        if (root == null) {
            return;
        }

        stacks.push(root.val);
        if (root.left == null || root.right == null) {
            List<V> nodes = new ArrayList<>();

            int size = stacks.size();
            for (int i = 0; i < size; i++) {
                nodes.add(stacks.get(i));
            }
            list.add(nodes);
        }

        dfsAllRoads(root.left);
        dfsAllRoads(root.right);

        stacks.pop();

    }

    public List<List<V>> getList() {
        return this.list;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(0);

        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        root.left = node1;
        root.right = node2;
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        node1.left = node3;
        node2.right = node4;

        BinaryTreeAllRoad<Integer> btar = new BinaryTreeAllRoad<Integer>();
        btar.dfsAllRoads(root);
        for (List<Integer> nodeList : btar.getList()) {
            for (Integer e : nodeList) {
                System.out.print(e + " ");
            }

            System.out.println();
        }

    }
}
