package sort;

public class Sort {
    // 排序从小到大
    void sort(int[] nums) {
        int n = nums.length;

        // 需要排序的Index
        int sortedIndex = 0;

        while (sortedIndex < n) {
            int minIndex = sortedIndex;

            // 记录最小值，然后再做交换操作
            for (int i = sortedIndex + 1; i < n; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            int temp = nums[minIndex];
            nums[minIndex] = nums[sortedIndex];
            nums[sortedIndex] = temp;

            sortedIndex++;
        }

    }

    // 主函数测试用
    public static void main(String[] args) {

    }

}
