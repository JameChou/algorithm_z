
package leetcode.editor.cn;

public class RotateImage {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            // 做对称处理
            symmetry(matrix);
            // symmetry2(matrix);

            // 反转每一行的数据
            for (int i = 0; i < matrix.length; i++) {
                reverse(matrix[i]);
            }
        }

        /*
         * 反转一个一维数组
         *
         * @param array 一维数组
         */
        public void reverse(int[] array) {
            int left = 0, right = array.length - 1;
            while (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;

                left++;
                right--;
            }
        }

        /**
         * 沿右上到左下对称交换
         *
         * @param matrix 二维数组
         */
        public void symmetry2(int[][] matrix) {
            int n = matrix.length;
            // 沿左下到右上的对角线镜像对称二维矩阵
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    // swap(matrix[i][j], matrix[n-j-1][n-i-1])
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][n - i - 1];
                    matrix[n - j - 1][n - i - 1] = temp;
                }
            }
        }

        /**
         * 对一个二维数组做左上到右下的对称交换
         *
         * @param matrix 二维数组
         */
        public void symmetry(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix.length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        // put your test code here

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        solution.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
