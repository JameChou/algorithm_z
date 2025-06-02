package struct.array;

public class SearchBySequence {

    /**
     * 按照顺序去查找数组中是否含有某个元素，如果数组中有这个元素则返回这个元素在数组中的下标
     * 否则返回<strong>-1</strong>
     *
     * @array 需要查找数组
     * @length 查找范围，如果这个参数为-1或者是小于大于的数组的长度则按照数组的长度来找
     * @element 需要查找的这个元素值
     * @return 如果数组中需要查找的元素，则返回这个元素在数组中的下标，如果没有则返回-1
     */
    public static int searchBySequence(int[] array, int length, int element) {
        if (array.length < length) {
            length = array.length;
        }
        for (int i = 0; i < length; i++) {
            if (array[i] == element) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[20];

        for (int i = 0; i < 20; i++) {
            array[i] = i + 5;
        }

        int index = searchBySequence(array, array.length, 8);
        System.out.println("find the element at " + index);

    }
}
