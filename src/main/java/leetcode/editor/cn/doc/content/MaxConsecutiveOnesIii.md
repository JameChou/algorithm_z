<p>给定一个二进制数组&nbsp;<code>nums</code>&nbsp;和一个整数 <code>k</code>，假设最多可以翻转 <code>k</code> 个 <code>0</code> ，则返回执行操作后 <em>数组中连续 <code>1</code> 的最大个数</em> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
<strong>输出：</strong>6
<strong>解释：</strong>[1,1,1,0,0,<strong>1</strong>,1,1,1,1,<strong>1</strong>]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
<strong>输出：</strong>10
<strong>解释：</strong>[0,0,1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>nums[i]</code>&nbsp;不是&nbsp;<code>0</code>&nbsp;就是&nbsp;<code>1</code></li> 
 <li><code>0 &lt;= k &lt;= nums.length</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 前缀和 | 滑动窗口</details><br>

<div>👍 789, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题考察滑动窗口技巧，你维护一个窗口在 `nums` 上滑动，保证 `nums` 中的所有数字都被替换成 1，那么窗口可以达到的最大长度就是题目要的答案。

前文 [滑动窗口框架](https://labuladong.online/algo/essential-technique/sliding-window-framework/) 说过，使用滑动窗口算法需要搞清楚以下几个问题：

1、什么时候应该扩大窗口？

2、什么时候应该缩小窗口？

3、什么时候得到一个合法的答案？

针对本题，以上三个问题的答案是：

1、当可替换次数大于等于 0 时，扩大窗口，让进入窗口的 0 都变成 1，使得连续的 1 的长度尽可能大。

2、当可替换次数小于 0 时，缩小窗口，空余出可替换次数，以便继续扩大窗口。

3、只要可替换次数大于等于 0，窗口中的元素都会被替换成 1，也就是连续为 1 的子数组，我们想求的就是最大窗口长度。

有了这个思路，直接看代码吧。

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

class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int left = 0, right = 0;
        // 记录窗口中 1 的出现次数
        int windowOneCount = 0;
        // 记录结果长度
        int res = 0;

        // 开始滑动窗口模板
        while (right < nums.size()) {
            // 扩大窗口
            if (nums[right] == 1) {
                windowOneCount++;
            }
            right++;

            while (right - left - windowOneCount > k) {
                // 当窗口中需要替换的 0 的数量大于 k，缩小窗口
                if (nums[left] == 1) {
                    windowOneCount--;
                }
                left++;
            }
            // 此时一定是一个合法的窗口，求最大窗口长度
            res = max(res, right - left);
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
    def longestOnes(self, nums: List[int], k: int) -> int:
        left = 0
        # record the count of 1s in the window
        windowOneCount = 0
        # record the length of the result
        res = 0

        # start the sliding window template
        for right in range(len(nums)):
            # expand the window
            if nums[right] == 1:
                windowOneCount += 1
            
            # when the number of 0s that need to be replaced in the window is greater than k, shrink the window
            while right - left + 1 - windowOneCount > k:
                if nums[left] == 1:
                    windowOneCount -= 1
                left += 1
            
            # at this point, it is a valid window, calculate the maximum window length
            res = max(res, right - left + 1)
        
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        // 记录窗口中 1 的出现次数
        int windowOneCount = 0;
        // 记录结果长度
        int res = 0;

        // 开始滑动窗口模板
        while (right < nums.length) {
            // 扩大窗口
            if (nums[right] == 1) {
                windowOneCount++;
            }
            right++;

            while (right - left - windowOneCount > k) {
                // 当窗口中需要替换的 0 的数量大于 k，缩小窗口
                if (nums[left] == 1) {
                    windowOneCount--;
                }
                left++;
            }
            // 此时一定是一个合法的窗口，求最大窗口长度
            res = Math.max(res, right - left);
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

func longestOnes(nums []int, k int) int {
    left, right := 0, 0
    // 记录窗口中 1 的出现次数
    windowOneCount := 0
    // 记录结果长度
    res := 0

    // 开始滑动窗口模板
    for right < len(nums) {
        // 扩大窗口
        if nums[right] == 1 {
            windowOneCount++
        }
        right++

        for right-left-windowOneCount > k {
            // 当窗口中需要替换的 0 的数量大于 k，缩小窗口
            if nums[left] == 1 {
                windowOneCount--
            }
            left++
        }
        // 此时一定是一个合法的窗口，求最大窗口长度
        res = max(res, right-left)
    }
    return res
}

// Helper function to find the maximum of two integers
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

var longestOnes = function(nums, k) {
    let left = 0, right = 0;
    // 记录窗口中 1 的出现次数
    let windowOneCount = 0;
    // 记录结果长度
    let res = 0;

    // 开始滑动窗口模板
    while (right < nums.length) {
        // 扩大窗口
        if (nums[right] == 1) {
            windowOneCount++;
        }
        right++;

        while (right - left - windowOneCount > k) {
            // 当窗口中需要替换的 0 的数量大于 k，缩小窗口
            if (nums[left] == 1) {
                windowOneCount--;
            }
            left++;
        }
        // 此时一定是一个合法的窗口，求最大窗口长度
        res = Math.max(res, right - left);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_max-consecutive-ones-iii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_max-consecutive-ones-iii"></div></div>
</details><hr /><br />

</div>
</details>
</div>



