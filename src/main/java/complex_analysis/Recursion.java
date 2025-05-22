package complex_analysis;

/**
 * 递归
 * 
 * @link https://www.hello-algo.com/chapter_computational_complexity/iteration_and_recursion/#3
 */
public class Recursion {

    /**
     * 这里做一个等差数列的求和
     *
     * 递归我们按这两个字来分，过程上有递 和 归两个，
     * 1. 递: 程序不断深入调用自身，直到传入更小更简化的参数时，程序得到相应的返回值，达到终止条件
     * 2. 归: 当达到终止条件后，程序从最深层的递归函数开始逐层返回，汇聚每一层结果。
     *
     * 函数的局部变量等信息一般是存储在栈内存当中的，递归的这种算法则会不断的申请和开辟新的内存，可能会导致栈内存溢出的情况即StackOverFlow错误
     *
     * 并且递归在小数据量的时候效率还是不错的，不过当数据量稍微大一些之后，呈现指数级的增长
     * 
     * @n 等差数列求和的最大上限
     * @return 最终的求和值
     */
    public static int plusRecursion(int n) {
        if (n == 1) {
            return 1;
        }

        return plusRecursion(n - 1) + n;
    }

    public static void main(String[] args) {
        int n = 3;
        int result = plusRecursion(n);

        System.out.println(result);
    }

}
