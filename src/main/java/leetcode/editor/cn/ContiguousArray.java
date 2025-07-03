
package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 示例：
 * 
 * 输入：nums = [0,1,1,1,1,1,0,0,0]
 * 输出：6
 * 解释：[1,1,1,0,0,0] 是具有相同数量 0 和 1 的最长连续子数组。
 */
public class ContiguousArray {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            // 计算 nums 的前缀和
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
            }

            // 前缀和到索引的映射，方便快速查找所需的前缀和
            HashMap<Integer, Integer> valToIndex = new HashMap<>();
            int res = 0;
            for (int i = 0; i < preSum.length; i++) {
                // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
                if (!valToIndex.containsKey(preSum[i])) {
                    valToIndex.put(preSum[i], i);
                } else {
                    // 这个前缀和已经出现过了，则找到一个和为 0 的子数组
                    res = Math.max(res, i - valToIndex.get(preSum[i]));
                }
                // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ContiguousArray().new Solution();
        // put your test code here

        int[] nums = { 1, 1, 1, 1, 1, 1, 0, 0, 0 };
        int result = solution.findMaxLength(nums);
        System.out.println(result);
    }
}
