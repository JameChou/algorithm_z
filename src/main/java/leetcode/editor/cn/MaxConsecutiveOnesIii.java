
package leetcode.editor.cn;

/**
 * 1004最大连续1的个数
 *
 * https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 *
 * 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
 * 
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 */
public class MaxConsecutiveOnesIii {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0, right = 0;
            int window = 0, res = Integer.MIN_VALUE;
            // 这里的核心思想是将 0 直接看作为1
            while (right < nums.length) {
                if (nums[right] == 1) {
                    window++;
                }

                right++;

                // 一直缩减到需要替换的值 < k就可以了
                while (right - left - window > k) {
                    if (nums[left] == 1) {
                        window--;
                    }

                    left++;
                }
                res = Math.max(res, right - left);
            }

            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
        // put your test code here

        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        // output -> 6
        System.out.println(solution.longestOnes(nums, k));
    }
}
