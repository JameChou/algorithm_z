<p>给你一个整数数组&nbsp;<code>nums</code> 和一个整数&nbsp;<code>k</code> ，判断数组中是否存在两个 <strong>不同的索引</strong><em>&nbsp;</em><code>i</code>&nbsp;和<em>&nbsp;</em><code>j</code> ，满足 <code>nums[i] == nums[j]</code> 且 <code>abs(i - j) &lt;= k</code> 。如果存在，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1], k<em> </em>= 3
<strong>输出：</strong>true</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,0,1,1], k<em> </em>=<em> </em>1
<strong>输出：</strong>true</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1,2,3], k<em> </em>=<em> </em>2
<strong>输出：</strong>false</pre>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>0 &lt;= k &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 滑动窗口</details><br>

<div>👍 805, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题考察滑动窗口技巧，你维护一个大小为 `k` 的滑动窗口滑过整个数组，滑动的过程中计算窗口中是否存在重复元素。

前文 [滑动窗口框架](https://labuladong.online/algo/essential-technique/sliding-window-framework/) 说过，使用滑动窗口算法需要搞清楚以下几个问题：

1、什么时候应该扩大窗口？

2、什么时候应该缩小窗口？

3、什么时候得到一个合法的答案？

本题很简单直接，以上三个问题的答案是：

1、当窗口大小小于 `k` 时，扩大窗口。

2、当窗口大小大于 `k` 时，缩小窗口。

3、当窗口大小等于 `k` 且发现窗口中存在重复元素时，返回 true。

直接看代码吧。

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

#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        int left = 0, right = 0;
        unordered_set<int> window;
        // 滑动窗口算法框架，维护一个大小为 k 的窗口
        while (right < nums.size()) {
            // 扩大窗口
            if (window.find(nums[right]) != window.end()) {
                return true;
            }
            window.insert(nums[right]);
            right++;

            if (right - left > k) {
                // 当窗口的大小大于 k 时，缩小窗口
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
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        left = 0
        right = 0
        window = set()
        # 滑动窗口算法框架，维护一个大小为 k 的窗口
        while right < len(nums):
            # 扩大窗口
            if nums[right] in window:
                return True
            window.add(nums[right])
            right += 1

            if right - left > k:
                # 当窗口的大小大于 k 时，缩小窗口
                window.remove(nums[left])
                left += 1

        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0, right = 0;
        HashSet<Integer> window = new HashSet<>();
        // 滑动窗口算法框架，维护一个大小为 k 的窗口
        while (right < nums.length) {
            // 扩大窗口
            if (window.contains(nums[right])) {
                return true;
            }
            window.add(nums[right]);
            right++;

            if (right - left > k) {
                // 当窗口的大小大于 k 时，缩小窗口
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

func containsNearbyDuplicate(nums []int, k int) bool {
    left, right := 0, 0
    window := make(map[int]bool)
    // 滑动窗口算法框架，维护一个大小为 k 的窗口
    for right < len(nums) {
        // 扩大窗口
        if window[nums[right]] {
            return true
        }
        window[nums[right]] = true
        right++

        if right-left > k {
            // 当窗口的大小大于 k 时，缩小窗口
            delete(window, nums[left])
            left++
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

var containsNearbyDuplicate = function(nums, k) {
    let left = 0, right = 0;
    const window = new Set();
    // 滑动窗口算法框架，维护一个大小为 k 的窗口
    while (right < nums.length) {
        // 扩大窗口
        if (window.has(nums[right])) {
            return true;
        }
        window.add(nums[right]);
        right++;

        if (right - left > k) {
            // 当窗口的大小大于 k 时，缩小窗口
            window.delete(nums[left]);
            left++;
        }
    }
    return false;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_contains-duplicate-ii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_contains-duplicate-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>



