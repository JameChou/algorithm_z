
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 219
 * 存在重复元素
 *
 * https://leetcode.cn/problems/contains-duplicate-ii/description/
 *
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i
 * - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 *
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 */
public class ContainsDuplicateIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> window = new HashSet<>();
            int left = 0, right = 0;
            while (right < nums.length) {
                if (window.contains(nums[right])) {
                    return true;
                }

                window.add(nums[right]);
                right++;
                // 始终维护一个大小为k的窗口
                while (right - left > k) {
                    window.remove(nums[left]);
                    left++;
                }

            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        // put your test code here

        // test case 1
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        boolean result = solution.containsNearbyDuplicate(nums, k);
        System.out.println(result);

        int[] nums2 = { 1, 2, 3, 1, 2, 3 };
        k = 2;
        result = solution.containsNearbyDuplicate(nums2, k);
        System.out.println(result);

        int[] nums3 = { 1, 0, 1, 1 };
        k = 1;
        result = solution.containsNearbyDuplicate(nums3, k);
        System.out.println(result);

        int[] nums4 = { 99, 99 };
        k = 2;
        result = solution.containsNearbyDuplicate(nums4, k);
        System.out.println(result);

    }
}
