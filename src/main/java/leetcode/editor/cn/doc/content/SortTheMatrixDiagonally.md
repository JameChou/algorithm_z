<p><strong>矩阵对角线</strong> 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 <code>mat</code> 有 <code>6</code> 行 <code>3</code> 列，从 <code>mat[2][0]</code> 开始的 <strong>矩阵对角线</strong> 将会经过 <code>mat[2][0]</code>、<code>mat[3][1]</code> 和 <code>mat[4][2]</code> 。</p>

<p>给你一个&nbsp;<code>m * n</code>&nbsp;的整数矩阵&nbsp;<code>mat</code>&nbsp;，请你将同一条 <strong>矩阵对角线 </strong>上的元素按升序排序后，返回排好序的矩阵。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/25/1482_example_1_2.png" style="height: 198px; width: 500px;" /></p>

<pre>
<strong>输入：</strong>mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
<strong>输出：</strong>[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
<strong>输出：</strong>[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m ==&nbsp;mat.length</code></li> 
 <li><code>n ==&nbsp;mat[i].length</code></li> 
 <li><code>1 &lt;= m, n&nbsp;&lt;= 100</code></li> 
 <li><code>1 &lt;= mat[i][j] &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 排序</details><br>

<div>👍 141, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题非常有意思，按照对角线操作二维数组是需要技巧的，即你如何快速判断两个元素坐标是否在同一个对角线上？

**直接说结论：在同一个对角线上的元素，其横纵坐标之差是相同的**。你画图看看，或者稍微想想就能明白：右下角走一步横纵坐标都会加一，所以他们的差肯定不会变。

有了这个规律辅助，这道题就很容易做了，我直接用一个哈希表把每个对角线的元素存起来，想办法排序，最后放回二维矩阵上即可。

如何排序数组呢？借助有序数据结构或者用标准库的排序函数都行，这里我就用标准库的排序函数好了，不过考虑到数组的操作效率，所以我需要从最后删除元素。

具体的解法看代码吧，更多有技巧性的二维矩阵操作参见 [二维数组的花式遍历](https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/)。

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

#include <vector>
#include <unordered_map>
#include <algorithm>
#include <list>

class Solution {
public:
    std::vector<std::vector<int>> diagonalSort(std::vector<std::vector<int>>& mat) {
        int m = mat.size(), n = mat[0].size();

        // 存储所有对角线的元素列表
        std::unordered_map<int, std::list<int>> diagonals;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 横纵坐标之差可以作为一条对角线的 ID
                int diagonalID = i - j;
                diagonals[diagonalID].push_back(mat[i][j]);
            }
        }

        // 从数组末尾删除元素效率较高，所以我们把 ArrayList 倒序排序
        for (auto& diagonal : diagonals) {
            diagonal.second.sort(std::greater<int>());
        }

        // 把排序结果回填二维矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                std::list<int>& diagonal = diagonals[i - j];
                mat[i][j] = diagonal.back();
                diagonal.pop_back();
            }
        }

        return mat;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])

        # 存储所有对角线的元素列表
        diagonals = {}

        for i in range(m):
            for j in range(n):
                # 横纵坐标之差可以作为一条对角线的 ID
                diagonalID = i - j
                if diagonalID not in diagonals:
                    diagonals[diagonalID] = []
                diagonals[diagonalID].append(mat[i][j])

        # 从数组末尾删除元素效率较高，所以我们把 ArrayList 倒序排序
        for diagonal in diagonals.values():
            diagonal.sort(reverse=True)

        # 把排序结果回填二维矩阵
        for i in range(m):
            for j in range(n):
                diagonal = diagonals[i - j]
                mat[i][j] = diagonal.pop()

        return mat
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        // 存储所有对角线的元素列表
        HashMap<Integer, ArrayList<Integer>> diagonals = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 横纵坐标之差可以作为一条对角线的 ID
                int diagonalID = i - j;
                diagonals.putIfAbsent(diagonalID, new ArrayList<>());
                diagonals.get(diagonalID).add(mat[i][j]);
            }
        }

        // 从数组末尾删除元素效率较高，所以我们把 ArrayList 倒序排序
        for (List<Integer> diagonal: diagonals.values()) {
            Collections.sort(diagonal, Collections.reverseOrder());
        }

        // 把排序结果回填二维矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> diagonal = diagonals.get(i - j);
                mat[i][j] = diagonal.remove(diagonal.size() - 1);
            }
        }

        return mat;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func diagonalSort(mat [][]int) [][]int {
    m, n := len(mat), len(mat[0])

    // 存储所有对角线的元素列表
    diagonals := make(map[int][]int)

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            // 横纵坐标之差可以作为一条对角线的 ID
            diagonalID := i - j
            diagonals[diagonalID] = append(diagonals[diagonalID], mat[i][j])
        }
    }

    // 从数组末尾删除元素效率较高，所以我们把 ArrayList 倒序排序
    for _, diagonal := range diagonals {
        sort.Slice(diagonal, func(i, j int) bool {
            return diagonal[i] > diagonal[j]
        })
    }

    // 把排序结果回填二维矩阵
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            diagonalID := i - j
            mat[i][j] = diagonals[diagonalID][len(diagonals[diagonalID])-1]
            diagonals[diagonalID] = diagonals[diagonalID][:len(diagonals[diagonalID])-1]
        }
    }

    return mat
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var diagonalSort = function(mat) {
    let m = mat.length, n = mat[0].length;

    // 存储所有对角线的元素列表
    let diagonals = new Map();

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            // 横纵坐标之差可以作为一条对角线的 ID
            let diagonalID = i - j;
            if (!diagonals.has(diagonalID)) {
                diagonals.set(diagonalID, []);
            }
            diagonals.get(diagonalID).push(mat[i][j]);
        }
    }

    // 从数组末尾删除元素效率较高，所以我们把 ArrayList 倒序排序
    for (let diagonal of diagonals.values()) {
        diagonal.sort((a, b) => b - a);
    }

    // 把排序结果回填二维矩阵
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let diagonal = diagonals.get(i - j);
            mat[i][j] = diagonal.pop();
        }
    }

    return mat;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_sort-the-matrix-diagonally"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_sort-the-matrix-diagonally"></div></div>
</details><hr /><br />

</div>
</details>
</div>

