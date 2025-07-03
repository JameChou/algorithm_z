
package leetcode.editor.cn;

/**
 * 找到一个数组的中心点坐标
 *
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 */
public class FindPivotIndex {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 这个题是否可以简化成 [0, length - 1] - [0, pivotIndex] = [0, pivotIndex];
        // 先求各个区域的和长度
        public int pivotIndex(int[] nums) {
            // 先求前N个数的和
            int[] preSum = new int[nums.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = nums[i - 1] + preSum[i - 1];
            }

            int total = preSum[preSum.length - 1];
            for (int i = 1; i <= nums.length; i++) {
                int prePivotSum = preSum[i - 1];
                if (total - prePivotSum - nums[i - 1] == prePivotSum) {
                    return i - 1;
                }
            }

            return -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new FindPivotIndex().new Solution();
        // put your test code here

        int[] nums = { 2, 1, -1 };
        int result = solution.pivotIndex(nums);
        System.out.println(result);
    }
}
