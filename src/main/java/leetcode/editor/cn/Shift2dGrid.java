
package leetcode.editor.cn;

import java.util.*;

/**
 * 1260 二维网格
 */
public class Shift2dGrid {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            int mn = m * n;
            k = k % mn;

            // 翻转 [mn-k, size - 1];
            reverse(grid, mn - k, mn - 1);
            // 翻转 [0, mn - k)
            reverse(grid, 0, mn - k - 1);
            // 全部翻转一次
            reverse(grid, 0, mn - 1);

            List<List<Integer>> collection = new ArrayList<>();
            for (int[] nums : grid) {
                List<Integer> list = new ArrayList<>();
                for (int num : nums) {
                    list.add(num);
                }

                collection.add(list);
            }

            return collection;
        }

        public void setGrid(int[][] grid, int index, int value) {
            int n = grid[0].length;
            int i = index / n;
            int j = index % n;

            grid[i][j] = value;
        }

        public int getGrid(int[][] grid, int index) {
            int n = grid[0].length;
            int i = index / n;
            int j = index % n;

            return grid[i][j];
        }

        // 对于 (start, end]区间内的矩阵进行反转
        public void reverse(int[][] grid, int start, int end) {
            int left = start, right = end;
            while (left <= right) {
                int temp = getGrid(grid, left);
                setGrid(grid, left, getGrid(grid, right));
                setGrid(grid, right, temp);

                left++;
                right--;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new Shift2dGrid().new Solution();
        // put your test code here

        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int k = 1;
        List<List<Integer>> result = solution.shiftGrid(grid, k);
        for (List<Integer> list : result) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
