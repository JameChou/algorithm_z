
package leetcode.editor.cn;

import leetcode.editor.common.*;

public class LinkedListCycleIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = slow;

            // 找到交汇点
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                // 交汇之后break跳出循环
                if (slow == fast) {
                    break;
                }
            }

            // 表明现在这个链表并不是一个循环链表
            if (fast == null || fast.next == null) {
                return null;
            }

            // slow重回head，两者同步以1的速度向前进，交汇之后就是循环的起点
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        // put your test code here

    }
}
