
package leetcode.editor.cn;

import java.util.ArrayList;

public class ProductOfTheLastKNumbers {

    // leetcode submit region begin(Prohibit modification and deletion)
    class ProductOfNumbers {
        ArrayList<Integer> preProducts = new ArrayList<>();

        public ProductOfNumbers() {
            preProducts.add(1);
        }

        /**
         * 添加一个数到最后末尾
         */
        public void add(int num) {
            if (num == 0) {
                preProducts.clear();
                preProducts.add(1);
                return;
            }

            int n = preProducts.size();
            preProducts.add(preProducts.get(n - 1) * num);
        }

        public int getProduct(int k) {
            int n = preProducts.size();
            if (k > n - 1) {
                return 0;
            }
            // 累积的 乘积 除以 后 [0 - k]个就可以就是 后 k个乘积
            return preProducts.get(n - 1) / preProducts.get(n - k - 1);
        }
    }

    /**
     * Your ProductOfNumbers object will be instantiated and called as such:
     * ProductOfNumbers obj = new ProductOfNumbers();
     * obj.add(num);
     * int param_2 = obj.getProduct(k);
     */
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        ProductOfNumbers solution = new ProductOfTheLastKNumbers().new ProductOfNumbers();
        // put your test code here

        int result;
        solution.add(3); // [3]
        solution.add(0); // [3,0]
        solution.add(2); // [3,0,2]
        solution.add(5); // [3,0,2,5]
        solution.add(4); // [3,0,2,5,4]
        result = solution.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
        System.out.println(result);
        result = solution.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
        System.out.println(result);
        result = solution.getProduct(4); // 返回 0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
        System.out.println(result);
        solution.add(8); // [3,0,2,5,4,8]
        result = solution.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
        System.out.println(result);
    }
}
