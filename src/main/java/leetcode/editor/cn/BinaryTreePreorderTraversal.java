
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            if (root == null) {
                return result;
            }

            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));

            return result;
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
