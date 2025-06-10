<p>给你一个二维整数数组 <code>matrix</code>，&nbsp;返回 <code>matrix</code> 的 <strong>转置矩阵</strong> 。</p>

<p>矩阵的 <strong>转置</strong> 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/02/10/hint_transpose.png" style="width: 600px; height: 197px;" /></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>输出：</strong>[[1,4,7],[2,5,8],[3,6,9]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>matrix = [[1,2,3],[4,5,6]]
<strong>输出：</strong>[[1,4],[2,5],[3,6]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == matrix.length</code></li> 
 <li><code>n == matrix[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 1000</code></li> 
 <li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= matrix[i][j] &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 模拟</details><br>

<div>👍 289, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题没啥特别的技巧，new 出来一个新的转置矩阵，其中 `(x, y)` 的值为原矩阵的 `(y, x)` 的值，直接写代码就行了。

有读者学过 [二维数组的花式遍历](https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/) 后可能会尝试思考如何原地转置，但是矩阵转置这种问题肯定是做不到的，因为数组的维度都不同。比方说 3x2 的矩阵，转置之后会变成 2x3 的，你不 new 一个新数组出来怎么可能做到呢？

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
    vector<vector<int>> transpose(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        // 转置矩阵的长和宽颠倒
        vector<vector<int>> res(n, vector<int>(m));
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
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

class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        m = len(matrix)
        n = len(matrix[0])
        # 转置矩阵的长和宽颠倒
        res = [[0] * m for _ in range(n)]
        for i in range(m):
            for j in range(n):
                res[j][i] = matrix[i][j]
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 转置矩阵的长和宽颠倒
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
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

func transpose(matrix [][]int) [][]int {
    m := len(matrix)
    n := len(matrix[0])
    // 转置矩阵的长和宽颠倒
    res := make([][]int, n)
    for i := 0; i < n; i++ {
        res[i] = make([]int, m)
    }
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            res[j][i] = matrix[i][j]
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

var transpose = function(matrix) {
    let m = matrix.length, n = matrix[0].length;
    // 转置矩阵的长和宽颠倒
    let res = Array.from({length: n}, () => Array(m).fill(0));
    for (let i = 0; i < m; i++)
        for (let j = 0; j < n; j++) {
            res[j][i] = matrix[i][j];
        }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_transpose-matrix"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_transpose-matrix"></div></div>
</details><hr /><br />

</div>
</details>
</div>

