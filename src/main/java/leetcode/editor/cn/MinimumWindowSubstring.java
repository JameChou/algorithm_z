
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 76
 * https://leetcode.cn/problems/minimum-window-substring/description/
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 */
public class MinimumWindowSubstring {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            // 初始化我们寻找的最小子串值的各项值
            for (Character c : t.toCharArray()) {
                /**
                 * 下面这种写法已经过时了，并不是最优解
                 */
                /*
                 * if (charactersMap.containsKey(c)) {
                 * charactersMap.put(c, charactersMap.get(c) + 1);
                 * } else {
                 * charactersMap.put(c, 1);
                 * }
                 */

                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            // 截取的字符串
            int valid = 0, start = 0, len = Integer.MAX_VALUE;
            // 右指针一直需要增加到字符串的最右侧
            while (right < s.length()) {
                char c = s.charAt(right);

                // 这里需要直接将right+1，因为后面的substring以及区间的开闭全需要搞清楚边界
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    // 表明当前这个字符已经达到了所需要的数量
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                // 左侧的指针向右进行缩进
                while (valid == need.size()) {
                    // 这时候进行更新操作
                    if (right - left < len) {
                        len = right - left;
                        start = left;
                    }

                    // 开始进行移除左侧字符开始
                    char leftCurrent = s.charAt(left);
                    left++;
                    if (need.containsKey(leftCurrent)) {
                        if (window.get(leftCurrent).equals(need.get(leftCurrent))) {
                            valid--;
                        }
                        window.put(leftCurrent, window.get(leftCurrent) - 1);
                    }

                }

            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // put your test code here

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = solution.minWindow(s, t);
        assert result.equals("BANC");
        System.out.println(result);
    }
}
