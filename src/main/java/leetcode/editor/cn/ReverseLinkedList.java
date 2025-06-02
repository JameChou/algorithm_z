
package leetcode.editor.cn;

import leetcode.editor.common.*;

/**
 * 反转链表
 */
public class ReverseLinkedList {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
         * public ListNode reverseList(ListNode head) {
         * ListNode dummy = new ListNode(-1);
         * 
         * ListNode cur = null, p = head;
         * while (p != null) {
         * cur = p;
         * p = p.next;
         * cur.next = dummy.next;
         * dummy.next = cur;
         * }
         * return dummy.next;
         * }
         */

        /**
         * 上面一种是使用迭代法去处理这个问题，这个方法是使用递归法去处理
         */
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return last;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // put your test code here
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = ListNode.createHead(nums);
        ListNode result = solution.reverseList(head);
        ListNode.print(result);
    }
}
