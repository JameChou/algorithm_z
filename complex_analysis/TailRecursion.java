
/**
 * 尾递归
 */
public class TailRecursion {
    /**
     * 有趣的是，如果函数在返回前的最后一步才进行递归调用，则该函数可以被编译器或解释器优化，使其在空间效率上与迭代相当。这种情况被称为尾递归（tail
     * recursion）。
     *
     * 在Java这个语言中，是支持尾递归优化的
     *
     * @aram n
     * @param res
     * @return
     */
    public static int tailRecursion(int n, int res) {
        if (n == 0) {
            return res;
        }

        return tailRecursion(n - 1, res + n);
    }

    public static void main(String[] args) {
        int n = 30, res = 0;
        int result = tailRecursion(n, res);

        System.out.println(result);
    }
}
