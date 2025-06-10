
package leetcode.editor.cn;

import java.util.*;

public class SortTheMatrixDiagonally {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int m = mat.length, n = mat[0].length;

            int i = 0;
            int[][] result = new int[m][n];
            while (i < m) {
                int idx1 = i;
                for (int j = 0; j < (i == 0 ? n : 1); j++) {
                    List<Integer> nums = new ArrayList<>();
                    int idx2 = j;
                    while (idx1 < m && idx2 < n) {
                        nums.add(mat[idx1][idx2]);
                        idx1++;
                        idx2++;
                    }

                    Collections.sort(nums);
                    // collection.add(nums);
                    idx1 = i;
                    idx2 = j;
                    for (int num : nums) {
                        result[idx1][idx2] = num;
                        idx1++;
                        idx2++;
                    }
                    idx1 = i;
                }

                i++;
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SortTheMatrixDiagonally().new Solution();
        // put your test code here

        int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
        int[][] result = solution.diagonalSort(mat);
        for (int[] nums : result) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
