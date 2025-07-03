
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 438
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 */
public class FindAllAnagramsInAString {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            // 初始化window
            for (Character c : p.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0, valid = 0, len = p.length();
            List<Integer> result = new ArrayList<>();
            while (right < s.length()) {
                Character c = s.charAt(right);
                right++;

                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                while (valid == need.size()) {
                    // 长度相等时表明现在这个长度是符合要求的
                    if (right - left == len) {
                        result.add(left);
                    }

                    Character d = s.charAt(left);
                    left++;
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // put your test code here
        // test case 1
        String s = "cbaebabacd", p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result.toString());

        // test case 2
        s = "abab";
        p = "ab";
        result = solution.findAnagrams(s, p);
        System.out.println(result.toString());

        // test case 3
        s = "baa";
        p = "aa";
        result = solution.findAnagrams(s, p);
        System.out.println(result.toString());
    }
}
