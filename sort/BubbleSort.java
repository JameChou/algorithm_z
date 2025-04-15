/**
 * 这个是关于冒泡排序的相关练习
 */
public class BubbleSort {
    /**
     * 冒泡排序对数据进行排序操作的函数
     *
     * @array 需要排序的数组
     */
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - i; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 8, -2, 1, 4, 5 };
        // 排序
        bubbleSort(array);

        int index = 0;
        for (int data : array) {
            System.out.println("index[" + index + "]: " + data);
        }

    }
}
