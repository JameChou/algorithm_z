# n*n 矩阵找到指定值

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


