
package leetcode.editor.cn;

/**
 * leetcode 424
 * https://leetcode.cn/problems/longest-repeating-character-replacement/description/
 *
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * 可能存在其他的方法来得到同样的结果。
 *
 */
public class LongestRepeatingCharacterReplacement {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            int left = 0, right = 0;
            // 这里是使用26个英文字母数组来表示其大小
            int[] windowCharCount = new int[26];
            // 窗口中当前最大的字母数量以及最终的返回值
            int windowMaxCount = 0, res = 0;

            while (right < s.length()) {
                int c = s.charAt(right);
                windowCharCount[c - 'A']++;
                windowMaxCount = Math.max(windowMaxCount, windowCharCount[c - 'A']);
                right++;

                while (right - left - windowMaxCount > k) {
                    windowCharCount[s.charAt(left) - 'A']--;
                    left++;
                }

                res = Math.max(res, right - left);
            }

            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
        // put your test code here

        String s = "AABABBA";
        int k = 1;

        System.out.println(solution.characterReplacement(s, k));
    }
}
