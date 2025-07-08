<p>你有一套活字字模&nbsp;<code>tiles</code>，其中每个字模上都刻有一个字母&nbsp;<code>tiles[i]</code>。返回你可以印出的非空字母序列的数目。</p>

<p><strong>注意：</strong>本题中，每个活字字模只能使用一次。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>"AAB"
<strong>输出：</strong>8
<strong>解释：</strong>可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>"AAABBC"
<strong>输出：</strong>188
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>"V"
<strong>输出：</strong>1</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= tiles.length &lt;= 7</code></li> 
 <li><code>tiles</code> 由大写英文字母组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 回溯 | 计数</details><br>

<div>👍 288, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这个题其实就是前文 [回溯算法秒杀所有排列组合子集问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/) 中讲到的元素可重不可复选的排列问题。

只不过前文我讲的是全排列，而这道题问的不是全排列，而是普通排列。

全排列的意思是，比方说我输入 `AAB`，那么输出的结果是 `AAB, ABA, BAA`，即每个元素都要参与到排列中。

而普通排列的意思是，比方说我输入 `AAB`，那么输出的结果是 `A, B, AA, AB, BA, BB, AAA, AAB, ABA, BAA`，即并非每个元素都要参与到排列中。

所以关键的区别在哪里呢？就在于收集结果的时机。用 [回溯算法秒杀所有排列组合子集问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/) 中全排列的递归树举例：

![](https://labuladong.online/algo/images/permutation/7.jpeg)

**我们计算全排列时，只收集最底层叶子节点上的值。而这道题，我们收集所有节点上的值**。

所以你把前文解决的元素可重不可复选的全排列代码 copy 过来稍微改一下，在前序位置收集节点，就可以解决这道题了，具体看我的代码吧。

**详细题解**：
  - [【练习】回溯算法经典习题 II](https://labuladong.online/algo/problem-set/backtrack-ii/)

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
#include <algorithm>

using namespace std;

class Solution {
public:
    int res = 0;
    vector<bool> used;

    int numTilePossibilities(string s) {
        vector<char> nums(s.begin(), s.end());
        // 先排序，让相同的元素靠在一起
        sort(nums.begin(), nums.end());
        used = vector<bool>(nums.size(), false);
        backtrack(nums);
        return res - 1;
    }

    void backtrack(vector<char>& nums) {
        res++;

        for (int i = 0; i < nums.size(); i++) {
            if (used[i]) {
                continue;
            }
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            backtrack(nums);
            used[i] = false;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:

    def __init__(self):
        self.res = 0
        self.used = None

    def numTilePossibilities(self, s: str) -> int:
        # 先排序，让相同的元素靠在一起
        nums = sorted(s)
        self.used = [False] * len(nums)
        self.backtrack(nums)
        return self.res - 1

    def backtrack(self, nums):
        self.res += 1

        for i in range(len(nums)):
            if self.used[i]:
                continue
            # 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            if i > 0 and nums[i] == nums[i - 1] and not self.used[i - 1]:
                continue
            self.used[i] = True
            self.backtrack(nums)
            self.used[i] = False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    int res = 0;
    boolean[] used;

    public int numTilePossibilities(String s) {
        char[] nums = s.toCharArray();
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res - 1;
    }

    void backtrack(char[] nums) {
        res++;

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            backtrack(nums);
            used[i] = false;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func numTilePossibilities(s string) int {
    nums := []rune(s)
    // 先排序，让相同的元素靠在一起
    sort.Slice(nums, func(i, j int) bool { return nums[i] < nums[j] })
    used := make([]bool, len(nums))
    res := 0
    backtrack(nums, used, &res)
    return res - 1
}

// backtrack is a helper function for numTilePossibilities
func backtrack(nums []rune, used []bool, res *int) {
    *res++

    for i := 0; i < len(nums); i++ {
        if used[i] {
            continue
        }
        // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
        if i > 0 && nums[i] == nums[i-1] && !used[i-1] {
            continue
        }
        used[i] = true
        backtrack(nums, used, res)
        used[i] = false
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var numTilePossibilities = function(s) {
    let res = 0;
    let used = new Array(s.length).fill(false);
    let track = []

    // Convert the string to an array of characters and sort it
    // 先排序，让相同的元素靠在一起
    let nums = Array.from(s).sort();

    // @visualize status(track.toString())
    function backtrack(nums) {
        res++;

        for (let i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i] === nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // @visualize choose("choose " + nums[i])
            track.push(nums[i]);
            used[i] = true;
            backtrack(nums);
            // @visualize unchoose()
            track.pop();
            used[i] = false;
        }
    }

    backtrack(nums);
    return res - 1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_letter-tile-possibilities"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_letter-tile-possibilities"></div></div>
</details><hr /><br />

</div>
</details>
</div>

