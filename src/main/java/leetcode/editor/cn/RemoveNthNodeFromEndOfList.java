
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveNthNodeFromEndOfList {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 虚拟头结点
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
            // 之前我这里传入的是findFromEnd(head, n + 1)
            // 或 findFromEnd(head, dummy.next);

            // 这种在处理[1], 1这种情况时则会出现Exception
            ListNode x = findFromEnd(dummy, n + 1);
            // 删掉倒数第 n 个节点
            x.next = x.next.next;
            return dummy.next;
        }

        // 返回链表的倒数第 k 个节点
        ListNode findFromEnd(ListNode head, int k) {
            ListNode p1 = head;
            // p1 先走 k 步
            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }
            ListNode p2 = head;
            // p1 和 p2 同时走 n - k 步
            while (p1 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
            return p2;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here
        // int[] nums = { 1, 2, 3, 4, 5 };
        // int n = 2;

        int[] nums = { 1 };
        int n = 1;

        ListNode head = ListNode.createHead(nums);
        ListNode result = solution.removeNthFromEnd(head, n);
        ListNode.print(result);

    }
}
