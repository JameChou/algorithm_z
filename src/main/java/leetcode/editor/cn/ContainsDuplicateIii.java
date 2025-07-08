
package leetcode.editor.cn;

import java.util.TreeSet;

/**
 * leetcode 220
 * https://labuladong.online/algo/problem-set/sliding-window/#slug_contains-duplicate-iii
 *
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 * 
 * 找出满足下述条件的下标对 (i, j)：
 * 
 * i != j,
 * abs(i - j) <= indexDiff
 * abs(nums[i] - nums[j]) <= valueDiff
 * 
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 
 * 输入：nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
 * 输出：true
 * 解释：可以找出 (i, j) = (0, 3) 。
 * 满足下述 3 个条件：
 * i != j --> 0 != 3
 * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
 * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
 * 
 * 输入：nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
 * 输出：false
 * 解释：尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。
 */
public class ContainsDuplicateIii {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            int left = 0, right = 0;
            TreeSet<Integer> window = new TreeSet<>();
            while (right < nums.length) {
                int current = nums[right];
                // 取出比current略大的那个数
                Integer ceiling = window.ceiling(current);
                if (ceiling != null && ceiling - current <= valueDiff) {
                    return true;
                }

                // 取出比current略小的一个数
                Integer floor = window.floor(current);
                if (floor != null && current - floor <= valueDiff) {
                    return true;
                }

                window.add(current);
                right++;

                // 维护一个长度 <= indexDiff的窗口
                while (right - left > indexDiff) {
                    window.remove(nums[left]);
                    left++;
                }

            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        // put your test code here

        int[] nums = { 1, 2, 3, 1 };
        int indexDiff = 3, valueDiff = 0;
        boolean result = solution.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
        System.out.println(result);
    }
}
