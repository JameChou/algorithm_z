# 颜色分类

[leetcode 75 颜色分类](https://leetcode.cn/problems/sort-colors/)

我首先想到的是可以使用一个排序算法对这个进行排序。

我尝试着使用 `bubbleSort` 即冒泡排序的方式去解决，去看一下实际的速度。

```java
public void bubbleSort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        boolean hasSwap = false;
        for (int j = 0; j < nums.length - i - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                hasSwap = true;
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }

        if (!hasSwap) {
            break;
        }
    }
}
```

比较有意思的是我这里使用了 `hasSwap` 布尔值做了一个小小的优化，不过从时间上来讲并没有差太多。

```
Success:
	Runtime:2 ms, faster than 2.50% of Java online submissions.
	Memory Usage:41.2 MB, less than 34.29% of Java online submissions.
```

## 较好的解法

可以使用双指针的形式去解决这个题目。






