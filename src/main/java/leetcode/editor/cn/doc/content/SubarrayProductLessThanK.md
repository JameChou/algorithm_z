给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> ，请你返回子数组内所有元素的乘积严格小于<em> </em><code>k</code> 的连续子数组的数目。

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [10,5,2,6], k = 100
<strong>输出：</strong>8
<strong>解释：</strong>8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], k = 0
<strong>输出：</strong>0</pre>

<p>&nbsp;</p>

<p><strong>提示:&nbsp;</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 1000</code></li> 
 <li><code>0 &lt;= k &lt;= 10<sup>6</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 前缀和 | 滑动窗口</details><br>

<div>👍 865, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题考察滑动窗口技巧，你维护一个窗口在 `nums` 上滑动，然后计算那些元素之积小于 `k` 的窗口个数即可。

前文 [滑动窗口框架](https://labuladong.online/algo/essential-technique/sliding-window-framework/) 说过，使用滑动窗口算法需要搞清楚以下几个问题：

1、什么时候应该扩大窗口？

2、什么时候应该缩小窗口？

3、什么时候得到一个合法的答案？

针对本题，以上三个问题的答案是：

1、当窗口元素之积小于 `k` 时，扩大窗口，让积更大一些。

2、当窗口元素之积大于 `k` 时，缩小窗口，让积更小一些。

3、当窗口元素之积小于 `k` 时，窗口内元素的所有子数组都是合法子数组。

注意：之所以本题可以用滑动窗口，关键是题目说了 `nums` 中的元素都是正数，这就保证了只要有元素加入窗口，积一定变大，只要有元素离开窗口，积一定变小。

你想想如果存在负数的话就没有这个性质了，也就不能确定什么时候扩大和缩小窗口，也就不能使用滑动窗口算法，而应该使用前缀积 + 哈希表的算法，类似的题目参见 [✨560. 和为K的子数组](/problems/subarray-sum-equals-k/)。

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
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int left = 0, right = 0;
        // 滑动窗口，初始化为乘法单位元
        int windowProduct = 1;
        // 记录符合条件的子数组个数
        int count = 0;

        while (right < nums.size()) {
            // 扩大窗口，并更新窗口数据
            windowProduct *= nums[right];
            right++;

            while (left < right && windowProduct >= k) {
                // 缩小窗口，并更新窗口数据
                windowProduct /= nums[left];
                left++;
            }
            // 现在必然是一个合法的窗口，但注意思考这个窗口中的子数组个数怎么计算：
            // 比方说 left = 1, right = 4 划定了 [1, 2, 3] 这个窗口（right 是开区间）
            // 但不止 [left..right] 是合法的子数组，[left+1..right], [left+2..right] 等都是合法子数组
            // 所以我们需要把 [3], [2,3], [1,2,3] 这 right - left 个子数组都加上
            count += right - left;
        }

        return count;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def numSubarrayProductLessThanK(self, nums, k):
        left = 0
        right = 0
        # 滑动窗口，初始化为乘法单位元
        windowProduct = 1
        # 记录符合条件的子数组个数
        count = 0

        while right < len(nums):
            # 扩大窗口，并更新窗口数据
            windowProduct *= nums[right]
            right += 1

            while left < right and windowProduct >= k:
                # 缩小窗口，并更新窗口数据
                windowProduct //= nums[left]
                left += 1

            # 现在必然是一个合法的窗口，但注意思考这个窗口中的子数组个数怎么计算：
            # 比方说 left = 1, right = 4 划定了 [1, 2, 3] 这个窗口（right 是开区间）
            # 但不止 [left..right] 是合法的子数组，[left+1..right], [left+2..right] 等都是合法子数组
            # 所以我们需要把 [3], [2,3], [1,2,3] 这 right - left 个子数组都加上
            count += right - left

        return count
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        // 滑动窗口，初始化为乘法单位元
        int windowProduct = 1;
        // 记录符合条件的子数组个数
        int count = 0;

        while (right < nums.length) {
            // 扩大窗口，并更新窗口数据
            windowProduct = windowProduct * nums[right];
            right++;

            while (left < right && windowProduct >= k) {
                // 缩小窗口，并更新窗口数据
                windowProduct = windowProduct / nums[left];
                left++;
            }
            // 现在必然是一个合法的窗口，但注意思考这个窗口中的子数组个数怎么计算：
            // 比方说 left = 1, right = 4 划定了 [1, 2, 3] 这个窗口（right 是开区间）
            // 但不止 [left..right] 是合法的子数组，[left+1..right], [left+2..right] 等都是合法子数组
            // 所以我们需要把 [3], [2,3], [1,2,3] 这 right - left 个子数组都加上
            count += right - left;
        }

        return count;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func numSubarrayProductLessThanK(nums []int, k int) int {
    left, right := 0, 0
    // 滑动窗口，初始化为乘法单位元
    windowProduct := 1
    // 记录符合条件的子数组个数
    count := 0

    for right < len(nums) {
        // 扩大窗口，并更新窗口数据
        windowProduct *= nums[right]
        right++

        for left < right && windowProduct >= k {
            // 缩小窗口，并更新窗口数据
            windowProduct /= nums[left]
            left++
        }
        // 现在必然是一个合法的窗口，但注意思考这个窗口中的子数组个数怎么计算：
        // 比方说 left = 1, right = 4 划定了 [1, 2, 3] 这个窗口（right 是开区间）
        // 但不止 [left..right] 是合法的子数组，[left+1..right], [left+2..right] 等都是合法子数组
        // 所以我们需要把 [3], [2,3], [1,2,3] 这 right - left 个子数组都加上
        count += right - left
    }

    return count
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var numSubarrayProductLessThanK = function(nums, k) {
    let left = 0, right = 0;
    // 滑动窗口，初始化为乘法单位元
    let windowProduct = 1;
    // 记录符合条件的子数组个数
    let count = 0;

    while (right < nums.length) {
        // 扩大窗口，并更新窗口数据
        windowProduct *= nums[right];
        right++;

        while (left < right && windowProduct >= k) {
            // 缩小窗口，并更新窗口数据
            windowProduct /= nums[left];
            left++;
        }
        // 现在必然是一个合法的窗口，但注意思考这个窗口中的子数组个数怎么计算：
        // 比方说 left = 1, right = 4 划定了 [1, 2, 3] 这个窗口（right 是开区间）
        // 但不止 [left..right] 是合法的子数组，[left+1..right], [left+2..right] 等都是合法子数组
        // 所以我们需要把 [3], [2,3], [1,2,3] 这 right - left 个子数组都加上
        count += right - left;
    }

    return count;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_subarray-product-less-than-k"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_subarray-product-less-than-k"></div></div>
</details><hr /><br />

</div>
</details>
</div>



