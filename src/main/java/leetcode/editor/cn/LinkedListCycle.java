
package leetcode.editor.cn;

import leetcode.editor.common.*;

public class LinkedListCycle {

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = slow;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
        // put your test code here
        solution.hasCycle(null);
    }
}
