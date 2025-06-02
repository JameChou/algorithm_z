
package leetcode.editor.cn;

import java.util.*;

public class SquaresOfASortedArray {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] result = new int[nums.length];

            int left = 0, right = nums.length - 1;
            int index = nums.length - 1;
            // 两个指针相遇的时候则表示需要跳出循环
            while (left <= right) {
                int leftNumber = nums[left] * nums[left];
                int rightNumber = nums[right] * nums[right];

                if (rightNumber > leftNumber) {
                    result[index] = rightNumber;
                    right--;
                } else {
                    result[index] = leftNumber;
                    left++;
                }
                index--;
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        // put your test code here
        int[] nums = { -4, -1, 0, 3, 10 };
        int[] result = solution.sortedSquares(nums);

        System.out.println(Arrays.toString(result));
    }
}
