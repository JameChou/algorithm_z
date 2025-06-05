<p>给你一个有序数组 <code>nums</code> ，请你<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 删除重复出现的元素，使得出现次数超过两次的元素<strong>只出现两次</strong> ，返回删除后数组的新长度。</p>

<p>不要使用额外的数组空间，你必须在 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地 </a>修改输入数组 </strong>并在使用 O(1) 额外空间的条件下完成。</p>

<p>&nbsp;</p>

<p><strong>说明：</strong></p>

<p>为什么返回数值是整数，但输出的答案是数组呢？</p>

<p>请注意，输入数组是以<strong>「引用」</strong>方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。</p>

<p>你可以想象内部操作如下:</p>

<pre>
// <strong>nums</strong> 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中<strong> 该长度范围内</strong> 的所有元素。
for (int i = 0; i &lt; len; i++) {
&nbsp; &nbsp; print(nums[i]);
}
</pre>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1,2,2,3]
<strong>输出：</strong>5, nums = [1,1,2,2,3]
<strong>解释：</strong>函数应返回新长度 length = <strong><code>5</code></strong>, 并且原数组的前五个元素被修改为 <strong><code>1, 1, 2, 2, 3</code></strong>。 不需要考虑数组中超出新长度后面的元素。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,1,1,1,1,2,3,3]
<strong>输出：</strong>7, nums = [0,0,1,1,2,3,3]
<strong>解释：</strong>函数应返回新长度 length = <strong><code>7</code></strong>, 并且原数组的前七个元素被修改为&nbsp;<strong><code>0, 0, 1, 1, 2, 3, 3</code></strong>。不需要考虑数组中超出新长度后面的元素。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> 已按升序排列</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 1272, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题和前文 [数组双指针技巧汇总](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中讲的 [✔ ✨26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array/) 解法非常类似，只不过这道题说重复两次以上的元素才需要被去除。

本题解法依然使用快慢指针技巧，在之前的解法中添加一个 `count` 变量记录每个数字重复出现的次数，然后把 26 题的 if 判断额外复制粘贴一份就行了，直接看代码吧。

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
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        // 快慢指针，维护 nums[0..slow] 为结果子数组
        int slow = 0, fast = 0;
        // 记录一个元素重复的次数
        int count = 0;
        while (fast < nums.size()) {
            if (nums[fast] != nums[slow]) {
                // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast < nums.size() && nums[fast] != nums[fast - 1]) {
                // fast 遇到新的不同的元素时，重置 count
                count = 0;
            }
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        # 快慢指针，维护 nums[0..slow] 为结果子数组
        slow = 0
        fast = 0
        # 记录一个元素重复的次数
        count = 0
        while fast < len(nums):
            if nums[fast] != nums[slow]:
                # 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
                slow += 1
                nums[slow] = nums[fast]
            elif slow < fast and count < 2:
                # 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
                slow += 1
                nums[slow] = nums[fast]
            fast += 1
            count += 1
            if fast < len(nums) and nums[fast] != nums[fast - 1]:
                # fast 遇到新的不同的元素时，重置 count
                count = 0
        # 数组长度为索引 + 1
        return slow + 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 快慢指针，维护 nums[0..slow] 为结果子数组
        int slow = 0, fast = 0;
        // 记录一个元素重复的次数
        int count = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                // fast 遇到新的不同的元素时，重置 count
                count = 0;
            }
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func removeDuplicates(nums []int) int {
    if len(nums) == 0 {
        return 0
    }
    // 快慢指针，维护 nums[0..slow] 为结果子数组
    slow, fast := 0, 0
    // 记录一个元素重复的次数
    count := 0
    for fast < len(nums) {
        if nums[fast] != nums[slow] {
            // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
            slow++
            nums[slow] = nums[fast]
        } else if slow < fast && count < 2 {
            // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
            slow++
            nums[slow] = nums[fast]
        }
        fast++
        count++
        if fast < len(nums) && nums[fast] != nums[fast-1] {
            // fast 遇到新的不同的元素时，重置 count
            count = 0
        }
    }
    // 数组长度为索引 + 1
    return slow + 1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var removeDuplicates = function(nums) {
    if (nums.length === 0) {
        return 0;
    }
    // 快慢指针，维护 nums[0..slow] 为结果子数组
    let slow = 0, fast = 0;
    // 记录一个元素重复的次数
    let count = 0;
    while (fast < nums.length) {
        if (nums[fast] !== nums[slow]) {
            // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
            slow++;
            nums[slow] = nums[fast];
        } else if (slow < fast && count < 2) {
            // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
            slow++;
            nums[slow] = nums[fast];
        }
        fast++;
        count++;
        if (fast < nums.length && nums[fast] !== nums[fast - 1]) {
            // fast 遇到新的不同的元素时，重置 count
            count = 0;
        }
    }
    // 数组长度为索引 + 1
    return slow + 1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_remove-duplicates-from-sorted-array-ii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-array-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>











