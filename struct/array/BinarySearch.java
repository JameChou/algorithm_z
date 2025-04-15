package array;

public class BinarySearch {
    /**
     * 二分查找，我们可以把二分查找看作构建一个有序的二叉树，左侧的值比右侧的值要小，中间的位置则是根节点
     *
     * 实现的原理是左右两侧是有一个指针的，这两个指针交叉之后则表示在线性表中没有查找到所要的数据这时候应该返回-1
     * 
     * 可以使用二分查找的必要条件有以下两个:
     * 1. 必须是顺序存储的线性表
     * 2. 必须是有序的表
     *
     * @array 需要查找的数组(线性表)
     * @element 需要查找的元素
     * @return 这个元素在线性表中下标，如果没有这个元素则返回-1
     */
    public static int binarySearch(int[] array, int element) {
        int left = 0, right = array.length - 1, mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] == element) {
                return mid;
            } else if (array[mid] > element) {
                // 表示中间的这个值比需要查找的元素要大，则表示实际这个元素在左侧
                // 那么查找的区间则需要更新成原先的[left, mid-1]
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int array[] = new int[50];
        for (int i = 0; i < 50; i++) {
            array[i] = i;
        }

        int index = binarySearch(array, 58);
        System.out.println("find the element at: " + index);
    }
}
