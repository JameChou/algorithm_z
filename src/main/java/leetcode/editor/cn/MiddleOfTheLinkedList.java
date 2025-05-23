
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MiddleOfTheLinkedList {

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
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }
            int length = 0;
            ListNode p = head;

            while (p != null) {
                length += 1;
                p = p.next;
            }

            int rtnIndex = length / 2 + 1;
            p = head;
            for (int i = 0; i < rtnIndex - 1; i++) {
                p = p.next;
            }

            return p;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
        // put your test code here
        // int[] nums = { 1, 2, 3, 4, 5 };
        // int[] nums = { 1, 2, 3, 4, 5, 6 };
        int[] nums = { 1, 2 };
        ListNode head = ListNode.createHead(nums);
        ListNode result = solution.middleNode(head);
        ListNode.print(result);
    }
}
