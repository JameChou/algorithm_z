import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

    /**
     * 1 <= nums.length
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        Set<Integer> sets = new HashSet<Integer>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                int index = i + 1;
                // 向后找到所有相同的数据
                while (index < nums.length && nums[i] == nums[index]) {
                    index++;
                }

                for (int j = 1; j <= nums.length - 1 && (index + j - 1) < nums.length; j++) {
                    nums[i + j] = nums[index + j - 1];
                }
            }
            sets.add(nums[i]);
        }
        sets.add(nums[nums.length - 1]);

        return sets.size();
    }

    public static void main(String[] args) {
        int array[] = { 1, 2, 3 };
        int count = new RemoveDuplicatesFromSortedArray().removeDuplicates(array);
        System.out.println(array);
        System.out.println(count);
    }

}
