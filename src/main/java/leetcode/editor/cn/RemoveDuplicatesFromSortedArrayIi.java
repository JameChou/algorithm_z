
package leetcode.editor.cn;

public class RemoveDuplicatesFromSortedArrayIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int left = 0, right = 1;
            // TODO: 还没有解决这个问题
            int count = 1;
            while (right < nums.length) {
                if (nums[left] == nums[right]) {
                    count++;
                }
            }

            return -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
        // put your test code here

        int[] nums = { 1, 1, 2, 2, 3 };
        int arrayLength = solution.removeDuplicates(nums);
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }
}
