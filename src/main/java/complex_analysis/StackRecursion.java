package complex_analysis;

import java.util.Stack;

public class StackRecursion {
    /**
     * 这个例子是通过使用栈数组结构来模拟递归的调用过程。
     *
     * 通过这种方式，我们将递归调用转化为了迭代的形式去处理。
     *
     * 不过这种方式也让代码的复杂度提高了一些，更加的不易读了
     *
     * @param n 等差数列的最大值,d=1
     * @return 相加和的结果
     */
    public static int forLoopStackRecursion(int n) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }

    public static void main(String[] args) {
        int result = forLoopStackRecursion(10);
        System.out.println(result);
    }
}
