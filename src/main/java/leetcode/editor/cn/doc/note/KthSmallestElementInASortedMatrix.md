# n*n 矩阵找到指定值

## 自己解法

这个题目即合并`K`个有序链表，可以使用 `PriorityQueue` 优先级队列处理这个问题。步骤如下：

1. 创建一个 `State` 类，这个类里存的数据主要有 `val` 和 `index` 以及 `matrixIndex` 。这三个主要是用于存储，值，在二维矩阵中的列即*j*和二维矩阵中的行*i*。
2. 把二维数据每行的第一个数加入到优先级队列中去。
3. 后面再像链表一样把后面的数不断的加入到队列中，让堆的大小始终保持<=3的状态。

```java
class State {
    // 数据
    int val;
    // j
    int index;
    // i
    int matrixIndex;

    public State(int val, int index, int matrixIndex) {
        this.val = val;
        this.index = index;
        this.matrixIndex = matrixIndex;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 小顶堆
        PriorityQueue<State> queue = new PriorityQueue<>(matrix.length, (a, b) -> a.val - b.val);

        // 将二维数组第一行第一列的数加入到堆中
        for (int i = 0; i < matrix.length; i++) {
            State state = new State(matrix[i][0], 0, i);
            queue.offer(state);
        }
        int index = 0;
        // 返回值
        int result = -1;

        while (!queue.isEmpty() && index < k) {
            State cur = queue.poll();
            result = cur.val;
            int curIndex = cur.index;
            // 像链表一样向后取值
            if ((curIndex + 1) < matrix.length) {
                queue.offer(new State(matrix[cur.matrixIndex][curIndex + 1], curIndex + 1, cur.matrixIndex));
            }
            index++;
        }

        return result;
    }

}

```

## 优化空间复杂度解法

```java
public int kthSmallest(int[][] matrix, int k) {

    // 使用堆去处理
    // 这里存放的一维数组长度为三，分别存储着实际值、所在行、所在列
    PriorityQueue<int[]> queue = new PriorityQueue<>(k, (a, b) -> a[0] - b[0]);

    for (int i = 0; i < matrix.length; i++) {
        queue.offer(new int[] { matrix[i][0], i, 0 });
    }

    int result = -1;
    int index = k;

    while (!queue.isEmpty() && index > 0) {
        int[] cur = queue.poll();

        if (cur[2] + 1 >= k) {
            continue;
        }

        queue.add(new int[] { matrix[cur[1]][cur[2] + 1], cur[1], cur[2] + 1 });
        index--;
    }
    return result;
}
```

上面的这种解法与上面的部分总体的思路是是一样的，只不过因为使用了一维数组来存储数据。

第一项存储的是实际值，第二项储存的是所在行，第三项存储的是所在列。

**从时间的复杂度上来讲并没有起到特别多的优化效果，而空间复杂度得到了不小的提升。**

**上面两种算法的时间复杂度都为** $O(klogN)$ 。空间复杂度上面我还需要再研究一下。

