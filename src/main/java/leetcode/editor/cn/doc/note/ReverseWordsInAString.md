# 反转单词

[151题反转单词](https://leetcode.cn/problems/reverse-words-in-a-string)

```
Input: the sky is blue
Output: blue is sky the
```

## 最直接可以想到的解法

常规的一种做法就是我们将按照单词来进行分隔，然后再进行组合

```java
public String reverseWords(String s) {
    String word = "";
    String result = "";
    for (int i = 0; i < s.length(); i++) {
        char cur = s.charAt(i);
        if (cur != ' ') {
            word += cur;
        } else {
            if (word.equals("")) {
                continue;
            }

            result = " " + word + result;
            word = "";
        }
    }

    if (word != "") {
        result = " " + word + result;
    }

    return result.trim();
}
```

不过种做法应该是在字符串进行相加的时候比较浪费时间。所以速度并不是很快。只超过了**5.06%**的人。


## 较好的解法

经过下面几个步骤可以比较好的解决这个问题。

1. 将多余的空格进行处理，字符串的前后不保留空格，**另外每个单词之间也只能有一个单位长度的空格**。
2. 将整个字符串都进行反转即`the sky is blue` 反转成 `eulb si yks eht`。
3. 再对每一个单词进行反转就可以得到正确的顺序了`the sky is blue -> blue is sky the`。


```java
public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();

    // 清理字符串，把多余的空格给清除掉
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != ' ') {
            sb.append(s.charAt(i));
        } else if (!sb.isEmpty() && s.charAt(i - 1) != ' ') {
            sb.append(' ');
        }
    }

    if (sb.toString().equals(" ")) {
        return "";
    }

    // 清除最后一个空格
    if (sb.charAt(sb.length() - 1) == ' ') {
        sb.deleteCharAt(sb.length() - 1);
    }

    char[] charArray = sb.toString().toCharArray();
    // 将整个字符串都进行反转
    reverseCharArray(charArray, 0, charArray.length - 1);

    // 逐个单词进行反转操作
    for (int i = 0; i < charArray.length; i++) {
        for (int j = i; j < charArray.length; j++) {
            if (charArray[j] == ' ') {
                reverseCharArray(charArray, i, j - 1);
                i = j;
                break;
            } else if (j == charArray.length - 1) {
                reverseCharArray(charArray, i, j);
                i = charArray.length;
                break;
            }
        }
    }

    return new String(charArray);
}


// 反转字符串，代码较简单这里就不再贴出来了
public void reverseCharArray(char[] array, int i, int j) {
}
```

下面这种是别人的一个处理办法，不过时间上并没有很优秀。不过写法上更优雅一些。

```java

public String reverseWords(String s) {
    //......
    for (int i = 0; i < charArray.length;) {
        for (int j = i; j < charArray.length; j++) {
            if (j + 1 == charArray.length || charArray[j + 1] == ' ') {
                reverseCharArray(charArray, i, j);
                i = j + 2;
                break;
            }
        }
    }
    //......
```

>[!tip]
注意上面的代码，`for (int i = 0; i < charArray.length);` 这里没有使用`i++` 即没有步长，`i` 的值是由下面的代码去处理的。

