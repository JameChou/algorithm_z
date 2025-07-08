<p>给你一个字符串 <code>s</code> 和一个整数 <code>k</code> 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 <code>k</code> 次。</p>

<p>在执行上述操作后，返回 <em>包含相同字母的最长子字符串的长度。</em></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "ABAB", k = 2
<strong>输出：</strong>4
<strong>解释：</strong>用两个'A'替换为两个'B',反之亦然。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "AABABBA", k = 1
<strong>输出：</strong>4
<strong>解释：</strong>
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
可能存在其他的方法来得到同样的结果。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>s</code> 仅由大写英文字母组成</li> 
 <li><code>0 &lt;= k &lt;= s.length</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 925, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题考察滑动窗口技巧，可以认为是上一道题 [✔ ✨1004. 最大连续1的个数 III](/problems/max-consecutive-ones-iii/) 的进阶版，建议你先去做一下上一道题。

你维护一个窗口在 `s` 上滑动，保证 `s` 中的所有字符都被替换成一样的，那么窗口的最大长度就是题目要的答案。

我们可以记录窗口中出现次数最多的字符（假设为字符 `x`，出现次数为 `windowMaxCount`），滑动窗口中的字符数量是 `right - left`，所以把所有字符都替换成 `x` 所需的替换次数就是 `right - left - windowMaxCount`。

当 `right - left - windowMaxCount <= k` 时，在可控范围内，整个窗口内的字符都可以替换成相同的；反之 `right - left - windowMaxCount > k` 时说明 `k` 次替换机会不足以使窗口内的字符全部相同，此时必须缩小窗口。

前文 [滑动窗口框架](https://labuladong.online/algo/essential-technique/sliding-window-framework/) 说过，使用滑动窗口算法需要搞清楚以下几个问题：

1、什么时候应该扩大窗口？

2、什么时候应该缩小窗口？

3、什么时候得到一个合法的答案？

针对本题，以上三个问题的答案是：

1、`right - left - windowMaxCount <= k` 时，所有进入窗口的字符都可以被替换成出现次数最多的字符 `x`，使得窗口内的所有元素都是重复的。

2、当 `right - left - windowMaxCount > k` 时，必须缩小窗口。因为此时窗口已经不合法，用尽 `k` 次替换机会也会有一个字符无法替换成 `x`。

3、只要可替换次数 `k` 大于等于 0，窗口中的字符串都可以全部替换成相同的，我们想求的是一个最大窗口长度。

可以套模板，直接看代码吧。

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
    int characterReplacement(string s, int k) {
        int left = 0, right = 0;
        // 统计窗口中每个字符的出现次数
        vector<int> windowCharCount(26, 0);
        // 记录窗口中字符的最多重复次数
        // 记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符
        int windowMaxCount = 0;
        // 记录结果长度
        int res = 0;

        // 开始滑动窗口模板
        while (right < s.length()) {
            // 扩大窗口
            int c = s[right] - 'A';
            windowCharCount[c]++;
            windowMaxCount = max(windowMaxCount, windowCharCount[c]);
            right++;

            // 这个 while 换成 if 也可以
            while (right - left - windowMaxCount > k) {
                // 杂牌字符数量 right - left - windowMaxCount 多于 k
                // 此时，k 次替换已经无法把窗口内的字符都替换成相同字符了
                // 必须缩小窗口
                windowCharCount[s[left] - 'A']--;
                left++;
            }
            // 经过收缩后，此时一定是一个合法的窗口
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
    def characterReplacement(self, s: str, k: int) -> int:
        left = 0
        right = 0
        # 统计窗口中每个字符的出现次数
        windowCharCount = [0] * 26
        # 记录窗口中字符的最多重复次数
        # 记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符
        windowMaxCount = 0
        # 记录结果长度
        res = 0

        # 开始滑动窗口模板
        while right < len(s):
            # 扩大窗口
            c = ord(s[right]) - ord('A')
            windowCharCount[c] += 1
            windowMaxCount = max(windowMaxCount, windowCharCount[c])
            right += 1

            # 这个 while 换成 if 也可以
            while right - left - windowMaxCount > k:
                # 杂牌字符数量 right - left - windowMaxCount 多于 k
                # 此时，k 次替换已经无法把窗口内的字符都替换成相同字符了
                # 必须缩小窗口
                windowCharCount[ord(s[left]) - ord('A')] -= 1
                left += 1
            # 经过收缩后，此时一定是一个合法的窗口
            res = max(res, right - left)

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        // 统计窗口中每个字符的出现次数
        int[] windowCharCount = new int[26];
        // 记录窗口中字符的最多重复次数
        // 记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符
        int windowMaxCount = 0;
        // 记录结果长度
        int res = 0;

        // 开始滑动窗口模板
        while (right < s.length()) {
            // 扩大窗口
            int c = s.charAt(right) - 'A';
            windowCharCount[c]++;
            windowMaxCount = Math.max(windowMaxCount, windowCharCount[c]);
            right++;

            // 这个 while 换成 if 也可以
            while (right - left - windowMaxCount > k) {
                // 杂牌字符数量 right - left - windowMaxCount 多于 k
                // 此时，k 次替换已经无法把窗口内的字符都替换成相同字符了
                // 必须缩小窗口
                windowCharCount[s.charAt(left) - 'A']--;
                left++;
            }
            // 经过收缩后，此时一定是一个合法的窗口
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

func characterReplacement(s string, k int) int {
    left, right := 0, 0
    // 统计窗口中每个字符的出现次数
    windowCharCount := make([]int, 26)
    // 记录窗口中字符的最多重复次数
    // 记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符
    windowMaxCount := 0
    // 记录结果长度
    res := 0

    // 开始滑动窗口模板
    for right < len(s) {
        // 扩大窗口
        c := s[right] - 'A'
        windowCharCount[c]++
        if windowCharCount[c] > windowMaxCount {
            windowMaxCount = windowCharCount[c]
        }
        right++

        // 这个 while 换成 if 也可以
        for right-left-windowMaxCount > k {
            // 杂牌字符数量 right - left - windowMaxCount 多于 k
            // 此时，k 次替换已经无法把窗口内的字符都替换成相同字符了
            // 必须缩小窗口
            windowCharCount[s[left]-'A']--
            left++
        }
        // 经过收缩后，此时一定是一个合法的窗口
        if right-left > res {
            res = right - left
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

var characterReplacement = function(s, k) {
    let left = 0, right = 0;
    // 统计窗口中每个字符的出现次数
    let windowCharCount = new Array(26).fill(0);
    // 记录窗口中字符的最多重复次数
    // 记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符
    let windowMaxCount = 0;
    // 记录结果长度
    let res = 0;

    // 开始滑动窗口模板
    while (right < s.length) {
        // 扩大窗口
        let c = s.charCodeAt(right) - 'A'.charCodeAt(0);
        windowCharCount[c]++;
        windowMaxCount = Math.max(windowMaxCount, windowCharCount[c]);
        right++;

        // 这个 while 换成 if 也可以
        while (right - left - windowMaxCount > k) {
            // 杂牌字符数量 right - left - windowMaxCount 多于 k
            // 此时，k 次替换已经无法把窗口内的字符都替换成相同字符了
            // 必须缩小窗口
            windowCharCount[s.charCodeAt(left) - 'A'.charCodeAt(0)]--;
            left++;
        }
        // 经过收缩后，此时一定是一个合法的窗口
        res = Math.max(res, right - left);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_longest-repeating-character-replacement"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-repeating-character-replacement"></div></div>
</details><hr /><br />

</div>
</details>
</div>

