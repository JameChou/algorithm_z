
package leetcode.editor.cn;

public class RangeSumQueryImmutable {

    // leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        private int[] preSums;

        public NumArray(int[] nums) {
            preSums = new int[nums.length + 1];
            // 计算[0 - i] 之间的值
            for (int i = 1; i < preSums.length; i++) {
                preSums[i] = preSums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSums[right + 1] - preSums[left];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {

    }
}
