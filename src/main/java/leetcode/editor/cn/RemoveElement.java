
package leetcode.editor.cn;

/**
 * 移除数组中所有包含 val 的元素，返回移除后的数组大小 k
 */
public class RemoveElement {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }

            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }

            return slow;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        // put your test code here
        // int[] nums = {0,1,2,2,3,0,4,2 };
        int[] nums = { 3, 2, 2, 3 };
        int val = 3;

        int result = solution.removeElement(nums, val);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }
}
