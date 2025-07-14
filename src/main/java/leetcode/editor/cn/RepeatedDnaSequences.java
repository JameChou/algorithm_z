
package leetcode.editor.cn;

import java.awt.event.WindowFocusListener;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 187 重复的DNA序列
 *
 * https://leetcode.cn/problems/repeated-dna-sequences/description/
 *
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 */
public class RepeatedDnaSequences {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int n = s.length();
            int[] nums = new int[n];
            int prev = -1;
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
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
        // put your test code here

        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = solution.findRepeatedDnaSequences(s);
        System.out.println(result.toString());
    }
}
