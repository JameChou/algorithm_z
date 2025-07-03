
package leetcode.editor.cn;

import leetcode.editor.common.TreeNode;

/**
 * leetcode 104
 * 二叉树的最大深度
 *
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 */
public class MaximumDepthOfBinaryTree {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int deepth = 0, max = Integer.MIN_VALUE;

        public void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            deepth++;
            max = Math.max(deepth, max);
            traverse(root.left);
            traverse(root.right);
            deepth--;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            traverse(root);
            return max;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        // put your test code here
        Integer[] nums = { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = TreeNode.createRoot(nums);

        int deepth = solution.maxDepth(root);
        System.out.println(deepth);

    }
}
