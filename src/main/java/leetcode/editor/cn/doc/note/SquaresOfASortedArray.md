# 有序数组的平方

[leetcode 977 有序数组的平方](https://leetcode.cn/problems/squares-of-a-sorted-array/description/)

这个题目一开始我想的比较复杂，一开始使用暴力的解法，即将所有数据先平方然后放到新的数组中再排序。

其实我们只需要左右两个指针同时展开，然后比较，数组 `result` 从 `index = nums.length - 1` 开始加入数据。

```java
public int[] sortedSquares(int[] nums) {
    int[] result = new int[nums.length];

    int left = 0, right = nums.length - 1;
    int index = nums.length - 1;
    // 两个指针相遇的时候则表示需要跳出循环
    while (left <= right) {
        int leftNumber = nums[left] * nums[left];
        int rightNumber = nums[right] * nums[right];

        if (rightNumber > leftNumber) {
            result[index] = rightNumber;
            right--;
        } else {
            result[index] = leftNumber;
            left++;
        }
        index--;
    }

    return result;
}
```


