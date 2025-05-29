
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 反转指定区间的链表
 */
public class ReverseLinkedListIi {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 反转指定区间的链表
         *
         * 链表中节点数目为 n
         * 1 <= n <= 500
         * -500 <= Node.val <= 500
         * 1 <= left <= right <= n
         *
         * @param head  链表的头
         * @param left  左侧区间
         * @param right 右侧区间
         */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);

            // leftNode 记录左侧不在翻转区间-1的节点，rightNode记录右侧节点
            ListNode p = head, cur = null, leftNode = head, rightNode = null;
            int cursor = 1;
            while (p != null && cursor <= right) {
                cur = p;
                p = p.next;
                if (cursor >= left) {
                    if (rightNode == null) {
                        rightNode = cur;
                    }
                    cur.next = dummy.next;
                    dummy.next = cur;
                } else {
                    leftNode = cur;
                }
                cursor++;
            }
            leftNode.next = dummy.next;
            rightNode.next = p;
            // 表示翻转的区间如果是从1开始的则说明head已经改变了
            // 如果只是部分的话则不需要处理直接返回head即可
            if (left == 1) {
                return dummy.next;
            } else {
                return head;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        // put your test code here

        // int[] nums = { 1, 2, 3, 4, 5 };
        int[] nums = { 3, 5 };
        ListNode head = ListNode.createHead(nums);

        // int left = 2, right = 4;
        int left = 1, right = 2;
        ListNode result = solution.reverseBetween(head, left, right);
        ListNode.print(result);
    }
}
