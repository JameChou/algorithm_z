# leetcode 219 存在重复元素 

[leetcode 219 存在重复元素 ](https://leetcode.cn/problems/contains-duplicate-ii/description/)

我还是延续了之前的一个思路，是使用 `Map` 去处理的，其实这里我们只需要维护一个长度是 `k` 的这么一个窗口，使用 `HashSet` 就可以了，只在这个窗口大小内，存在这个元素就表示我们已经处理成功了。

## 自己的处理办法

```java
public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> window = new HashMap<>();

    int left = 0, right = 0;
    while (right < nums.length) {
        int c = nums[right];
        right++;

        window.put(c, window.getOrDefault(c, 0) + 1);
        // 说明现在这个元素在窗口中已经> 1了
        while (window.get(c) > 1) {
            if (Math.abs(right - left - 1) <= k) {
                return true;
            }
            int d = nums[left];
            left++;
            window.put(d, window.get(d) - 1);
        }
    }
    return false;
}
```

## 较好的处理办法
```java
public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> window = new HashSet<>();
    int left = 0, right = 0;
    while (right < nums.length) {
        if (window.contains(nums[right])) {
            return true;
        }

        window.add(nums[right]);
        right++;
        // 始终维护一个大小为k的窗口
        while (right - left > k) {
            window.remove(nums[left]);
            left++;
        }

    }
    return false;
}
```




