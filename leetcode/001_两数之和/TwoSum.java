public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int rtnIndex[] = new int[2];

        int indexOne = -1, indexTwo = -1;
        boolean breakFlag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    breakFlag = true;
                    indexTwo = j;
                    break;
                }
            }

            if (breakFlag) {
                indexOne = i;
                break;
            }
        }

        rtnIndex[0] = indexOne;
        rtnIndex[1] = indexTwo;

        return rtnIndex;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(new int[] { 0, 4, 5, 0 }, 0);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
