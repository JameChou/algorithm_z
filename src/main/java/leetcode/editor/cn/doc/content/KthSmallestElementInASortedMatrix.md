<p>给你一个&nbsp;<code>n x n</code><em>&nbsp;</em>矩阵&nbsp;<code>matrix</code> ，其中每行和每列元素均按升序排序，找到矩阵中第 <code>k</code> 小的元素。<br /> 请注意，它是 <strong>排序后</strong> 的第 <code>k</code> 小元素，而不是第 <code>k</code> 个 <strong>不同</strong> 的元素。</p>

<p>你必须找到一个内存复杂度优于&nbsp;<code>O(n<sup>2</sup>)</code> 的解决方案。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
<strong>输出：</strong>13
<strong>解释：</strong>矩阵中的元素为 [1,5,9,10,11,12,13,<strong>13</strong>,15]，第 8 小元素是 13
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>matrix = [[-5]], k = 1
<strong>输出：</strong>-5
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == matrix.length</code></li> 
 <li><code>n == matrix[i].length</code></li> 
 <li><code>1 &lt;= n &lt;= 300</code></li> 
 <li><code>-10<sup>9</sup> &lt;= matrix[i][j] &lt;= 10<sup>9</sup></code></li> 
 <li>题目数据 <strong>保证</strong> <code>matrix</code> 中的所有行和列都按 <strong>非递减顺序</strong> 排列</li> 
 <li><code>1 &lt;= k &lt;= n<sup>2</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong></p>

<ul> 
 <li>你能否用一个恒定的内存(即 <code>O(1)</code> 内存复杂度)来解决这个问题?</li> 
 <li>你能在 <code>O(n)</code> 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（&nbsp;<a href="http://www.cse.yorku.ca/~andy/pubs/X+Y.pdf" target="_blank">this paper</a>&nbsp;）很有趣。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 矩阵 | 排序 | 堆（优先队列）</details><br>

<div>👍 1118, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题其实是前文 [单链表的六大解题套路](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 中讲过的 [✔ ✨23. 合并K个升序链表](/problems/merge-k-sorted-lists/) 的变体。

矩阵中的每一行都是排好序的，就好比多条有序链表，你用优先级队列施展合并多条有序链表的逻辑就能找到第 `k` 小的元素了。

**详细题解**：
  - [【练习】优先级队列经典习题](https://labuladong.online/algo/problem-set/binary-heap/)
  - [【练习】链表双指针经典习题](https://labuladong.online/algo/problem-set/linkedlist-two-pointers/)

</div>





<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

#include <queue>
#include <vector>

class Solution {
public:
    int kthSmallest(std::vector<std::vector<int>>& matrix, int k) {
        // 存储二元组 (matrix[i][j], i, j)
        // i, j 记录当前元素的索引位置，用于生成下一个节点
        auto cmp = [](const std::vector<int>& a, const std::vector<int>& b) {
            // 按照元素大小升序排序
            return a[0] > b[0];
        };
        std::priority_queue<std::vector<int>, std::vector<std::vector<int>>, decltype(cmp)> pq(cmp);

        // 初始化优先级队列，把每一行的第一个元素装进去
        for (int i = 0; i < matrix.size(); i++) {
            pq.push({matrix[i][0], i, 0});
        }

        int res = -1;
        // 执行合并多个有序链表的逻辑，找到第 k 小的元素
        while (!pq.empty() && k > 0) {
            std::vector<int> cur = pq.top();
            pq.pop();
            res = cur[0];
            k--;
            // 链表中的下一个节点加入优先级队列
            int i = cur[1], j = cur[2];
            if (j + 1 < matrix[i].size()) {
                pq.push({matrix[i][j + 1], i, j + 1});
            }
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

from queue import PriorityQueue

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        # 存储二元组 (matrix[i][j], i, j)
        # i, j 记录当前元素的索引位置，用于生成下一个节点
        pq = PriorityQueue()

        # 初始化优先级队列，把每一行的第一个元素装进去
        for i in range(len(matrix)):
            pq.put((matrix[i][0], i, 0))

        res = -1
        # 执行合并多个有序链表的逻辑，找到第 k 小的元素
        while not pq.empty() and k > 0:
            cur = pq.get()
            # 按照元素大小升序排序
            res = cur[0]
            k -= 1
            # 链表中的下一个节点加入优先级队列
            i, j = cur[1], cur[2]
            if j + 1 < len(matrix[i]):
                pq.put((matrix[i][j + 1], i, j + 1))
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 存储二元组 (matrix[i][j], i, j)
        // i, j 记录当前元素的索引位置，用于生成下一个节点
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 按照元素大小升序排序
            return a[0] - b[0];
        });


        // 初始化优先级队列，把每一行的第一个元素装进去
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        int res = -1;
        // 执行合并多个有序链表的逻辑，找到第 k 小的元素
        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            res = cur[0];
            k--;
            // 链表中的下一个节点加入优先级队列
            int i = cur[1], j = cur[2];
            if (j + 1 < matrix[i].length) {
                pq.add(new int[]{matrix[i][j + 1], i, j + 1});
            }
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// IntHeap is a min-heap of []int
type IntHeap [][]int

// 按照元素大小升序排序
func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i][0] < h[j][0] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.([]int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

// 存储二元组 (matrix[i][j], i, j)
// i, j 记录当前元素的索引位置，用于生成下一个节点
func kthSmallest(matrix [][]int, k int) int {
	pq := &IntHeap{}
	heap.Init(pq)

	// 初始化优先级队列，把每一行的第一个元素装进去
	for i := range matrix {
		heap.Push(pq, []int{matrix[i][0], i, 0})
	}

	res := -1
	// 执行合并多个有序链表的逻辑，找到第 k 小的元素
	for pq.Len() > 0 && k > 0 {
		cur := heap.Pop(pq).([]int)
		res = cur[0]
		k--
		// 链表中的下一个节点加入优先级队列
		i, j := cur[1], cur[2]
		if j+1 < len(matrix[i]) {
			heap.Push(pq, []int{matrix[i][j+1], i, j + 1})
		}
	}
	return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var kthSmallest = function(matrix, k) {
    // 存储二元组 (matrix[i][j], i, j)
    // i, j 记录当前元素的索引位置，用于生成下一个节点
    let pq = new PriorityQueue((a, b) => {
        // 按照元素大小升序排序
        return a[0] - b[0];
    });

    // 初始化优先级队列，把每一行的第一个元素装进去
    for (let i = 0; i < matrix.length; i++) {
        pq.enqueue([matrix[i][0], i, 0]);
    }

    let res = -1;
    // 执行合并多个有序链表的逻辑，找到第 k 小的元素
    while (!pq.isEmpty() && k > 0) {
        let cur = pq.dequeue();
        res = cur[0];
        k--;
        // 链表中的下一个节点加入优先级队列
        let i = cur[1], j = cur[2];
        if (j + 1 < matrix[i].length) {
            pq.enqueue([matrix[i][j + 1], i, j + 1]);
        }
    }
    return res;
};
```

</div></div>
</div></div>

</div>
</details>
</div>







