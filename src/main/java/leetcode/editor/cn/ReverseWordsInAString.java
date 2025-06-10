
package leetcode.editor.cn;

/**
 * input: s = "the sky is blue"
 * output: "blue is sky the"
 */
public class ReverseWordsInAString {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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

        /**
         * 这个方法是反转一个字符数组指定的区间
         *
         * @param array 字符数组
         * @param i     反转的起始区间
         * @param j     反转的终止区间
         */
        public void reverseCharArray(char[] array, int i, int j) {
            int left = i, right = j;
            while (left <= right) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;

                left++;
                right--;
            }
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        // put your test code here

        String param = "the sky is blue";
        String result = solution.reverseWords(param);

        System.out.println(result);
    }
}
