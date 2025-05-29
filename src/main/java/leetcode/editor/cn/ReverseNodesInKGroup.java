
package leetcode.editor.cn;

import leetcode.editor.common.*;

public class ReverseNodesInKGroup {

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * 把一个链表按K个一组进行反转
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode a = head, b = head;
            for (int i = 0; i < k; i++) {
                // 表明已经到了节点的最后
                if (b == null) {
                    return head;
                }

                b = b.next;
            }

            // 拿到新的节点，反转前K个节点
            ListNode newHead = reverseNodes(a, k);
            // 此时的b已经指向了后一个节点了
            // 因为上面的for循环已经找到下一个了
            // 这时候a节点已经被反转到最后一个了，这时候a.next就是递归后的结果
            a.next = reverseKGroup(b, k);

            return newHead;
        }

        /**
         * 对指定的长度的N进行反转
         *
         * @param head 需要反转的节点
         * @param n    需要反转的长度
         *
         * @return 反转后的头节点
         */
        public ListNode reverseNodes(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            ListNode p = head, cur = null;

            int k = n;
            while (p != null && k > 0) {
                cur = p;
                p = p.next;
                cur.next = dummy.next;
                dummy.next = cur;

                k--;
            }

            return dummy.next;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        // put your test code here
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = ListNode.createHead(nums);

        int k = 2;
        ListNode result = solution.reverseKGroup(head, k);
        ListNode.print(result);
    }
}
