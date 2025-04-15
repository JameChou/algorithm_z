public class ClimbingStairs {

    int array[] = new int[64];

    /**
     * 每次可以爬1-2个台阶
     *
     * @n 表示有多少个台阶
     * @return 总共有多少种方法
     */
    public int climbStairs(int n) {
        if (array[n] > 0) {
            return array[n];
        }

        if (n == 1 || n == 0) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int ans = climbStairs(n - 2) + climbStairs(n - 1);

        array[n] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int total = new ClimbingStairs().climbStairs(n);
        System.out.println(total);
    }
}
