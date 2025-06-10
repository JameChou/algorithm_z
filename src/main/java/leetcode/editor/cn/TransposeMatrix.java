
package leetcode.editor.cn;

public class TransposeMatrix {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;

            int[][] res = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[j][i] = matrix[i][j];
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new TransposeMatrix().new Solution();
        // put your test code here
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        solution.transpose(matrix);

        for (int[] nums : matrix) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
