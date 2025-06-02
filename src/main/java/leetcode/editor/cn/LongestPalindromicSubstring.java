
package leetcode.editor.cn;

public class LongestPalindromicSubstring {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {

            String longestSubString = "";
            for (int i = 0; i < s.length(); i++) {
                String subString1 = middleSubString(s, i, i);
                String subString2 = middleSubString(s, i, i + 1);

                String longestSubStringTemp = subString1.length() > subString2.length() ? subString1 : subString2;

                longestSubString = longestSubString.length() > longestSubStringTemp.length() ? longestSubString
                        : longestSubStringTemp;
            }

            return longestSubString;
        }

        /**
         * 这个函数主要是从某个位置分别向左和右展开去找到最长的子串
         *
         * @param s 需要找子串的字符串
         * @param l 起始的左指针
         * @param r 起始的右指针
         */
        public String middleSubString(String s, int l, int r) {
            if (s == null || s.equals("")) {
                return null;
            }

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            return s.substring(l + 1, r);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // put your test code here

        String str = "babad";
        String result = solution.longestPalindrome(str);
        System.out.println(result);

    }
}
