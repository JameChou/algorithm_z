package tree;

import java.util.List;
import java.util.ArrayList;

public class AVLTree {
    static class Node {
        private Integer value;
        private int height;
        private Node left;
        private Node right;

        public Node(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    private Node root;

    public AVLTree(Node root) {
        this.root = root;
    }

    public AVLTree() {
    }

    /**
     * 获得节点高度
     *
     * @param node 需要获得的节点高度
     */
    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    /**
     * 更新某个节点的高度
     *
     * @param node 需要更新的节点
     */
    private void updateHeight(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    /**
     * 获得某个节点的平衡因子
     *
     * @param node 需要获得平衡因子的那个节点
     * @return 平衡因子
     */
    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    /**
     * 左旋，冲突的左孩变右孩
     *
     * @param node 需要旋转的节点
     * @return 旋转后新的节点指针
     */
    private Node leftRotate(Node node) {
        if (node == null) {
            return null;
        }

        Node child = node.right;
        Node grandChild = child.left;

        child.left = node;
        node.right = grandChild;

        updateHeight(node);
        updateHeight(child);

        return child;
    }

    /**
     * 右旋：冲突的右孩变左孩
     *
     * @param node 需要右旋的节点
     * @return 新的节点
     */
    private Node rightRotate(Node node) {
        if (node == null) {
            return null;
        }

        Node child = node.left;
        Node grandChild = child.right;

        child.right = node;
        node.left = grandChild;

        updateHeight(node);
        updateHeight(child);

        return child;
    }

    /**
     * 旋转节点保证整棵树平衡
     *
     * @param node 需要旋转的节点
     * @return 旋转平衡后的节点指针用于更新
     */
    private Node rotate(Node node) {
        // 获取节点 node 的平衡因子
        int balanceFactor = balanceFactor(node);
        // 左偏树 L型
        if (balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                // LL型
                // 右旋
                return rightRotate(node);
            } else {
                // LR型
                // 先左旋后右旋
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        // 右偏树 R型
        if (balanceFactor < -1) {
            if (balanceFactor(node.right) <= 0) {
                // RR型
                // 左旋
                return leftRotate(node);
            } else {
                // RL型
                // 先右旋后左旋
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        // 平衡树，无须旋转，直接返回
        return node;

    }

    /**
     * 插入某个节点
     *
     * @param val 需要插入的值
     */
    public void insert(int val) {
        this.root = insertHelper(root, val);
    }

    private Node insertHelper(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (val > node.value) {
            node.right = insertHelper(node.right, val);
        } else if (val < node.value) {
            node.left = insertHelper(node.left, val);
        } else {
            return node;
        }

        updateHeight(node);
        node = rotate(node);

        return node;
    }

    public void remove(int val) {
        this.root = removeHelper(root, val);
    }

    private Node removeHelper(Node node, int val) {
        if (node == null) {
            return null;
        }

        if (node.value > val) {
            node.left = removeHelper(node.left, val);
        } else if (node.value < val) {
            node.right = removeHelper(node.right, val);
        } else {
            // 叶子节点的数量 < 2
            if (node.left == null || node.right == null) {
                Node child = node.left != null ? node.left : node.right;

                if (child == null) {
                    // 没有任何子树
                    return null;
                } else {
                    // 更新节点为child
                    // 子节点 == 1 的时候，把原来的节点更新为最新的节点
                    node = child;
                }
            } else {
                // 节点==2
                // 现在这个右节点相当于新的root节点了
                // 在右节点中使用中序去查找到最小值
                Node temp = node.right;

                while (temp.left != null) {
                    temp = temp.left;
                }

                // 需要删除右侧的节点最小值
                node.right = removeHelper(node.right, temp.value);
                // 更新这个节点的值为找到值相当于替换
                node.value = temp.value;
            }
        }

        updateHeight(node);
        node = rotate(node);
        return node;
    }

    public void preOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        values.add(node.value);
        preOrder(node.left, values);
        preOrder(node.right, values);
    }

    public void inOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inOrder(node.left, values);
        values.add(node.value);
        inOrder(node.right, values);
    }

    public void lastOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        lastOrder(node.left, values);
        lastOrder(node.right, values);
        values.add(node.value);
    }

    // 查找
    public boolean search(Integer value) {
        if (value == null) {
            return false;
        }

        Node temp = this.root;

        while (temp != null) {
            if (temp.value < value) {
                temp = temp.right;
            } else if (temp.value > value) {
                temp = temp.left;
            } else {
                return true;
            }
        }

        return false;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Node root = new Node(14);

        tree.setRoot(root);
        tree.insert(9);
        tree.insert(5);
        tree.insert(17);
        tree.insert(11);
        tree.insert(12);
        tree.insert(7);
        tree.insert(19);
        tree.insert(16);
        tree.insert(27);

        List<Integer> values = new ArrayList<>();
        tree.inOrder(tree.root, values);

        // 中序遍历
        System.out.println("中序遍历");
        for (Integer a : values) {
            System.out.print(a + " ");
        }
        System.out.println();

        values = new ArrayList<>();
        tree.preOrder(tree.root, values);
        System.out.println("前序遍历");
        for (Integer a : values) {
            System.out.print(a + " ");
        }

        System.out.println();

    }
}
