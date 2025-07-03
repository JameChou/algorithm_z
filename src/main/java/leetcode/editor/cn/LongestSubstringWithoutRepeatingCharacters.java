
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 3
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * 最长无重复子串
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();

            int left = 0, right = 0;
            // 记录结果
            int res = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据的一系列更新
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 判断左侧窗口是否要收缩
                while (window.get(c) > 1) {
                    char d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    window.put(d, window.get(d) - 1);
                }
                // 在这里更新答案
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // put your test code here

        String s;
        int result;
        // test case 1
        s = "abcabcbb";
        result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);

        // test case 2
        s = "bbbbb";
        result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);

        // test case 3
        s = "pwwkew";
        result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);

    }
}
