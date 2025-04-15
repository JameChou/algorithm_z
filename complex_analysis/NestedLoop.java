public class NestedLoop {
    /**
     * 嵌套循环
     * 这个例子表示的就是，给定一个数，使用这个方法可以将所有的坐标都打印出来
     *
     * 嵌套循环的复杂度是根据层数来的，当每增加一层之后整个复杂度会提升一个指数级
     * 两层就是二次方的关系，如果三层嵌套则是立方关系，四层嵌套则是四次方的关系
     */
    public static void nestedLoop(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("[" + i + "," + j + "]");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        nestedLoop(5);
    }
}
