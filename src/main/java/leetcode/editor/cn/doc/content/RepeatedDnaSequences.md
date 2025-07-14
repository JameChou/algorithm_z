<p><strong>DNA序列</strong>&nbsp;由一系列核苷酸组成，缩写为
 <meta charset="UTF-8" />&nbsp;<code>'A'</code>,&nbsp;<code>'C'</code>,&nbsp;<code>'G'</code>&nbsp;和
 <meta charset="UTF-8" />&nbsp;<code>'T'</code>.。</p>

<ul> 
 <li>例如，
  <meta charset="UTF-8" /><code>"ACGAATTCCG"</code>&nbsp;是一个 <strong>DNA序列</strong> 。</li> 
</ul>

<p>在研究 <strong>DNA</strong> 时，识别 DNA 中的重复序列非常有用。</p>

<p>给定一个表示 <strong>DNA序列</strong> 的字符串 <code>s</code> ，返回所有在 DNA 分子中出现不止一次的&nbsp;<strong>长度为&nbsp;<code>10</code></strong>&nbsp;的序列(子字符串)。你可以按 <strong>任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
<strong>输出：</strong>["AAAAACCCCC","CCCCCAAAAA"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "AAAAAAAAAAAAA"
<strong>输出：</strong>["AAAAAAAAAA"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= s.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>s[i]</code><code>==</code><code>'A'</code>、<code>'C'</code>、<code>'G'</code>&nbsp;or&nbsp;<code>'T'</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>位运算 | 哈希表 | 字符串 | 滑动窗口 | 哈希函数 | 滚动哈希</details><br>

<div>👍 619, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/rabinkarp/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题的思路很简单，维护一个长度为 10 的滑动窗口从 `s` 中滑过，记录重复的子串即可。

由于题目说了只需寻找长度为 10 的子串，所以这个算法的复杂度是 `10N = O(N)`，当然，直接用 `substring` 方法截取子字符串的效率并不高，如果让你找更长的重复序列的话，这种简单粗暴的算法就有点吃力了。

可以发现，时间复杂度主要消耗在了截取子字符串上，截取子串的目的是为了借助哈希集合来判断子串是否重复，那么有没有更快的方法来判断子串是否重复，且避免子字符串的截取呢？

有的，更好的办法是 [Rabin-Karp 滚动哈希算法](https://labuladong.online/algo/practice-in-action/rabinkarp/)，一边移动滑动窗口一边快速计算窗口内字符串的哈希值，见详细题解。

**详细题解**：
  - [滑动窗口延伸：Rabin Karp 字符匹配算法](https://labuladong.online/algo/practice-in-action/rabinkarp/)

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
#include <string>
#include <unordered_set>
using namespace std;

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        int n = s.length();
        unordered_set<string> seen;
        // 记录那些重复出现的序列，
        // 注意要用哈希集合，防止出现重复的结果
        unordered_set<string> dup;

        for (int i = 0; i + 10 <= n; i++) {
            string seq = s.substr(i, 10);
            if (seen.count(seq)){
                // 找到一个重复的
                dup.insert(seq);
            }
            seen.insert(seq);
        }
        return vector<string>(dup.begin(), dup.end());
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        n = len(s)
        seen = set()
        # 记录那些重复出现的序列，
        # 注意要用哈希集合，防止出现重复的结果
        dup = set()

        for i in range(n - 9):
            seq = s[i:i + 10]
            if seq in seen:
                # 找到一个重复的
                dup.add(seq)
            seen.add(seq)
        
        return list(dup)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> seen = new HashSet();
        // 记录那些重复出现的序列，
        // 注意要用哈希集合，防止出现重复的结果
        HashSet<String> dup = new HashSet<>();

        for (int i = 0; i + 10 <= n; i++) {
            String seq = s.substring(i, i + 10);
            if (seen.contains(seq)){
                // 找到一个重复的
                dup.add(seq);
            }
            seen.add(seq);
        }
        return new LinkedList<>(dup);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func findRepeatedDnaSequences(s string) []string {
    n := len(s)
    seen := make(map[string]struct{})
    // 记录那些重复出现的序列，
    // 注意要用哈希集合，防止出现重复的结果
    dup := make(map[string]struct{})

    for i := 0; i+10 <= n; i++ {
        seq := s[i : i+10]
        if _, found := seen[seq]; found {
            // 找到一个重复的
            dup[seq] = struct{}{}
        }
        seen[seq] = struct{}{}
    }

    result := make([]string, 0, len(dup))
    for seq := range dup {
        result = append(result, seq)
    }
    return result
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var findRepeatedDnaSequences = function(s) {
    let n = s.length;
    let seen = new Set();
    // 记录那些重复出现的序列，
    // 注意要用哈希集合，防止出现重复的结果
    let dup = new Set();

    for (let i = 0; i + 10 <= n; i++) {
        let seq = s.substring(i, i + 10);
        if (seen.has(seq)){
            // 找到一个重复的
            dup.add(seq);
        }
        seen.add(seq);
    }
    return Array.from(dup);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_repeated-dna-sequences"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_repeated-dna-sequences"></div></div>
</details><hr /><br />

</div>
</details>
</div>

