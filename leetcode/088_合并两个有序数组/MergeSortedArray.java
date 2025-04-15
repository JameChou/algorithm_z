public class MergeSortedArray {

    /**
     * @nums1 数组1
     * @m 数组1的长度
     * @nums2 数组2
     * @n 数组2的长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) {
            return;
        }

        if (nums1 == null || nums1.length == 0) {
            nums1 = nums2;
            return;
        }

        int cursor1 = 0, cursor2 = 0;
        int array[] = new int[nums1.length];
        int index = 0;
        // 两个指定去移动查找数据
        while (true) {
            if (cursor1 == m && cursor2 == n) {
                break;
            }

            if (cursor1 < m && cursor2 < n) {
                if (nums1[cursor1] < nums2[cursor2]) {
                    array[index] = nums1[cursor1];
                    cursor1++;
                } else {
                    array[index] = nums2[cursor2];
                    cursor2++;
                }
            } else if (cursor1 < m && cursor2 >= n) {
                array[index] = nums1[cursor1];
                cursor1++;
            } else if (cursor1 >= m && cursor2 < n) {
                array[index] = nums2[cursor2];
                cursor2++;
            }

            index++;

        }

        for (int i = 0; i < array.length; i++) {
            nums1[i] = array[i];
        }
    }

    public static void main(String[] args) {
        int nums1[] = {};
        int nums2[] = {};
    }
}
