
package leetcode.editor.cn;

/**
 * 原地删除数组中的重复元素
 *
 * 比如数组中的元素为 {1, 2, 2, 4, 5};
 * 去除重复之后数组应该为 {1, 2, 4, 5};
 */
public class RemoveDuplicatesFromSortedArray {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int slow = 0;
            int fast = slow + 1;

            while (fast < nums.length) {
                if (nums[slow] == nums[fast]) {
                    fast++;
                } else {
                    nums[++slow] = nums[fast];
                }
            }

            return slow + 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        // put your test code here
        int[] nums = { 1, 2, 2, 3 };
        int result = solution.removeDuplicates(nums);

        System.out.println(result);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
