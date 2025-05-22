package struct.array;

public class ArrayLesson {

    /**
     * 对数组进行扩展扩展的方式只能是新建一个新的数组，然后将原来的数据进行复制操作
     *
     * @array 需要扩展的数组
     * @expandLength 需要扩展的长度
     */
    public static int[] expand(int[] array, int expandLength) {
        if (expandLength <= 0) {
            return array;
        }

        int[] rtnArray = new int[expandLength + array.length];
        for (int i = 0; i < array.length; i++) {
            rtnArray[i] = array[i];
        }

        return rtnArray;
    }

    /**
     * 根据某个位置删除数组中的某个位置的元素
     * 删除某个元素则需要这个位置后面的所有元素都向左进行平移操作
     *
     * @array 需要处理的数组
     * @index 需要删除的元素位置
     */
    public static void deleteByIndex(int[] array, int index) {
        if (index > array.length || index < 0) {
            return;
        }

        for (int i = index; i < array.length - 1; i++) {
            array[index] = array[index + 1];
            index++;
        }

    }

    /**
     * 插入一个元素就是把数组先进入扩展，然后再把新的元素插入进去
     *
     * @array 需要插入元素的数组
     * @index 需要插入的位置
     * @element 需要插入元素值
     */
    public static int[] insert(int[] array, int index, int element) {
        if (index < 0 || index >= array.length) {
            return array;
        }

        // 先扩展一个新的数组
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }

        newArray[index] = element;
        for (int i = 1; i <= array.length - index; i++) {
            newArray[index + i] = array[index + i - 1];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 4 };

        array = expand(array, 2);
        array[4] = 5;
        array[5] = 6;

        for (int num : array) {
            System.out.print(num + ", ");
        }
        System.out.println();

        deleteByIndex(array, 2);
        for (int num : array) {
            System.out.print(num + ", ");
        }

        System.out.println();
        array = insert(array, 2, 88);
        for (int num : array) {
            System.out.print(num + ", ");
        }

    }
}
