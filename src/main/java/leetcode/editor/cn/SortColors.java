
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 对颜色进行排序
 * leetcode 75
 * https://leetcode.cn/problems/sort-colors/
 *
 * 输入: nums = [2, 0, 2, 1, 1, 0]
 * 输出: nums = [0, 0, 1, 1, 2, 2]
 *
 */
public class SortColors {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            bubbleSort(nums);
        }

        public void bubbleSort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                boolean hasSwap = false;
                for (int j = 0; j < nums.length - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        hasSwap = true;
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }

                if (!hasSwap) {
                    break;
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        // put your test code here

        int[] nums = { 2, 0, 2, 1, 1, 0 };

        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
