<p><strong>累加数</strong> 是一个字符串，组成它的数字可以形成累加序列。</p>

<p>一个有效的 <strong>累加序列</strong> 必须<strong> 至少 </strong>包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。</p>

<p>给你一个只包含数字&nbsp;<code>'0'-'9'</code>&nbsp;的字符串，编写一个算法来判断给定输入是否是 <strong>累加数</strong> 。如果是，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p><strong>说明：</strong>累加序列里的数，除数字 0 之外，<strong>不会</strong> 以 0 开头，所以不会出现&nbsp;<code>1, 2, 03</code> 或者&nbsp;<code>1, 02, 3</code>&nbsp;的情况。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong><span><code>"112358"</code></span>
<strong>输出：</strong>true 
<strong>解释：</strong>累加序列为: <span><code>1, 1, 2, 3, 5, 8 </code></span>。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入<code>：</code></strong><span><code>"199100199"</code></span>
<strong>输出：</strong>true 
<strong>解释：</strong>累加序列为: <span><code>1, 99, 100, 199。</code></span>1 + 99 = 100, 99 + 100 = 199</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= num.length &lt;= 35</code></li> 
 <li><code>num</code> 仅由数字（<code>0</code> - <code>9</code>）组成</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你计划如何处理由过大的整数输入导致的溢出?</p>

<details><summary><strong>Related Topics</strong></summary>字符串 | 回溯</details><br>

<div>👍 460, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题不算难，要先观察，由于这个「累加」关系是传导的，所以只要我们确定了第一个和第二个数字，后面的数字其实就确定了。

比如说，如果我们确定了第一个数字是 1，第二个数字是 2，那么后面的数字就一定是 3, 5, 8, 13,...

基于这个特性，我们用一个嵌套 for 循环就可以穷举出前两个数字的所有可能了，然后实现一个 `isValid` 函数来验证后面的数字是否满足累加数的性质即可。

你把这搞明白后，可以去做一下 [✨842. 将数组拆分成斐波那契序列](/problems/split-array-into-fibonacci-sequence/)，进一步要求我们计算出切分的结果。

**详细题解**：
  - [【练习】数学技巧相关习题](https://labuladong.online/algo/problem-set/math-tricks/)

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

#include <string>
#include <algorithm>

class Solution {
public:
    bool isAdditiveNumber(std::string num) {
        // 穷举前两个数字
        int n = num.length();
        for (int i = 1; i <= n; i++) {
            // 先穷举第一个数字
            std::string first = num.substr(0, i);
            for (int j = i + 1; j <= n; j++) {
                // 再穷举第二个数字
                std::string second = num.substr(i, j - i);
                if (isValid(num, first, second)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 定义：num 前两个数字分别是 first 和 second，判断 num 是否满足累加数的性质
    bool isValid(const std::string &num, const std::string &first, const std::string &second) {
        if ((first[0] == '0' && first.length() > 1) || (second[0] == '0' && second.length() > 1)) {
            // 0 开头的数字，只能是 0 本身
            return false;
        }
        std::string sumStr = strAdd(first, second);
        std::string next = num.substr(first.length() + second.length());
        if (next.find(sumStr) != 0) {
            // 不满足累加数的性质
            return false;
        }
        if (next == sumStr) {
            // 已经匹配完整个字符串
            return true;
        }
        // 根据递归函数的定义，继续匹配后面的三个数字，我这里用递归的方式去比较，因为容易写
        // 你也可以改用迭代写法，一样的
        return isValid(num.substr(first.length()), second, sumStr);
    }

    // 模拟加法竖式运算，具体可以看下这道题
    // https://leetcode.cn/problems/add-strings/
    std::string strAdd(const std::string &a, const std::string &b) {
        int n = a.length(), m = b.length();
        int i = n - 1, j = m - 1, add = 0;
        std::string builder;
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? a[i] - '0' : 0;
            int y = j >= 0 ? b[j] - '0' : 0;
            int result = x + y + add;
            builder.push_back((result % 10) + '0');
            add = result / 10;
            i--;
            j--;
        }
        std::reverse(builder.begin(), builder.end());
        return builder;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        # 穷举前两个数字
        n = len(num)
        for i in range(1, n + 1):
            # 先穷举第一个数字
            first = num[:i]
            for j in range(i + 1, n + 1):
                # 再穷举第二个数字
                second = num[i:j]
                if self.isValid(num, first, second):
                    return True
        return False

    # 定义：num 前两个数字分别是 first 和 second，判断 num 是否满足累加数的性质
    def isValid(self, num: str, first: str, second: str) -> bool:
        if first.startswith("0") and len(first) > 1 or second.startswith("0") and len(second) > 1:
            # 0 开头的数字，只能是 0 本身
            return False
        sumStr = self.strAdd(first, second)
        next = num[len(first) + len(second):]
        if not next.startswith(sumStr):
            # 不满足累加数的性质
            return False
        if next == sumStr:
            # 已经匹配完整个字符串
            return True
        # 根据递归函数的定义，继续匹配后面的三个数字，我这里用递归的方式去比较，因为容易写
        # 你也可以改用迭代写法，一样的
        return self.isValid(num[len(first):], second, sumStr)

    # 模拟加法竖式运算，具体可以看下这道题
    # https://leetcode.cn/problems/add-strings/
    def strAdd(self, a: str, b: str) -> str:
        n, m = len(a), len(b)
        i, j, add = n - 1, m - 1, 0
        builder = []
        while i >= 0 or j >= 0 or add != 0:
            x = ord(a[i]) - ord('0') if i >= 0 else 0
            y = ord(b[j]) - ord('0') if j >= 0 else 0
            result = x + y + add
            builder.append(str(result % 10))
            add = result // 10
            i, j = i - 1, j - 1
        return ''.join(builder[::-1])
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isAdditiveNumber(String num) {
        // 穷举前两个数字
        int n = num.length();
        for (int i = 1; i <= n; i++) {
            // 先穷举第一个数字
            String first = num.substring(0, i);
            for (int j = i + 1; j <= n; j++) {
                // 再穷举第二个数字
                String second = num.substring(i, j);
                if (isValid(num, first, second)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 定义：num 前两个数字分别是 first 和 second，判断 num 是否满足累加数的性质
    boolean isValid(String num, String first, String second) {
        if (first.startsWith("0") && first.length() > 1
                || second.startsWith("0") && second.length() > 1) {
            // 0 开头的数字，只能是 0 本身
            return false;
        }
        String sumStr = strAdd(first, second);
        String next = num.substring(first.length() + second.length());
        if (!next.startsWith(sumStr)) {
            // 不满足累加数的性质
            return false;
        }
        if (next.equals(sumStr)) {
            // 已经匹配完整个字符串
            return true;
        }
        // 根据递归函数的定义，继续匹配后面的三个数字，我这里用递归的方式去比较，因为容易写
        // 你也可以改用迭代写法，一样的
        return isValid(num.substring(first.length()), second, sumStr);
    }

    // 模拟加法竖式运算，具体可以看下这道题
    // https://leetcode.cn/problems/add-strings/
    String strAdd(String a, String b) {
        int n = a.length(), m = b.length();
        int i = n - 1, j = m - 1, add = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int result = x + y + add;
            builder.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        return builder.reverse().toString();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func isAdditiveNumber(num string) bool {
    // 穷举前两个数字
    n := len(num)
    for i := 1; i <= n; i++ {
        // 先穷举第一个数字
        first := num[:i]
        for j := i + 1; j <= n; j++ {
            // 再穷举第二个数字
            second := num[i:j]
            if isValid(num, first, second) {
                return true
            }
        }
    }
    return false
}

// 定义：num 前两个数字分别是 first 和 second，判断 num 是否满足累加数的性质
func isValid(num, first, second string) bool {
    if (first[0] == '0' && len(first) > 1) || (second[0] == '0' && len(second) > 1) {
        // 0 开头的数字，只能是 0 本身
        return false
    }
    sumStr := strAdd(first, second)
    next := num[len(first)+len(second):]
    if !strings.HasPrefix(next, sumStr) {
        // 不满足累加数的性质
        return false
    }
    if next == sumStr {
        // 已经匹配完整个字符串
        return true
    }
    // 根据递归函数的定义，继续匹配后面的三个数字，我这里用递归的方式去比较，因为容易写
    // 你也可以改用迭代写法，一样的
    return isValid(num[len(first):], second, sumStr)
}

// 模拟加法竖式运算，具体可以看下这道题
// https://leetcode.cn/problems/add-strings/
func strAdd(a, b string) string {
    n, m := len(a), len(b)
    i, j, add := n-1, m-1, 0
    var builder strings.Builder
    for i >= 0 || j >= 0 || add != 0 {
        x, y := 0, 0
        if i >= 0 {
            x = int(a[i] - '0')
        }
        if j >= 0 {
            y = int(b[j] - '0')
        }
        result := x + y + add
        builder.WriteByte(byte(result%10 + '0'))
        add = result / 10
        i--
        j--
    }
    return reverseString(builder.String())
}

func reverseString(s string) string {
    runes := []rune(s)
    for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
        runes[i], runes[j] = runes[j], runes[i]
    }
    return string(runes)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var isAdditiveNumber = function(num) {
    // 穷举前两个数字
    let n = num.length;
    for (let i = 1; i <= n; i++) {
        // 先穷举第一个数字
        let first = num.substring(0, i);
        for (let j = i + 1; j <= n; j++) {
            // 再穷举第二个数字
            let second = num.substring(i, j);
            if (isValid(num, first, second)) {
                return true;
            }
        }
    }
    return false;
};

// 定义：num 前两个数字分别是 first 和 second，判断 num 是否满足累加数的性质
function isValid(num, first, second) {
    if (first.startsWith("0") && first.length > 1
            || second.startsWith("0") && second.length > 1) {
        // 0 开头的数字，只能是 0 本身
        return false;
    }
    let sumStr = strAdd(first, second);
    let next = num.substring(first.length + second.length);
    if (!next.startsWith(sumStr)) {
        // 不满足累加数的性质
        return false;
    }
    if (next === sumStr) {
        // 已经匹配完整个字符串
        return true;
    }
    // 根据递归函数的定义，继续匹配后面的三个数字，我这里用递归的方式去比较，因为容易写
    // 你也可以改用迭代写法，一样的
    return isValid(num.substring(first.length), second, sumStr);
}

// 模拟加法竖式运算，具体可以看下这道题
// https://leetcode.cn/problems/add-strings/
function strAdd(a, b) {
    let n = a.length, m = b.length;
    let i = n - 1, j = m - 1, add = 0;
    let builder = [];
    while (i >= 0 || j >= 0 || add !== 0) {
        let x = i >= 0 ? a.charCodeAt(i) - '0'.charCodeAt(0) : 0;
        let y = j >= 0 ? b.charCodeAt(j) - '0'.charCodeAt(0) : 0;
        let result = x + y + add;
        builder.push(result % 10);
        add = Math.floor(result / 10);
        i--;
        j--;
    }
    return builder.reverse().join('');
}
```

</div></div>
</div></div>

</div>
</details>
</div>

