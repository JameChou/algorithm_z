# 找到K个两链表最小的和

给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。

定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。

请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。


示例 1:

输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
输出: [1,2],[1,4],[1,6]
解释: 返回序列中的前 3 对数：
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
示例 2:

输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
输出: [1,1],[1,1]
解释: 返回序列中的前 2 对数：
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

--------

根据上面的题目，我没有特别好的思路，我使用的是暴力解法。

不过这种解法会报出

```
Compile Error:
	Memory Limit Exceeded
            [1, 2, 3, 4, 5, .....]
            [1, 2, 3, 4, 5, .....]
			10000
	stdout:
		
```

```java
public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
            (a, b) -> (a.getFirst() + a.getLast()) - (b.getFirst() + b.getLast()));

    for (int i = 0; i < nums1.length; i++) {
        for (int j = 0; j < nums2.length; j++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[j]);
            queue.offer(list);
        }
    }

    int index = 0;

    List<List<Integer>> result = new ArrayList<>();
    while (!queue.isEmpty() && index < k) {
        result.add(queue.poll());
        index++;
    }
    return result;
}
```

我的思路是
1. 把所有的情况进行遍历，进行组合，然后放入到小顶堆中去。首先这种写法时间的复杂度就已经到了 $O(n^2)$ 级别了。
2. 再从小顶堆中把数据都`poll`出来，就得到有序的了。

## 解题思路

我们这里还是使用 `PriorityQueue` 优先级队列来处理这个问题，我们把这里的键值对看作是一个链表

```
输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
输出: [1,2],[1,4],[1,6]

(1, 2) -> (1, 4) -> (1, 6)
(7, 2) -> (7, 4) -> (7, 6)
(11, 2) -> (11, 4) -> (11, 6)
```

```java
public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    // 初始化一个堆
    PriorityQueue<int[]> queue = new PriorityQueue<>(nums1.length, (a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
    for (int i = 0; i < nums1.length; i++) {
        queue.offer(new int[] { nums1[i], nums2[0], 0 });
    }

    List<List<Integer>> result = new ArrayList<>();
    while (!queue.isEmpty() && k > 0) {
        int cur[] = queue.poll();
        List<Integer> couple = new ArrayList<>();
        couple.add(cur[0]);
        couple.add(cur[1]);
        result.add(couple);

        k--;

        if (cur[2] + 1 == nums2.length) {
            continue;
        }

        queue.offer(new int[] { cur[0], nums2[cur[2] + 1], cur[2] + 1 });
    }

    return result;
}
```

我们可以使用 `int[]` 来记录如下三种数据 `nums1` 的值，`nums2` 的某一项值，`nums2` 那个值把对应的位置。

```java
if (cur[2] + 1 == nums2.length) {
    continue;
}
```

上面的这个是记录`nums2` 的位置判断边界。



