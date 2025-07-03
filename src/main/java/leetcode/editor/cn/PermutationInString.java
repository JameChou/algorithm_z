
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 567
 * https://leetcode.cn/problems/permutation-in-string/description/
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class PermutationInString {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for (Character c : s1.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0, valid = 0, len = s1.length();
            while (right < s2.length()) {
                char c = s2.charAt(right);
                right++;

                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                // 向左缩进
                while (valid == need.size()) {
                    // 表明现在的字符串长度已经是一个连续的并且是符合s1长度要求的字符串则可以返回true
                    if (right - left == len) {
                        return true;
                    }

                    char d = s2.charAt(left);
                    left++;

                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        // put your test code here

        String s1 = "ab", s2 = "eidbaooo";
        boolean result = false;
        result = solution.checkInclusion(s1, s2);
        System.out.println(result);

        s1 = "ab";
        s2 = "eidboaoo";
        result = solution.checkInclusion(s1, s2);
        System.out.println(result);

    }
}
