
package leetcode.editor.cn;

import java.util.*;

/**
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int target = 0;

            List<List<Integer>> tuple = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // target - nums[i] 可以得到两数之和
                List<List<Integer>> res = twoSum(nums, i + 1, target - nums[i]);
                for (List<Integer> sums : res) {
                    sums.add(nums[i]);
                    tuple.add(sums);
                }

                // 去除重复的数
                while (i < n - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }

            return tuple;
        }

        /**
         * 返回两数之和并且返回的元素数据不重复
         * 
         * @param nums   数组
         * @param target 需要计算的目标值
         * @return 数组对
         */
        public List<List<Integer>> twoSum(int[] nums, int start, int target) {
            int lo = start <= 0 ? 0 : start, hi = nums.length - 1;
            int left, right;
            List<List<Integer>> res = new ArrayList<>();
            while (lo < hi) {
                left = nums[lo];
                right = nums[hi];

                int sum = left + right;
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    // 注意如果这里使用 List<Integer> list = Arrays.asList(left, right);
                    // 因为实际这个没有实现add方法所以会向外抛出unspported operation exception
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }

            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // put your test code here
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = solution.threeSum(nums);
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
