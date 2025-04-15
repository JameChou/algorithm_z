public class SearchInsertPosition {
    // 可以使用二分查找的方法来处理这个问题
    public int searchInsert(int[] nums, int target) {
        // 第一个大于等于target [left, right)
        int left = 0, right = nums.length;
        // 当两边的游标碰到的时候则表示结束
        while (left < right) {
            // 找到中间值
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // int nums[] = { 1, 3, 5, 6 };
        int nums[] = { 1, 3, 5 };
        int target = 1;

        int result = new SearchInsertPosition().searchInsert(nums, target);

        System.out.println(result);
    }
}
