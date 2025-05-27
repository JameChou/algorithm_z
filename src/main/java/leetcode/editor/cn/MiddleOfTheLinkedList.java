
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
        // 使用快慢指针的方式去找到中间节点
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            // 下面的疑问不需要去管，因为这里我们已经对fast.next != null进行判断了
            while (fast != null && fast.next != null) {
                slow = slow.next;
                // 这里会抛一个null exception的吧?
                fast = fast.next.next;
            }

            return slow;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
        // put your test code here
        // int[] nums = { 1, 2, 3, 4, 5 };
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        // int[] nums = { 1, 2 };
        // int[] nums = { 1 };
        ListNode head = ListNode.createHead(nums);
        ListNode result = solution.middleNode(head);
        ListNode.print(result);
    }
}
