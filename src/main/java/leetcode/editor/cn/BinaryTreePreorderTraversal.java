
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import leetcode.editor.common.TreeNode;

/**
 * leetcode 144
 *
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 *
 * 求一个二叉树的前序遍历值
 *
 */
public class BinaryTreePreorderTraversal {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> list = new ArrayList<>();

        public void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            list.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            traverse(root);
            return list;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        // put your test code here

        Integer[] nums = { 1, null, 2, 3 };
        TreeNode root = TreeNode.createRoot(nums);
        List<Integer> result = solution.preorderTraversal(root);
        System.out.println(result.toString());
    }
}
