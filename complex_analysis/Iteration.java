/**
 * 迭代是一种重复执行某个任务的控制结构。在迭代中，程序会在满足一定的条件下重复执行某段代码，直到这个条件不再满足。
 */
public class Iteration {
    /**
     * 下面的这个例子展示了如何使用等差数列进行求和, d为1
     * 1 + 2 + 3 + 4 + .... + n
     * 也使用了for循环
     *
     * @n 需要求和的边界
     * @return 这个等差数列的和
     */
    public static int forInLoop(int n) {
        int sum = 0;

        // 跳出的边界即达到封顶的位置，则这个循环结束
        // 前面的数据相加完之后向后推进
        for (int i = 0; i <= n; i++) {
            sum = sum + i;
        }

        return sum;
    }

    /**
     * 可以注意到使用while循环与上面的for循环类似，只不过需要把判断跳出条件写好，可能需要多一些变量，自增操作需要自己去定义，不过种形式也使得while循环更加的灵活，比如我们在操作变量i时，for循环则只能处理一次，比如让i往上加2，或者减少，或相乘。使用while循环后则能更方便的处理变量
     */
    public static int whileLoop1(int n) {
        int sum = 0, i = 0;

        // 进行初始化求和
        while (i <= n) {
            sum = sum + i;

            i++;
        }

        return sum;
    }

    /**
     * 上面已经解释了while循环为什么比for循环更加灵活，这个方法就是一个例子
     */
    public static int whileLoop2(int n) {
        int sum = 0, i = 0;
        while (i <= n) {
            sum += i;
            i++;
            i = i * 2;
        }

        return sum;
    }

}
