
package leetcode.editor.cn;

public class RangeSumQuery2dImmutable {

    // leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {

        int[][] preSums;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            if (m == 0 || n == 0) {
                return;
            }

            preSums = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 初始化前缀和
                    preSums[i][j] = preSums[i - 1][j] + preSums[i][j - 1] + matrix[i - 1][j - 1]
                            - preSums[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int x1, int y1, int x2, int y2) {
            return preSums[x2 + 1][y2 + 1] - preSums[x1][y2 + 1] - preSums[x2 + 1][y1] + preSums[x1][y1];
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        // put your test code here
        int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 } };
        RangeSumQuery2dImmutable solution = new RangeSumQuery2dImmutable();
        // NOTE: 这里真是学习了一下，原来内部类是这样new的，我还一直不知道呢！哈哈
        RangeSumQuery2dImmutable.NumMatrix m = solution.new NumMatrix(matrix);
        // 测试计算(2, 1)和(4, 3)两个点对角线的值
        int result = m.sumRegion(2, 1, 4, 3);
        System.out.println(result);
    }
}
