<p>给你一个整数数组&nbsp;<code>nums</code>，返回 数组&nbsp;<code>answer</code>&nbsp;，其中&nbsp;<code>answer[i]</code>&nbsp;等于&nbsp;<code>nums</code>&nbsp;中除&nbsp;<code>nums[i]</code>&nbsp;之外其余各元素的乘积&nbsp;。</p>

<p>题目数据 <strong>保证</strong> 数组&nbsp;<code>nums</code>之中任意元素的全部前缀元素和后缀的乘积都在&nbsp; <strong>32 位</strong> 整数范围内。</p>

<p>请&nbsp;<strong>不要使用除法，</strong>且在&nbsp;<code>O(n)</code> 时间复杂度内完成此题。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = <span><code>[1,2,3,4]</code></span>
<strong>输出:</strong> <span><code>[24,12,8,6]</code></span>
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = [-1,1,0,-3,3]
<strong>输出:</strong> [0,0,9,0,0]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-30 &lt;= nums[i] &lt;= 30</code></li> 
 <li>输入&nbsp;<strong>保证</strong> 数组&nbsp;<code>answer[i]</code>&nbsp;在&nbsp; <strong>32 位</strong> 整数范围内</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以在 <code>O(1)</code>&nbsp;的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组&nbsp;<strong>不被视为&nbsp;</strong>额外空间。）</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>

<div>👍 2048, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题和 [前缀和数组技巧](https://labuladong.online/algo/data-structure/prefix-sum/) 有些类似，前缀和数组中两个元素之差是子数组元素之和，那么如果构造「前缀积」数组，两个元素相除就是子数组元素之和。

所以我们构造一个 `prefix` 数组记录「前缀积」，再用一个 `suffix` 记录「后缀积」，根据前缀和后缀积就能计算除了当前元素之外其他元素的积。

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

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
        vector<int> prefix(n);
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
        vector<int> suffix(n);
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        // 结果数组
        vector<int> res(n);
        res[0] = suffix[1];
        res[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; i++) {
            // 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
            res[i] = prefix[i - 1] * suffix[i + 1];
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
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
        prefix = [0] * n
        prefix[0] = nums[0]
        for i in range(1, n):
            prefix[i] = prefix[i - 1] * nums[i]
        
        # 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
        suffix = [0] * n
        suffix[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            suffix[i] = suffix[i + 1] * nums[i]
        
        # 结果数组
        res = [0] * n
        res[0] = suffix[1]
        res[n - 1] = prefix[n - 2]
        for i in range(1, n - 1):
            # 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
            res[i] = prefix[i - 1] * suffix[i + 1]
        
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        // 结果数组
        int[] res = new int[n];
        res[0] = suffix[1];
        res[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; i++) {
            // 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
            res[i] = prefix[i - 1] * suffix[i + 1];
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

func productExceptSelf(nums []int) []int {
    n := len(nums)
    // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
    prefix := make([]int, n)
    prefix[0] = nums[0]
    for i := 1; i < n; i++ {
        prefix[i] = prefix[i-1] * nums[i]
    }
    // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
    suffix := make([]int, n)
    suffix[n-1] = nums[n-1]
    for i := n - 2; i >= 0; i-- {
        suffix[i] = suffix[i+1] * nums[i]
    }
    // 结果数组
    res := make([]int, n)
    res[0] = suffix[1]
    res[n-1] = prefix[n-2]
    for i := 1; i < n-1; i++ {
        // 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
        res[i] = prefix[i-1] * suffix[i+1]
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var productExceptSelf = function(nums) {
    let n = nums.length;
    // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
    let prefix = new Array(n);
    prefix[0] = nums[0];
    for (let i = 1; i < nums.length; i++) {
        prefix[i] = prefix[i - 1] * nums[i];
    }
    // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
    let suffix = new Array(n);
    suffix[n - 1] = nums[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        suffix[i] = suffix[i + 1] * nums[i];
    }
    // 结果数组
    let res = new Array(n);
    res[0] = suffix[1];
    res[n - 1] = prefix[n - 2];
    for (let i = 1; i < n - 1; i++) {
        // 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
        res[i] = prefix[i - 1] * suffix[i + 1];
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_product-of-array-except-self"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_product-of-array-except-self"></div></div>
</details><hr /><br />

</div>
</details>
</div>

