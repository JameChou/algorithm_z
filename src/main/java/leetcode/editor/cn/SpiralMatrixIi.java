
package leetcode.editor.cn;

public class SpiralMatrixIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int leftBounder = 0, rightBounder = n - 1;
            int upperBounder = 0, lowerBounder = n - 1;

            int[][] matrix = new int[n][n];
            // 矩阵中的值
            int num = 1;
            while (num <= n * n) {
                // 从左至右
                if (upperBounder <= lowerBounder) {
                    for (int j = leftBounder; j <= rightBounder; j++) {
                        matrix[upperBounder][j] = num++;
                    }

                    upperBounder++;
                }

                // 从上至下
                if (leftBounder <= rightBounder) {
                    for (int i = upperBounder; i <= lowerBounder; i++) {
                        matrix[i][rightBounder] = num++;
                    }

                    rightBounder--;
                }

                // 从右至左
                if (upperBounder <= lowerBounder) {
                    for (int j = rightBounder; j >= leftBounder; j--) {
                        matrix[lowerBounder][j] = num++;
                    }
                    lowerBounder--;
                }

                // 从下至上
                if (leftBounder <= rightBounder) {
                    for (int i = lowerBounder; i >= upperBounder; i--) {
                        matrix[i][leftBounder] = num++;
                    }
                    leftBounder++;
                }
            }

            return matrix;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        // put your test code here
        int[][] matrix = solution.generateMatrix(4);
        for (int[] array : matrix) {
            for (int element : array) {
                System.out.print(element + " ");
            }

            System.out.println();
        }

    }
}
