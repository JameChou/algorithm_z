
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 
 * 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * 
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 */
public class FindKPairsWithSmallestSums {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            // 初始化一个堆
            PriorityQueue<int[]> queue = new PriorityQueue<>(nums1.length, (a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
            for (int i = 0; i < nums1.length; i++) {
                queue.offer(new int[] { nums1[i], nums2[0], i, 0 });
            }

            List<List<Integer>> result = new ArrayList<>();
            while (!queue.isEmpty() && k > 0) {
                int cur[] = queue.poll();
                List<Integer> couple = new ArrayList<>();
                couple.add(cur[0]);
                couple.add(cur[1]);
                result.add(couple);

                k--;

                if (cur[3] + 1 == nums2.length) {
                    continue;
                }

                queue.offer(new int[] { cur[0], nums2[cur[3] + 1], cur[2], cur[3] + 1 });
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
        // put your test code here
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };

        int k = 3;
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        for (List<Integer> list : result) {
            System.out.println(list);
        }

    }
}
