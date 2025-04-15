/**
 * 关于选择排序的相关练习
 */
public class SelectSort {
    /**
     * 选择排序
     *
     * 是通过找到最小的值，依次向后进行比较后
     * 然后再进行交换的操作
     *
     * @array 需要排序的数组
     */
    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];

            int swapIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    swapIndex = j;
                }
            }

            if (swapIndex != i) {
                int temp = array[i];
                array[i] = array[swapIndex];
                array[swapIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 8, -2, 1, 4, 5 };

        selectSort(array);
        int index = 0;
        for (int data : array) {
            System.out.println("index[" + index + "]: " + data);
        }
    }
}
