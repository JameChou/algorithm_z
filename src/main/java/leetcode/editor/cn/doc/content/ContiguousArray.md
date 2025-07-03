<p>给定一个二进制数组 <code>nums</code> , 找到含有相同数量的 <code>0</code> 和 <code>1</code> 的最长连续子数组，并返回该子数组的长度。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>2
<strong>说明：</strong>[0, 1] 是具有相同数量 0 和 1 的最长连续子数组。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,0]
<strong>输出：</strong>2
<strong>说明：</strong>[0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>nums = [0,1,1,1,1,1,0,0,0]
<b>输出：</b>6
<b>解释：</b>[1,1,1,0,0,0] 是具有相同数量 0 和 1 的最长连续子数组。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>nums[i]</code> 不是 <code>0</code> 就是 <code>1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 前缀和</details><br>

<div>👍 790, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

首先，我们做一个等价，题目让你找 `0` 和 `1` 数量相同的最长子数组，**如果我们把 `0` 视作 `-1`，就把题目转变成了：寻找和为 0 的最长子数组**。

涉及到和为 `xxx` 的子数组，就是要考察 [前缀和技巧](https://labuladong.online/algo/data-structure/prefix-sum/) 和哈希表的结合使用了。

求和为 0 的最长子数组，相当于让你去 `preSum` 数组中找 `i, j`，使得 `preSum[i] - preSum[j] == 0`，其中 `i > j` 且 `i - j` 要尽可能大。

那么我们用一个哈希表 `valToIndex` 存储前缀和到索引的映射，给定任意 `preSum[i]`，我们都能通过 `valToIndex` 快速判断是否存在 `j`，使得 `preSum[i] - preSum[j] == 0`。

值得一提的是，我给的解法中 `preSum` 数组可以进一步简化成变量，这个优化可以留给你来做。

**详细题解**：
  - [【练习】前缀和技巧经典习题](https://labuladong.online/algo/problem-set/perfix-sum/)

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
using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n = nums.size();
        vector<int> preSum(n + 1, 0);
        // 计算 nums 的前缀和
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
        }
        // 前缀和到索引的映射，方便快速查找所需的前缀和
        unordered_map<int, int> valToIndex;
        int res = 0;
        for (int i = 0; i < preSum.size(); i++) {
            // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
            if (valToIndex.find(preSum[i]) == valToIndex.end()) {
                valToIndex[preSum[i]] = i;
            } else {
                // 这个前缀和已经出现过了，则找到一个和为 0 的子数组
                res = max(res, i - valToIndex[preSum[i]]);
            }
            // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
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
    def findMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        preSum = [0] * (n + 1)
        # 计算 nums 的前缀和
        for i in range(n):
            preSum[i + 1] = preSum[i] + (-1 if nums[i] == 0 else 1)
        # 前缀和到索引的映射，方便快速查找所需的前缀和
        val_to_index = {}
        res = 0
        for i in range(len(preSum)):
            # 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
            if preSum[i] not in val_to_index:
                val_to_index[preSum[i]] = i
            else:
                # 这个前缀和已经出现过了，则找到一个和为 0 的子数组
                res = max(res, i - val_to_index[preSum[i]])
            # 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        // 计算 nums 的前缀和
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
        }
        // 前缀和到索引的映射，方便快速查找所需的前缀和
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        int res = 0;
        for (int i = 0; i < preSum.length; i++) {
            // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
            if (!valToIndex.containsKey(preSum[i])) {
                valToIndex.put(preSum[i], i);
            } else {
                // 这个前缀和已经出现过了，则找到一个和为 0 的子数组
                res = Math.max(res, i - valToIndex.get(preSum[i]));
            }
            // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
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

func findMaxLength(nums []int) int {
    n := len(nums)
    preSum := make([]int, n+1)
    preSum[0] = 0
    // 计算 nums 的前缀和
    for i := 0; i < n; i++ {
        if nums[i] == 0 {
            preSum[i+1] = preSum[i] - 1
        } else {
            preSum[i+1] = preSum[i] + 1
        }
    }
    // 前缀和到索引的映射，方便快速查找所需的前缀和
    valToIndex := make(map[int]int)
    res := 0
    for i := 0; i < len(preSum); i++ {
        // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
        if _, ok := valToIndex[preSum[i]]; !ok {
            valToIndex[preSum[i]] = i
        } else {
            // 这个前缀和已经出现过了，则找到一个和为 0 的子数组
            res = max(res, i - valToIndex[preSum[i]])
        }
        // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var findMaxLength = function(nums) {
    let n = nums.length;
    let preSum = new Array(n + 1).fill(0);
    // 计算 nums 的前缀和
    for (let i = 0; i < n; i++) {
        preSum[i + 1] = preSum[i] + (nums[i] === 0 ? -1 : 1);
    }
    // 前缀和到索引的映射，方便快速查找所需的前缀和
    let valToIndex = new Map();
    let res = 0;
    for (let i = 0; i < preSum.length; i++) {
        // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
        if (!valToIndex.has(preSum[i])) {
            valToIndex.set(preSum[i], i);
        } else {
            // 这个前缀和已经出现过了，则找到一个和为 0 的子数组
            res = Math.max(res, i - valToIndex.get(preSum[i]));
        }
        // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_contiguous-array"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_contiguous-array"></div></div>
</details><hr /><br />

</div>
</details>
</div>

