# 判断回文字符串

[leetcode 125 验证回文字符串](https://leetcode.cn/problems/valid-palindrome/description/)

这个题目还是使用 `left` 和 `right` 两个指针去处理。

核心的点是在于去除 `[0-9a-zA-Z]` 以外的所有字符之后，如果正读和反读是一样的，则返回 `true` 否则的话返回 `false` 。那么我们可以将整个字符串都先转换为小写的字符。即调用 `s.toLowerCase()` 。

然后再去判断这个字符是否是 `[0-9a-z]` 之间，如果不符合要求我们则看是 `left` 还是 `right` ，若为 `left` 则将 `left++` ，`right` 则将 `right--` 然后再 `continue` 进行下一次比较。

```java
public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    s = s.toLowerCase();
    while (left <= right) {
        char leftChar = s.charAt(left);
        char rightChar = s.charAt(right);
        if (!((leftChar >= 97 && leftChar <= 122) || (leftChar >= 48 && leftChar <= 57))) {
            left++;
            continue;
        }
        if (!((rightChar >= 97 && rightChar <= 122) || (rightChar >= 48 && rightChar <= 57))) {
            right--;
            continue;
        }
        if (leftChar != rightChar) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
```

>[!note]
> 注意查看一下ASCII表，`[0-9]` 的区间是 `[48-57]` ，`[a-z]` 的区间是 `[97-122]` ，`[A-Z]` 的区间是 `[65-90]` 。

## 优化

那么关键点在于 `s.toLowerCase()` 这个函数我不知道内部是怎么处理的，这里的耗费时间较多。

那么上面我们已经提到了，ASCII码中 `[a-z]` 与 `[A-Z]` 之间相差了 `32` 个大小，所以我们可以将这个 `char` 向上加 `32` 如果在 `[97-122]` 之间那么就表明这个字符是大写的英文字符。

所以可以把这段代码改为下面这种：

```java
public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    while (left <= right) {
        char leftChar = s.charAt(left);
        char rightChar = s.charAt(right);
        if (leftChar >= 65 && leftChar <= 90) {
            leftChar = (char) (leftChar + 32);
        }
        if (rightChar >= 65 && rightChar <= 90) {
            rightChar = (char) (rightChar + 32);
        }
        if (!((leftChar >= 97 && leftChar <= 122) || (leftChar >= 48 && leftChar <= 57))) {
            left++;
            continue;
        }
        if (!((rightChar >= 97 && rightChar <= 122) || (rightChar >= 48 && rightChar <= 57))) {
            right--;
            continue;
        }
        if (leftChar != rightChar) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
```

