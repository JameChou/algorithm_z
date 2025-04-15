## 两数之和

[两数之和](https://leetcode.cn/problems/two-sum/description/)

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。

你可以按任意顺序返回答案。

 

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]
 

提示：

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案

### 解法一

下面的这种解法是我自己去想的，不过这种方式并不是最好的解法，思路没有问题，不过时间复杂度已经到了$O(N^{2})$

```java
public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
        return 0;
    }
    int max = 1;
    Set<Character> sets = new HashSet<Character>();
    for (int i = 0; i < s.length(); i++) {
        sets = new HashSet<Character>();
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            if (sets.contains(c)) {
                if (max < sets.size()) {
                    max = sets.size();
                }
                sets = new HashSet<Character>();
            }
            sets.add(c);
        }

        if (max < sets.size()) {
            max = sets.size();
        }
    }
    return max;
}

```

### 解法二




