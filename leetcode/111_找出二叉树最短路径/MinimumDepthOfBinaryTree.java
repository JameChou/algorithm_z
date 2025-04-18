import java.util.Queue;
import java.util.LinkedList;

public class MinimumDepthOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 最小深度
    private int resultMinDepth = Integer.MAX_VALUE, depth = 1;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // dsf(root);
        int depth = bsf(root);

        return depth;
    }

    /**
     * 使用BSF的方式去拿到某个树的是最短路径
     */
    private int bsf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 1, rtnDepth = Integer.MAX_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    rtnDepth = Math.min(rtnDepth, depth);
                    continue;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }

        return rtnDepth;

    }

    /**
     * 这个方法是DSF去解决树的最小深度是多少，但是使用dsf这种方式并不是最优解
     *
     * 需要将所有的节点全部遍历一遍才可以得到最终的值
     */
    private void dsf(TreeNode root) {
        if (root == null) {
            return;
        }

        // 说明已经遍历到叶子节点了
        if (root.left == null && root.right == null) {
            resultMinDepth = Math.min(resultMinDepth, depth);
            return;
        }

        depth++;
        dsf(root.left);
        dsf(root.right);

        depth--;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        root.left = nine;
        root.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        MinimumDepthOfBinaryTree bt = new MinimumDepthOfBinaryTree();
        bt.minDepth(root);
        System.out.println(bt.resultMinDepth);
    }

}
