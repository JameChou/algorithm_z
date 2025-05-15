package utils;

import java.util.List;

public class PrintUtil {

    /**
     * 打印矩阵的工具
     *
     * @param edges 矩阵类型是一个普通的二维数组
     */
    public static void printMatrix(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 简单打印矩阵工具，与上面的部分不同的是这里是处理List
     * 
     * @param edges 矩阵类型是List
     */
    public static void printMatrix(List<List<Integer>> edges) {
        for (List<Integer> list : edges) {
            for (Integer e : list) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
