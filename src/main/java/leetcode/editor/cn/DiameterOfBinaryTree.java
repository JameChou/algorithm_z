
package leetcode.editor.cn;

import leetcode.editor.common.TreeNode;

public class DiameterOfBinaryTree {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return maxDiameter;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            int myDiameter = left + right;
            maxDiameter = Math.max(maxDiameter, myDiameter);

            return 1 + Math.max(left, right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        // put your test code here
        Integer[] nums = { 1, 2, 3, 4, 5 };
        TreeNode root = TreeNode.createRoot(nums);
        solution.diameterOfBinaryTree(root);
        System.out.println(solution.maxDiameter);

    }
}
