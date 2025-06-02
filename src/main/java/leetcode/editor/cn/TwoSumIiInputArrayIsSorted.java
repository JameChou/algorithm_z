
package leetcode.editor.cn;

import java.util.*;

/**
 * 数组是升序进行排列的
 */
public class TwoSumIiInputArrayIsSorted {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[] { left + 1, right + 1 };
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }

            return new int[] { -1, -1 };
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        // put your test code here

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
