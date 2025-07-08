
package leetcode.editor.cn;

/**
 * leetcode 1658
 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/
 *
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要
 * 修改 数组以供接下来的操作使用。
 * 
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 *
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 */
public class MinimumOperationsToReduceXToZero {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            int left = 0, right = 0, n = nums.length, sum = 0;
            // 先算得这里的所有的元素和
            for (int s : nums) {
                sum += s;
            }

            // 滑动窗口应该算的窗口数据
            int target = sum - x;
            int window = 0, maxLen = Integer.MIN_VALUE;
            while (right < n) {
                window += nums[right];
                right++;

                while (window > target && left < right) {
                    window -= nums[left];
                    left++;
                }

                // 如果这时候窗口的数据与target的时候那么表示剩下的和就与x相等
                // 这里我们需要注意不能使用break，因为break之后可能不是最大的
                // 我们必须使用最长的长度，因为这才能求出最短的头尾
                if (window == target) {
                    maxLen = Math.max(maxLen, right - left);
                    // break;
                }
            }

            return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceXToZero().new Solution();
        // put your test code here

        int[] nums = { 1, 1, 4, 2, 3 };
        int x = 5;
        int result = solution.minOperations(nums, x);
        System.out.println(result);

        int[] nums2 = { 5, 2, 3, 1, 1 };
        x = 5;
        result = solution.minOperations(nums2, x);
        System.out.println(result);
    }
}
