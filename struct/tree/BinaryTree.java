public class BinaryTree {
    // 数据
    int val;
    // 左侧节点的指针
    BinaryTree left;
    // 右侧节点的指针
    BinaryTree right;

    public BinaryTree(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);

        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
    }
}
