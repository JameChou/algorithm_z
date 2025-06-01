
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 将数组中的0元素移至末尾，其他非0元素保持相对位置
 *
 * 283题
 */
public class MoveZeroes {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0, fast = slow;

            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }

                fast++;
            }

            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // put your test code here
        int[] nums = { 0, 1, 0, 3, 12 };
        solution.moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        // 1, 3, 12, 0, 0
        System.out.println();
    }
}
