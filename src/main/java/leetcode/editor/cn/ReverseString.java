
package leetcode.editor.cn;

/**
 * 是将这个字符串进行反转
 */
public class ReverseString {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            // 左右两个index指针
            int left = 0, right = s.length - 1;

            while (left <= right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;

                left++;
                right--;
            }

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        // put your test code here

        char[] chars = { 'H', 'e', 'l', 'l', 'o', 'o' };
        solution.reverseString(chars);
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
