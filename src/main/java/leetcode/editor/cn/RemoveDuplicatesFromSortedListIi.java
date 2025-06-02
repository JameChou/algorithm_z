
package leetcode.editor.cn;

import leetcode.editor.common.*;

/**
 * 给定一个已排序的链表的头 head，删除原始链表中所有重复数字的节点，只留下不同的数字。返回已排序的链表。
 *
 * 输入：head = [1, 2, 3, 3, 4, 4, 5]
 * 输出: [1, 2, 5]
 *
 */
public class RemoveDuplicatesFromSortedListIi {

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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy1 = new ListNode(101);
            ListNode dummy2 = new ListNode(101);

            ListNode repeatList = dummy1;
            ListNode singleList = dummy2;

            ListNode p = head;
            while (p != null) {
                // 如果当前的节点值==下一个节点的值或者当前节点的值等于重复链表最后一个值
                // 则表示这个节点是重复的
                if ((p.next != null && p.val == p.next.val) || p.val == repeatList.val) {
                    repeatList.next = p;
                    repeatList = repeatList.next;
                } else {
                    singleList.next = p;
                    singleList = singleList.next;
                }

                p = p.next;
                singleList.next = null;
                repeatList.next = null;
            }

            return dummy2.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        // put your test code here

        ListNode head = ListNode.createHead(new int[] { 1, 2, 3, 3, 4, 4, 5 });
        ListNode result = solution.deleteDuplicates(head);
        ListNode.print(result);
    }
}
