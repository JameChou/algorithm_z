
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * 
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 * 
 * 
 * 示例 1：
 * 
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 * 
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 */
public class KthSmallestElementInASortedMatrix {
    // leetcode submit region begin(Prohibit modification and deletion)
    class State {
        int val;
        int index;
        int matrixIndex;

        public State(int val, int index, int matrixIndex) {
            this.val = val;
            this.index = index;
            this.matrixIndex = matrixIndex;
        }
    }

    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<State> queue = new PriorityQueue<>(matrix.length, (a, b) -> a.val - b.val);
            for (int i = 0; i < matrix.length; i++) {
                State state = new State(matrix[i][0], 0, i);
                queue.offer(state);
            }
            int index = 0;
            int result = -1;

            while (!queue.isEmpty() && index < k) {
                State cur = queue.poll();
                result = cur.val;
                int curIndex = cur.index;
                if ((curIndex + 1) < matrix.length) {
                    queue.offer(new State(matrix[cur.matrixIndex][curIndex + 1], curIndex + 1, cur.matrixIndex));
                }
                index++;
            }

            return result;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        // put your test code here

        int[][] matrix = new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;

        // int[][] matrix = new int[][] { { -5 } };
        // int k = 1;

        System.out.println(solution.kthSmallest(matrix, k));
    }
}
