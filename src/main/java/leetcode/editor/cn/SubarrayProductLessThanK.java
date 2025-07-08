
package leetcode.editor.cn;

/**
 * leetcode 713
 * https://leetcode.cn/problems/subarray-product-less-than-k/
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * 
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 *
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 */
public class SubarrayProductLessThanK {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int left = 0, right = 0, window = 1;
            int count = 0;
            while (right < nums.length) {
                window *= nums[right];
                right++;

                while (window >= k && left < right) {
                    window /= nums[left];
                    left++;
                }

                // 这里都是符合要求的数据
                count = count + (right - left);
            }
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        // put your test code here
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;

        int result = solution.numSubarrayProductLessThanK(nums, k);
        System.out.println(result);

        int[] nums1 = { 1, 2, 3 };
        k = 0;
        result = solution.numSubarrayProductLessThanK(nums1, k);
        System.out.println(result);
    }
}
