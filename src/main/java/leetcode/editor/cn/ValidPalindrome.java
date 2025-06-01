
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 125 验证回文串
 */
public class ValidPalindrome {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;

            // s = s.toLowerCase();
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
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        // put your test code here

        String s = "0P";
        boolean result = solution.isPalindrome(s);
        System.out.println(result);
    }
}
