<p><big><small>给定一个二维矩阵 <code>matrix</code>，</small></big>以下类型的多个请求：</p>

<ul> 
 <li><big><small>计算其子矩形范围内元素的总和，该子矩阵的 <strong>左上角</strong> 为 <code>(row1,&nbsp;col1)</code> ，<strong>右下角</strong> 为 <code>(row2,&nbsp;col2)</code> 。</small></big></li> 
</ul>

<p>实现 <code>NumMatrix</code> 类：</p>

<ul> 
 <li><code>NumMatrix(int[][] matrix)</code>&nbsp;给定整数矩阵 <code>matrix</code> 进行初始化</li> 
 <li><code>int sumRegion(int row1, int col1, int row2, int col2)</code>&nbsp;返回<big><small> <strong>左上角</strong></small></big><big><small> <code>(row1,&nbsp;col1)</code>&nbsp;、<strong>右下角</strong>&nbsp;<code>(row2,&nbsp;col2)</code></small></big> 所描述的子矩阵的元素 <strong>总和</strong> 。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://pic.leetcode-cn.com/1626332422-wUpUHT-image.png" style="width: 200px;" /></p>

<pre>
<strong>输入:</strong> 
["NumMatrix","sumRegion","sumRegion","sumRegion"]
[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
<strong>输出:</strong> 
[null, 8, 11, 12]

<strong>解释:</strong>
NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == matrix.length</code></li> 
 <li><code>n == matrix[i].length</code></li> 
 <li><code>1 &lt;= m,&nbsp;n &lt;=&nbsp;200</code>
  <meta charset="UTF-8" /></li> 
 <li><code>-10<sup>5</sup>&nbsp;&lt;= matrix[i][j] &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= row1 &lt;= row2 &lt; m</code></li> 
 <li><code>0 &lt;= col1 &lt;= col2 &lt; n</code></li> 
 <li>
  <meta charset="UTF-8" />最多调用 <code>10<sup>4</sup></code> 次&nbsp;<code>sumRegion</code> 方法</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>设计 | 数组 | 矩阵 | 前缀和</details><br>

<div>👍 606, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/prefix-sum/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题的思路和 [✔ ✨303. 区域和检索 - 数组不可变](/problems/range-sum-query-immutable/) 中一维数组中的前缀和问题是非常类似的，如下图：

![](https://labuladong.online/algo/images/presum/5.jpeg)

如果我想计算红色的这个子矩阵的元素之和，可以用绿色矩阵减去蓝色矩阵减去橙色矩阵最后加上粉色矩阵，而绿蓝橙粉这四个矩阵有一个共同的特点，就是左上角就是 `(0, 0)` 原点。

那么我们可以维护一个二维 `preSum` 数组，专门记录以原点为顶点的矩阵的元素之和，就可以用几次加减运算算出任何一个子矩阵的元素和。

**详细题解**：
  - [小而美的算法技巧：前缀和数组](https://labuladong.online/algo/data-structure/prefix-sum/)

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

#include <vector>

class NumMatrix {
    // preSum[i][j] 记录矩阵 [0, 0, i-1, j-1] 的元素和
    std::vector<std::vector<int>> preSum;

public:
    NumMatrix(std::vector<std::vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        if (m == 0 || n == 0) return;
        // 构造前缀和矩阵
        preSum.resize(m + 1, std::vector<int>(n + 1, 0));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i - 1][j - 1] - preSum[i-1][j-1];
            }
        }
    }
    
    // 计算子矩阵 [x1, y1, x2, y2] 的元素和
    int sumRegion(int x1, int y1, int x2, int y2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return preSum[x2+1][y2+1] - preSum[x1][y2+1] - preSum[x2+1][y1] + preSum[x1][y1];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class NumMatrix:
    # preSum[i][j] 记录矩阵 [0, 0, i-1, j-1] 的元素和
    def __init__(self, matrix: List[List[int]]):
        m = len(matrix)
        n = len(matrix[0])
        if m == 0 or n == 0:
            return
        # 构造前缀和矩阵
        self.preSum = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # 计算每个矩阵 [0, 0, i, j] 的元素和
                self.preSum[i][j] = (self.preSum[i - 1][j] + self.preSum[i][j - 1] +
                                     matrix[i - 1][j - 1] - self.preSum[i - 1][j - 1])

    # 计算子矩阵 [x1, y1, x2, y2] 的元素和
    def sumRegion(self, x1: int, y1: int, x2: int, y2: int) -> int:
        # 目标矩阵之和由四个相邻矩阵运算获得
        return (self.preSum[x2 + 1][y2 + 1] - self.preSum[x1][y2 + 1] -
                self.preSum[x2 + 1][y1] + self.preSum[x1][y1])
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class NumMatrix {
    // preSum[i][j] 记录矩阵 [0, 0, i-1, j-1] 的元素和
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return;
        // 构造前缀和矩阵
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i - 1][j - 1] - preSum[i-1][j-1];
            }
        }
    }

    // 计算子矩阵 [x1, y1, x2, y2] 的元素和
    public int sumRegion(int x1, int y1, int x2, int y2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return preSum[x2+1][y2+1] - preSum[x1][y2+1] - preSum[x2+1][y1] + preSum[x1][y1];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type NumMatrix struct {
    // preSum[i][j] 记录矩阵 [0, 0, i-1, j-1] 的元素和
    preSum [][]int
}

func Constructor(matrix [][]int) NumMatrix {
    m := len(matrix)
    if m == 0 {
        return NumMatrix{}
    }
    n := len(matrix[0])
    if n == 0 {
        return NumMatrix{}
    }
    // 构造前缀和矩阵
    preSum := make([][]int, m+1)
    for i := range preSum {
        preSum[i] = make([]int, n+1)
    }
    for i := 1; i <= m; i++ {
        for j := 1; j <= n; j++ {
            // 计算每个矩阵 [0, 0, i, j] 的元素和
            preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1]
        }
    }
    return NumMatrix{preSum: preSum}
}

// 计算子矩阵 [x1, y1, x2, y2] 的元素和
func (this *NumMatrix) SumRegion(x1, y1, x2, y2 int) int {
    // 目标矩阵之和由四个相邻矩阵运算获得
    return this.preSum[x2+1][y2+1] - this.preSum[x1][y2+1] - this.preSum[x2+1][y1] + this.preSum[x1][y1]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var NumMatrix = function(matrix) {
    let m = matrix.length, n = matrix[0].length;
    // preSum[i][j] 记录矩阵 [0, 0, i-1, j-1] 的元素和
    this.preSum = Array.from({length: m + 1}, () => Array(n + 1).fill(0));
    if (m == 0 || n == 0) return;
    // 构造前缀和矩阵
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            // 计算每个矩阵 [0, 0, i, j] 的元素和
            this.preSum[i][j] = this.preSum[i-1][j] + this.preSum[i][j-1] + matrix[i - 1][j - 1] - this.preSum[i-1][j-1];
        }
    }
};

NumMatrix.prototype.sumRegion = function(x1, y1, x2, y2) {
    // 计算子矩阵 [x1, y1, x2, y2] 的元素和
    // 目标矩阵之和由四个相邻矩阵运算获得
    return this.preSum[x2+1][y2+1] - this.preSum[x1][y2+1] - this.preSum[x2+1][y1] + this.preSum[x1][y1];
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_range-sum-query-2d-immutable"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_range-sum-query-2d-immutable"></div></div>
</details><hr /><br />

</div>
</details>
</div>





