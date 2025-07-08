<p>给你一个整数数组 <code>nums</code> 和两个整数 <code>indexDiff</code> 和 <code>valueDiff</code> 。</p>

<p>找出满足下述条件的下标对 <code>(i, j)</code>：</p>

<ul> 
 <li><code>i != j</code>,</li> 
 <li><code>abs(i - j) &lt;= indexDiff</code></li> 
 <li><code>abs(nums[i] - nums[j]) &lt;= valueDiff</code></li> 
</ul>

<p>如果存在，返回 <code>true</code><em> ；</em>否则，返回<em> </em><code>false</code><em> </em>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
<strong>输出：</strong>true
<strong>解释：</strong>可以找出 (i, j) = (0, 3) 。
满足下述 3 个条件：
i != j --&gt; 0 != 3
abs(i - j) &lt;= indexDiff --&gt; abs(0 - 3) &lt;= 3
abs(nums[i] - nums[j]) &lt;= valueDiff --&gt; abs(1 - 1) &lt;= 0
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
<strong>输出：</strong>false
<strong>解释：</strong>尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>1 &lt;= indexDiff &lt;= nums.length</code></li> 
 <li><code>0 &lt;= valueDiff &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 桶排序 | 有序集合 | 排序 | 滑动窗口</details><br>

<div>👍 768, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题考察滑动窗口技巧。前文 [滑动窗口框架](https://labuladong.online/algo/essential-technique/sliding-window-framework/) 说过，使用滑动窗口算法需要搞清楚以下几个问题：

1、什么时候应该扩大窗口？

2、什么时候应该缩小窗口？

3、什么时候得到一个合法的答案？

针对本题，以上三个问题的答案是：

1、当窗口大小小于等于 `k` 时，扩大窗口，包含更多元素。

2、当窗口大小大于 `k` 时，缩小窗口，减少窗口元素。

3、窗口大小小于等于 `k`，且窗口中存在两个不同元素之差小于 `t` 时，找到一个答案。

那么我如何在窗口 `[left, right)` 中快速判断是否有元素之差小于 `t` 的两个元素呢？这就需要使用到 `TreeSet` 利用二叉搜索树结构寻找「地板元素」和「天花板元素」的特性了。

**详细题解**：
  - [【练习】滑动窗口算法经典习题](https://labuladong.online/algo/problem-set/sliding-window/)

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

#include <set>
#include <vector>

class Solution {
public:
    bool containsNearbyAlmostDuplicate(std::vector<int>& nums, int k, int t) {
        std::set<long> window;
        int left = 0, right = 0;
        while (right < nums.size()) {
            // 为了防止 i == j，所以在扩大窗口之前先判断是否有符合题意的索引对 (i, j)
            // 查找略大于 nums[right] 的那个元素
            auto ceiling = window.lower_bound((long)nums[right]);
            if (ceiling != window.end() && *ceiling - nums[right] <= t) {
                return true;
            }
            // 查找略小于 nums[right] 的那个元素
            auto floor = ceiling;
            if (floor != window.begin()) {
                --floor;
                if (nums[right] - *floor <= t) {
                    return true;
                }
            }

            // 扩大窗口
            window.insert(nums[right]);
            right++;

            if (right - left > k) {
                // 缩小窗口
                window.erase(nums[left]);
                left++;
            }
        }
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        from sortedcontainers import SortedList
        
        window = SortedList()
        for i in range(len(nums)):
            # 为了防止 i == j，所以在扩大窗口之前先判断是否有符合题意的索引对 (i, j)
            # 查找略大于 nums[i] 的那个元素
            pos = window.bisect_left(nums[i])
            if pos < len(window) and window[pos] - nums[i] <= t:
                return True
            # 查找略小于 nums[i] 的那个元素
            if pos > 0 and nums[i] - window[pos - 1] <= t:
                return True

            # 扩大窗口
            window.add(nums[i])

            if len(window) > k:
                # 缩小窗口
                window.remove(nums[i - k])

        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> window = new TreeSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            // 为了防止 i == j，所以在扩大窗口之前先判断是否有符合题意的索引对 (i, j)
            // 查找略大于 nums[right] 的那个元素
            Integer ceiling = window.ceiling(nums[right]);
            if (ceiling != null && (long) ceiling - nums[right] <= t) {
                return true;
            }
            // 查找略小于 nums[right] 的那个元素
            Integer floor = window.floor(nums[right]);
            if (floor != null && (long) nums[right] - floor <= t) {
                return true;
            }

            // 扩大窗口
            window.add(nums[right]);
            right++;

            if (right - left > k) {
                // 缩小窗口
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

import (
    "math"
)

func containsNearbyAlmostDuplicate(nums []int, k int, t int) bool {
    if k <= 0 || t < 0 {
        return false
    }

    getID := func(x, w int) int {
        if x >= 0 {
            return x / w
        }
        return (x+1)/w - 1
    }

    window := make(map[int]int)
    w := t + 1

    for i := 0; i < len(nums); i++ {
        m := getID(nums[i], w)

        // 为了防止 i == j，所以在扩大窗口之前先判断是否有符合题意的索引对 (i, j)
        // 查找略大于 nums[right] 的那个元素
        if _, ok := window[m]; ok {
            return true
        }
        // 查找略小于 nums[right] 的那个元素
        if v, ok := window[m-1]; ok && math.Abs(float64(nums[i]-v)) < float64(w) {
            return true
        }
        if v, ok := window[m+1]; ok && math.Abs(float64(nums[i]-v)) < float64(w) {
            return true
        }

        // 扩大窗口
        window[m] = nums[i]

        if i >= k {
            // 缩小窗口
            delete(window, getID(nums[i-k], w))
        }
    }

    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var containsNearbyAlmostDuplicate = function(nums, k, t) {
    if (k <= 0 || t < 0) return false;

    let window = new Map();
    let left = 0;

    for (let right = 0; right < nums.length; right++) {
        // 为了防止 i == j，所以在扩大窗口之前先判断是否有符合题意的索引对 (i, j)

        // 查找略大于 nums[right] 的那个元素
        let num = nums[right];
        let bucket = Math.floor(num / (t + 1));

        if (window.has(bucket)) {
            return true;
        }

        // 查找略小于 nums[right] 的那个元素
        if (window.has(bucket - 1) && Math.abs(num - window.get(bucket - 1)) <= t) {
            return true;
        }

        if (window.has(bucket + 1) && Math.abs(num - window.get(bucket + 1)) <= t) {
            return true;
        }

        // 扩大窗口
        window.set(bucket, num);

        if (right - left >= k) {
            // 缩小窗口
            window.delete(Math.floor(nums[left] / (t + 1)));
            left++;
        }
    }
    return false;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_contains-duplicate-iii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_contains-duplicate-iii"></div></div>
</details><hr /><br />

</div>
</details>
</div>





