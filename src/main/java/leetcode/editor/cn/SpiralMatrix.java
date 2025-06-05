
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SpiralMatrix {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int upperBound = 0, lowerBound = m - 1;
            int leftBound = 0, rightBound = n - 1;
            List<Integer> result = new ArrayList<>();

            int targetSize = m * n;
            while (result.size() < targetSize) {
                // 从左往右
                if (upperBound <= lowerBound) {
                    for (int j = leftBound; j <= rightBound; j++) {
                        result.add(matrix[upperBound][j]);
                    }
                    upperBound++;
                }

                // 从上至下
                if (leftBound <= rightBound) {
                    for (int i = upperBound; i <= lowerBound; i++) {
                        result.add(matrix[i][rightBound]);
                    }
                    rightBound--;
                }

                // 从右往左
                if (upperBound <= lowerBound) {
                    for (int j = rightBound; j >= leftBound; j--) {
                        result.add(matrix[lowerBound][j]);
                    }
                    lowerBound--;
                }

                // 从下至上
                if (leftBound <= rightBound) {
                    for (int i = lowerBound; i >= upperBound; i--) {
                        result.add(matrix[i][leftBound]);
                    }

                    leftBound++;
                }
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        // put your test code here
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> result = solution.spiralOrder(matrix);

        for (int r : result) {
            System.out.print(r + " ");
        }

        System.out.println();

    }
}
