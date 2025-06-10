
package leetcode.editor.cn;

import java.util.*;

public class TwoSum {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Num {
        int index;
        int value;

        public Num(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Num[] list = new Num[nums.length];
            for (int i = 0; i < nums.length; i++) {
                list[i] = new Num(i, nums[i]);
            }

            Arrays.sort(list, (a, b) -> a.value - b.value);
            int left = 0, right = list.length - 1;
            while (left <= right) {
                int result = list[left].value + list[right].value;
                if (result == target) {
                    return new int[] { list[left].index, list[right].index };
                } else if (result < target) {
                    left++;
                } else {
                    right--;
                }
            }

            return null;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // put your test code here

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
