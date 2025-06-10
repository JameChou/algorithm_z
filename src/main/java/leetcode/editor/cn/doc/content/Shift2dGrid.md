<p>给你一个 <code>m</code> 行 <code>n</code>&nbsp;列的二维网格&nbsp;<code>grid</code>&nbsp;和一个整数&nbsp;<code>k</code>。你需要将&nbsp;<code>grid</code>&nbsp;迁移&nbsp;<code>k</code>&nbsp;次。</p>

<p>每次「迁移」操作将会引发下述活动：</p>

<ul> 
 <li>位于 <code>grid[i][j]</code>（<code>j &lt; n - 1</code>）的元素将会移动到&nbsp;<code>grid[i][j + 1]</code>。</li> 
 <li>位于&nbsp;<code>grid[i][n&nbsp;- 1]</code> 的元素将会移动到&nbsp;<code>grid[i + 1][0]</code>。</li> 
 <li>位于 <code>grid[m&nbsp;- 1][n - 1]</code>&nbsp;的元素将会移动到&nbsp;<code>grid[0][0]</code>。</li> 
</ul>

<p>请你返回&nbsp;<code>k</code> 次迁移操作后最终得到的 <strong>二维网格</strong>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/e1-1.png" style="height: 158px; width: 400px;" /></p>

<pre>
<span><code><strong>输入：</strong>grid</code></span> = [[1,2,3],[4,5,6],[7,8,9]], k = 1
<strong>输出：</strong>[[9,1,2],[3,4,5],[6,7,8]]
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/e2-1.png" style="height: 166px; width: 400px;" /></p>

<pre>
<span><code><strong>输入：</strong>grid</code></span> = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
<strong>输出：</strong>[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<span><code><strong>输入：</strong>grid</code></span> = [[1,2,3],[4,5,6],[7,8,9]], k = 9
<strong>输出：</strong>[[1,2,3],[4,5,6],[7,8,9]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m ==&nbsp;grid.length</code></li> 
 <li><code>n ==&nbsp;grid[i].length</code></li> 
 <li><code>1 &lt;= m &lt;= 50</code></li> 
 <li><code>1 &lt;= n &lt;= 50</code></li> 
 <li><code>-1000 &lt;= grid[i][j] &lt;= 1000</code></li> 
 <li><code>0 &lt;= k &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 模拟</details><br>

<div>👍 135, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题有些像 [✔ ✨151. 颠倒字符串中的单词](/problems/reverse-words-in-a-string/)，也要用到 [二维数组的花式遍历](https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/) 中讲到的多次翻转的技巧。

151 题让你把句子中的所有单词位置翻转，解法思路是先翻转整个句子，然后逐一翻转每个单词。

这道题是同样的思路：你可以写一个 `get` 方法和 `set` 方法把二维数组抽象成一维数组，然后题目就变成了让你将一个一维的数组平移 `k` 位，相当于把前 `mn - k` 个元素的位置和后 `k` 个元素的位置对调，也可以分别翻转前 `mn - k` 个元素和后 `k` 个元素，最后反转所有元素，得到的结果就是题目想要的。

**详细题解**：
  - [【练习】数组双指针经典习题](https://labuladong.online/algo/problem-set/array-two-pointers/)

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

class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        // 把二维 grid 抽象成一维数组
        int m = grid.size(), n = grid[0].size();
        int mn = m * n;
        k = k % mn;
        // 先把最后 k 个数翻转
        reverse(grid, mn - k, mn - 1);
        // 然后把前 mn - k 个数翻转
        reverse(grid, 0, mn - k - 1);
        // 最后把整体翻转
        reverse(grid, 0, mn - 1);

        // 转化成 Java List
        vector<vector<int>> res(m, vector<int>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[i][j] = grid[i][j];
            }
        }
        return res;
    }

    // 通过一维数组的索引访问二维数组的元素
    int get(vector<vector<int>>& grid, int index) {
        int n = grid[0].size();
        int i = index / n, j = index % n;
        return grid[i][j];
    }

    // 通过一维数组的索引修改二维数组的元素
    void set(vector<vector<int>>& grid, int index, int val) {
        int n = grid[0].size();
        int i = index / n, j = index % n;
        grid[i][j] = val;
    }

    // 翻转一维数组的索引区间元素
    void reverse(vector<vector<int>>& grid, int i, int j) {
        while (i < j) {
            int temp = get(grid, i);
            set(grid, i, get(grid, j));
            set(grid, j, temp);
            i++;
            j--;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def shiftGrid(self, grid, k):
        # 把二维 grid 抽象成一维数组
        m, n = len(grid), len(grid[0])
        mn = m * n
        k = k % mn
        # 先把最后 k 个数翻转
        self.reverse(grid, mn - k, mn - 1)
        # 然后把前 mn - k 个数翻转
        self.reverse(grid, 0, mn - k - 1)
        # 最后把整体翻转
        self.reverse(grid, 0, mn - 1)

        # 转化成 Java List
        res = []
        for row in grid:
            rowList = []
            for e in row:
                rowList.append(e)
            res.append(rowList)
        return res

    # 通过一维数组的索引访问二维数组的元素
    def get(self, grid, index):
        n = len(grid[0])
        i, j = divmod(index, n)
        return grid[i][j]

    # 通过一维数组的索引修改二维数组的元素
    def set(self, grid, index, val):
        n = len(grid[0])
        i, j = divmod(index, n)
        grid[i][j] = val

    # 翻转一维数组的索引区间元素
    def reverse(self, grid, i, j):
        while i < j:
            temp = self.get(grid, i)
            self.set(grid, i, self.get(grid, j))
            self.set(grid, j, temp)
            i += 1
            j -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // 把二维 grid 抽象成一维数组
        int m = grid.length, n = grid[0].length;
        int mn = m * n;
        k = k % mn;
        // 先把最后 k 个数翻转
        reverse(grid, mn - k, mn - 1);
        // 然后把前 mn - k 个数翻转
        reverse(grid, 0, mn - k - 1);
        // 最后把整体翻转
        reverse(grid, 0, mn - 1);

        // 转化成 Java List
        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> rowList = new ArrayList<>();
            for (int e : row) {
                rowList.add(e);
            }
            res.add(rowList);
        }
        return res;
    }

    // 通过一维数组的索引访问二维数组的元素
    int get(int[][] grid, int index) {
        int n = grid[0].length;
        int i = index / n, j = index % n;
        return grid[i][j];
    }

    // 通过一维数组的索引修改二维数组的元素
    void set(int[][] grid, int index, int val) {
        int n = grid[0].length;
        int i = index / n, j = index % n;
        grid[i][j] = val;
    }

    // 翻转一维数组的索引区间元素
    void reverse(int[][] grid, int i, int j) {
        while (i < j) {
            int temp = get(grid, i);
            set(grid, i, get(grid, j));
            set(grid, j, temp);
            i++;
            j--;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

import "fmt"

func shiftGrid(grid [][]int, k int) [][]int {
    m, n := len(grid), len(grid[0])
    mn := m * n
    k = k % mn
    // 把二维 grid 抽象成一维数组
    reverse(grid, mn - k, mn - 1)
    // 先把最后 k 个数翻转
    reverse(grid, 0, mn - k - 1)
    // 然后把前 mn - k 个数翻转
    reverse(grid, 0, mn - 1)
    // 最后把整体翻转

    // 转化成 Java List
    res := make([][]int, m)
    for i := 0; i < m; i++ {
        res[i] = make([]int, n)
        for j := 0; j < n; j++ {
            res[i][j] = grid[i][j]
        }
    }
    return res
}

// 通过一维数组的索引访问二维数组的元素
func get(grid [][]int, index int) int {
    n := len(grid[0])
    i, j := index / n, index % n
    return grid[i][j]
}

// 通过一维数组的索引修改二维数组的元素
func set(grid [][]int, index int, val int) {
    n := len(grid[0])
    i, j := index / n, index % n
    grid[i][j] = val
}

// 翻转一维数组的索引区间元素
func reverse(grid [][]int, i, j int) {
    for i < j {
        temp := get(grid, i)
        set(grid, i, get(grid, j))
        set(grid, j, temp)
        i++
        j--
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var shiftGrid = function(grid, k) {
    // 把二维 grid 抽象成一维数组
    let m = grid.length, n = grid[0].length;
    let mn = m * n;
    k = k % mn;
    // 先把最后 k 个数翻转
    reverse(grid, mn - k, mn - 1);
    // 然后把前 mn - k 个数翻转
    reverse(grid, 0, mn - k - 1);
    // 最后把整体翻转
    reverse(grid, 0, mn - 1);

    // 转化成 Java List
    let res = [];
    for (let row of grid) {
        let rowList = [];
        for (let e of row) {
            rowList.push(e);
        }
        res.push(rowList);
    }
    return res;
};

// 通过一维数组的索引访问二维数组的元素
var get = function(grid, index) {
    let n = grid[0].length;
    let i = Math.floor(index / n), j = index % n;
    return grid[i][j];
};

// 通过一维数组的索引修改二维数组的元素
var set = function(grid, index, val) {
    let n = grid[0].length;
    let i = Math.floor(index / n), j = index % n;
    grid[i][j] = val;
};

// 翻转一维数组的索引区间元素
var reverse = function(grid, i, j) {
    while (i < j) {
        let temp = get(grid, i);
        set(grid, i, get(grid, j));
        set(grid, j, temp);
        i++;
        j--;
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_shift-2d-grid"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_shift-2d-grid"></div></div>
</details><hr /><br />

</div>
</details>
</div>

