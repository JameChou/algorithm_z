# 滑动窗口延伸: Rabin Karp字符匹配算法

首先,我问你一个很基础的问题，给你输入一个字符串形式的正整数，如何把它转化成数字的形式？

```java
String s = "8264";
int number = 0;
for (int i = 0; i < s.length(); i++) {
    // 将字符转化成数字
    number = 10 * number + (s.charAt(i) - '0');
    System.out.println(number);
}
// 打印输出：
// 8
// 82
// 826
// 8264
```

--------

**可以看到这个算法的核心思路就是不断向最低位（个位）添加数字**，同时把前面的数字整体左移一位（乘以 10）。

为什么是乘以 $10$？因为我们默认探讨的是十进制数。这和我们操作二进制数的时候是一个道理，左移一位就是把二进制数乘以 $2$，右移一位就是除以 $2$。

上面这个场景是不断给数字添加最低位，那如果我想删除数字的最高位，怎么做呢？比如说我想把 $8264$ 变成 $264$，应该如何运算？其实也很简单，让$8264$ 减去$8000$就得到$264$了。

这个 $8000$ 是怎么来的？是 $8 \times 10^3$ 算出来的。$8$ 是最高位的数字，$10$ 是因为我们这里是十进制数，$3$ 是因为 $8264$ 去掉最高位后还剩三位数。

上述内容主要探讨了如何在数字的最低位添加数字以及如何删除数字的最高位，用 `R` 表示数字的进制数，用 `L` 表示数字的位数，就可以总结出如下公式：

```java
// ****** 在最低位添加一个数字 ******
int number = 8264;
// number 的进制
int R = 10;
// 想在 number 的最低位添加的数字
int appendVal = 3;
// 运算，在最低位添加一位
number = R * number + appendVal;
// 此时 number = 82643

// ****** 在最高位删除一个数字 ******
int number = 8264;
// number 的进制
int R = 10;
// number 最高位的数字
int removeVal = 8;
// 此时 number 的位数
int L = 4;
// 运算，删除最高位数字
number = number - removeVal * Math.pow(R, L-1);
// 此时 number = 264
```

## 高效寻找重复子序列
DNA 序列由四种碱基 `A, G, C, T` 组成，现在给你输入一个只包含 `A, G, C, T` 四种字符的字符串 `s` 代表一个 DNA 序列，请你在 `s` 中找出所有重复出现的长度为 $10$ 的子字符串。

```
输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC","CCCCCAAAAA"]
解释：子串 "AAAAACCCCC" 和 "CCCCCAAAAA" 都重复出现了两次。

输入：s = "AAAAAAAAAAAAA"
输出：["AAAAAAAAAA"]
```

函数签名如下:

```java
List<String> findRepeatedDnaSequences(String s);
```

```java
class Solution {
    // 暴力解法
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        // 记录出现过的子串
        HashSet<String> seen = new HashSet();
        // 记录那些重复出现多次的子串
        // 注意要用哈希集合，防止记录重复的结果
        HashSet<String> res = new HashSet<>();

        for (int i = 0; i + 10 <= n; i++) {
            String subStr = s.substring(i, i + 10);
            if (seen.contains(subStr)){
                // 之前出现过，找到一个重复的
                res.add(subStr);
            } else {
                // 之前没出现过，加入集合
                seen.add(subStr);
            }
        }
        return new LinkedList<>(res);
    }
}
```

这个算法肯定是没问题的，只是时间复杂度略高。假设 `s` 的长度为 `N`，目标子串的长度为 `L`（本题 `L = 10`），`for` 循环遍历 `s` 的 $O(N)$ 个字符，对每个字符都要截取长度为 `L` 的子字符串，所以这个算法的时间复杂是 $O(NL)$。

**遍历整个 `s` 肯定是免不了的，问题是我们能不能不要每次都调用 `substring` 去截取子字符串？**

你注意我们这个匹配过程实际上就是维护了一个长度为 `L = 10` 的定长窗口在从左向右滑动，是否可以借鉴前文 滑动窗口算法框架 中的做法，只维护 `left`, `right` 指针来划定子字符串区间？

其实可以的，直接套用前文给出的滑动窗口算法框架写出伪码思路：

```java
int L = 10;
HashSet<String> seen;

// 滑动窗口代码框架
CharWindow window;
int left = 0, right = 0;
while (right < s.size()) {
    // 扩大窗口，移入字符
    window.addRight(s[right]);
    right++;
    
    // 当子串的长度达到要求
    if (right - left == L) {
        // 把窗口中的字符变成字符串，还是需要 O(L) 的时间
        String windowStr = window.toString();
        if (seen.contains(windowStr)) {
            // 找到一个重复子串
            print(windowStr);
        } else {
            seen.add(windowHash);
        }

        // 缩小窗口，移出字符
        window.removeLeft();
        left++;
    }
}
```

这段伪码直接套用了滑动窗口算法框架，你应该不难理解。但你注意这个解法依然需要将窗口中的字符转化成字符串然后去 `seen` 集合判断是否存在重复，你一旦想把字符转化成字符串，就难免需要 $O(L)$ 的时间来操作。所以这个算法的时间复杂度还是没有降低，依然是 $O(NL)$。

**所以优化的关键在于，我们能不能不要真的把子字符串生成出来，而是用一些其他形式的唯一标识来表示滑动窗口中的子字符串，并且还能在窗口滑动的过程中快速更新？**

有办法的，回想一下本文开头我们讨论的那两个公式，现在你应该明白的用意了。

你把 `AGCT` 四种字符等价为 `0123` 四个数字，那么长度为 `L = 10` 的一个碱基序列其实就可以等价为一个十位数，这个数字可以唯一标识一个子串。而且窗口移动的过程，其实就是给这个数字的最低位添加数字，并删除最高位数字的过程，回顾之前的讲解，添加和删除数字的运算就是两个公式，可以在 $O(1)$ 的时间完成。

然后，我们不要在哈希集合中直接存储子串了，而是存储子串对应的十位数。因为一个十位数可以唯一标识一个子串，所以也可以起到识别重复的作用。

这样，我们就避免了直接生成子串存入集合，而是生成一个十位数来表示子串，而且生成这个十位数的时间花费为 $O(1)$，从而降低了匹配算法的时间复杂度。

其实你想下，你把一个字符串对象转化成了一个数字，这是什么？这就是你设计的一个哈希算法，生成的数字就可以认为是字符串的哈希值。在滑动窗口中快速计算窗口中元素的哈希值，叫做滑动哈希技巧。

按照这个思路形成的伪代码如下:

```java
int L = 10;
// 集合中不要存储字符串了，而是存储字符串对应的哈希值
HashSet<Integer> seen;

// 滑动窗口代码框架
CharWindow window;
int left = 0, right = 0;
while (right < s.size()) {
    // 扩大窗口，移入字符
    window.addRight(s[right]);
    right++;

    // 当子串的长度达到要求
    if (right - left == L) {
        // 获取当前窗口内字符串的哈希值，时间 O(1)
        int windowHash = window.hash();
        // 根据哈希值判断是否曾经出现过相同的子串
        if (seen.contains(windowHash)) {
            // 当前窗口中的子串是重复出现的
            print(window.toString());
        } else {
            // 当前窗口中的子串之前没有出现过，记下来
            seen.add(windowHash);
        }

        // 缩小窗口，移出字符
        window.removeLeft();
        left++;
    }
}
```

进一步，我们用一个长度为 `10` 的十进制数来标识一个长度为 `10` 的碱基字符序列，这个数字可能达到 $10^{10}$，`int` 存不下，这需要 `long` 类型存储。但你注意这个十进制数中的每一位数字只会局限于 `0,1,2,3`，是不是有些浪费？

换句话说，我们需要存储的其实只是一个长度为 `10` 的四进制数（共包含 $4^10$ 个数字），却用了长度为 `10` 的十进制数（可以包含 $10^{10}$ 个数字）来保存，显然是有些浪费的。

因为 $4^{10} = 2^{20} = 1048576 < 2^{31-1}$，一个长度为 `7` 的十进制数就能存下，`int` 类型就够存了。

具体来说，只要改变我们之前那两个公式的进制 `R` 就行了：

```java
// ****** 在最低位添加一个数字 ******
// number 的进制
int R = 4;
// 想在 number 的最低位添加的数字
int appendVal = 0~3 中的任意数字;
// 运算，在最低位添加一位
number = R * number + appendVal;

// ****** 在最高位删除一个数字 ******
// number 的进制
int R = 4;
// number 最高位的数字
int removeVal = 0~3 中的任意数字;
// 此时 number 的位数
int L = ?;
// 运算，删除最高位数字
number = number - removeVal * R^(L-1);
```


现在我们对这题开始进行处理:
```java
public List<String> findRepeatedDnaSequences(String s) {
    int n = s.length();
    int[] nums = new int[n];
    // ACGT 转换为int类型的数组
    for (int i = 0; i < n; i++) {
        char current = s.charAt(i);
        switch (current) {
            case 'A':
                nums[i] = 0;
                break;
            case 'C':
                nums[i] = 1;
                break;
            case 'G':
                nums[i] = 2;
                break;
            case 'T':
                nums[i] = 3;
                break;
        }
    }

    // 是否已经在列表中了，如果有的话表示已经出现重复了，这时候就需要加入到res中
    HashSet<Integer> seen = new HashSet<>();
    HashSet<String> res = new HashSet<>();

    int R = 4;
    int L = 10;
    int RL = (int) Math.pow(R, L - 1);
    int windowHash = 0;

    int left = 0, right = 0;
    while (right < n) {
        // 计算当前window的Hash
        windowHash = R * windowHash + nums[right];
        right++;

        if (right - left == L) {
            if (seen.contains(windowHash)) {
                // 已经出现重复的了
                res.add(s.substring(left, right));
            } else {
                // 没有重复的情况下，将这个值放入到seen中
                seen.add(windowHash);
            }
            // 当满足窗口大小之后再进行窗口的缩小操作
            windowHash = windowHash - nums[left] * RL;
            left++;
        }

    }
    return new LinkedList<>(res);
}
```

滑动窗口算法本身的时间复杂度是 $O(N)$，再看看窗口滑动的过程中的操作耗时，给 `res` 添加子串的过程用到了 `substring` 方法需要 $O(L)$ 的复杂度，但一般情况下 substring 方法不会调用很多次，只有极端情况（比如字符串全都是相同的字符）下才会每次滑动窗口时都调用 `substring` 方法。

所以我们可以说这个算法一般情况下的平均时间复杂度是 $O(N)$，极端情况下的时间复杂度会退化成 $O(NL)$。

## Rabin-Karp 算法

```java
// 在文本串 txt 中搜索模式串 pat 的起始索引
int search(String txt, String pat) {
    int N = txt.length(), L = pat.length();

    for (int i = 0; i + L <= N; i++) {
        String subStr = txt.substring(i, i + L);
        if (subStr.equals(pat)){
            // 在 txt 中找到模式串 pat，返回起始索引
            return i;
        }
    }
    // txt 中不存在模式串 pat
    return -1;
}
```

这里可以发现，这个逻辑和上面的例子题中暴力解法非常类似，总的时间复杂度是 $O(LN)$，优化的核心也是子串 `subStr` 和模式串 `pat` 匹配的部分。

**那么借鉴上面的思路，我们不要每次都一个字符一个字符地比较子串和模式串，而是维护一个滑动窗口，运用滑动哈希算法一边滑动一边计算窗口中字符串的哈希值，拿这个哈希值去和模式串的哈希值比较，这样就可以避免截取子串，从而把匹配算法降低为 $O(n)$，这就是 Rabin-Karp 指纹字符串查找算法的核心逻辑。**

刚才我们处理题目输入只有 `AGCT` 四种字符，所以可以转化成数字，但面对五花八门的字符串，如何把他们转化成数字计算哈希值呢？其实很简单，字符本质上就是编码，而编码其实就是数字。

比方说以 ASCII码为例，ASCII码其实就是 0~255这256个数字，分别对应所有英文字符和英文符号。那么一个长度 `L` 的ASCII字符串，我们就可以等价理解成一个 `L` 位的256进制的数字，这个数字就可以唯一标识这个字符串，也就可以作为哈希值。

有这个想法，我们就可以直接复制粘贴上一道题的大部分代码，写出Rabin-Karp算法的主要逻辑:

```java
// 文本串
String txt;
// 模式串
String pat;

// 需要寻找的子串长度为模式串 pat 的长度
int L = pat.length();
// 仅处理 ASCII 码字符串，可以理解为 256 进制的数字
int R = 256;
// 存储 R^(L - 1) 的结果
int RL = (int) Math.pow(R, L - 1);
// 维护滑动窗口中字符串的哈希值
int windowHash = 0;
// 计算模式串的哈希值
long patHash = 0;
for (int i = 0; i < pat.length(); i++) {
    patHash = R * patHash + pat.charAt(i);
}

// 滑动窗口代码框架
int left = 0, right = 0;
while (right < txt.length()) {
    // 扩大窗口，移入字符（在最低位添加数字）
    windowHash = R * windowHash + txt[right];
    right++;

    // 当子串的长度达到要求
    if (right - left == L) {
        // 根据哈希值判断窗口中的子串是否匹配模式串 pat
        if (patHash == windowHash) {
            // 找到模式串，返回起始索引
            return left;
        }

        // 缩小窗口，移出字符（删除最高位数字）
        windowHash = windowHash - txt[left] * RL;
        left++;
    }
}
// 没有找到模式串
return -1;
```

相对上一道题的解法，这段代码将进制数 `R` 改为了 256，同时计算了模式串 `pat` 的哈希值 `patHash` 用来和窗口中字符串的哈希值 `windowHash` 做对比，以便判断是否找到了模式串，其他的代码部分完全相同。

不过呢，这段代码实际运行的时候会有一个严重的问题，那就是整型溢出。

你想，上一道题给定的 DNA 序列字符串只包含 `AGCT` 四种字符，所以我们可以把 DNA 序列抽象成四进制的数字，即算法中 `R = 4`。相同位数下，四进制包含的数字数量是小于十进制包含的数字数量的。比方说 `L = 10` 时，$4^{10} = 1048576 < 10^8$，即 10 位四进制数字用 8 位十进制数字就可以存下了。

但现在输入为 ASCII 码字符串，我们不得不把字符串抽象成 256 进制的数字，即算法中 `R = 256`。而相同位数下，256 进制包含的数字数量显然是远大于十进制包含的数字数量的。比如 `L = 10` 时，$256^{10} = 1.2 \times 10^{24} < 10 ^{25}$，所以你需要一个 25 位的十进制数才能表示一个 10 位的 256 进制数。

可想而知，如果你真的把字符串对应的 256 进制数字的十进制表示作为该字符串的哈希值，那恐怕 `L` 稍微大一点，像 `RL`, `windowHash`, `patHash` 这些变量就超级大了，`long` 类型都远远装不下。

所以解决办法是什么呢？如何把一个很大的数字映射到一个较小的范围内呢？答案是求模（余数）。这个技巧也是我们在 哈希表原理及实现 中讲过的。

无论一个数字多大，你让它除以 `Q`，余数一定会落在 `[0, Q-1]` 的范围内。所以我们可以设置一个 `Q`，用求模的方式让 `windowHash` 和 `patHash` 保持在 `[0, Q-1]` 之间，就可以有效避免整型溢出。

具体来说，对于一个字符串，我们不需要把完整的 256 进制数字存下来，而是对这个巨大的 256 进制数求 `Q` 的余数，然后把这个余数作为该字符串的哈希值即可。

好，整型溢出的问题倒是解决了，但你会遇到 哈希表原理及实现 中相同的问题：求模之后的哈希值不能和原始字符串一一对应了，可能出现一对多的情况，即哈希冲突。

比方说 $10 \% 7$ 等于 $3$，而 $17 \% 7$ 也等于 $3$，所以如果你得到余数 $3$，你能确定原始数字就一定是 $10$ 么？不能。

类似的，如果你发现 `windowHash == patHash`，你也不敢完全肯定窗口中的字符串一定就和模式串 `pat` 匹配，有可能它俩不匹配，但恰好求模算出来的哈希值一样，这就产生了是「哈希冲突」。

对于 Rabin-Karp 算法来说，当发现 `windowHash == patHash` 时，使用暴力匹配算法检查一下窗口中的字符串和 `pat` 是否相同就可以避免哈希冲突了。因为希冲突出现的概率比较小，所以偶尔用一下暴力匹配算法是不影响总体的时间复杂度的。

```java
// Rabin-Karp 指纹字符串查找算法
int rabinKarp(String txt, String pat) {
    // 位数
    int L = pat.length();
    // 进制（只考虑 ASCII 编码）
    int R = 256;
    // 取一个比较大的素数作为求模的除数
    long Q = 1658598167;
    // R^(L - 1) 的结果
    long RL = 1;
    for (int i = 1; i <= L - 1; i++) {
        // 计算过程中不断求模，避免溢出
        RL = (RL * R) % Q;
    }
    // 计算模式串的哈希值，时间 O(L)
    long patHash = 0;
    for (int i = 0; i < pat.length(); i++) {
        patHash = (R * patHash + pat.charAt(i)) % Q;
    }
    
    // 滑动窗口中子字符串的哈希值
    long windowHash = 0;
    
    // 滑动窗口代码框架，时间 O(N)
    int left = 0, right = 0;
    while (right < txt.length()) {
        // 扩大窗口，移入字符
        windowHash = ((R * windowHash) % Q + txt.charAt(right)) % Q;
        right++;

        // 当子串的长度达到要求
        if (right - left == L) {
            // 根据哈希值判断是否匹配模式串
            if (windowHash == patHash) {
                // 当前窗口中的子串哈希值等于模式串的哈希值
                // 还需进一步确认窗口子串是否真的和模式串相同，避免哈希冲突
                if (pat.equals(txt.substring(left, right))) {
                    return left;
                }
            }
            // 缩小窗口，移出字符
            windowHash = (windowHash - (txt.charAt(left) * RL) % Q + Q) % Q;
            // X % Q == (X + Q) % Q 是一个模运算法则
            // 因为 windowHash - (txt[left] * RL) % Q 可能是负数
            // 所以额外再加一个 Q，保证 windowHash 不会是负数

            left++;
        }
    }
    // 没有找到模式串
    return -1;
}
```

--------
有之前那么多铺垫，算法逻辑应该没啥可说的，就说一下模运算的两个运算法则吧：

**重要**

$$
X \% Q = (X + Q) \% Q \\
(X + Y) \% Q = (X \% Q + Y \% Q) \% Q
$$

稍微想一想就能理解这两个运算法则，在代码中但凡涉及到乘法和加法，都可能产生很大的结果，所以一有机会就可以运用上述法则对结果进行求模，以避免造成溢出。

Rabin-Karp 算法的时间复杂度是 $O(N+L)$，$N$ 为文本串 `txt` 的长度，$L$ 为模式串 `pat` 的长度。当然，每次出现哈希冲突时会使用 $O(L)$ 的时间进行暴力匹配，但考虑到只要 `Q` 设置的合理，哈希冲突的出现概率会很小，所以可以忽略不计。

最后说一下这个大素数 `Q` 的选择。

**为什么要这个 `Q` 尽可能大呢？主要是为了降低哈希冲突的概率。**

因为代码中你把这个 `Q` 作为除数，余数（哈希值）一定落在 `[0, Q-1]` 之间，所以 `Q` 越大，哈希值的空间就越大，就越不容易出现哈希冲突，整个算法的效率就会高一些。

**为什么这个 Q 要是素数呢？依然是为了降低哈希冲突的概率。**

举个极端一点的例子，你令 `Q = 100`，那么无论一个数 $X$ 再大，$X \% Q$ 的结果必然是 `X` 的最后两位。换句话说 `X` 前面的那些位你根本没利用，可想而知你这个哈希算法存在某些规律性，不够随机，进而更容易导致哈希冲突，降低算法的效率。

而如果你把 `Q` 设置为一个素数，可以更充分利用被除数 `X` 的每一位，得到的结果更随机，哈希冲突的概率更小。这个结论是能够在数学上证明的，有兴趣的读者可以自行搜索学习，我这里就不展开了。

最后总结一下吧，你看 Rabin-Karp 算法难吗？其实就是滑动哈希配合滑动窗口，滑动哈希就是处理数字的一个小技巧，而 滑动窗口算法 是我们早就套路化的一个算法技巧。


