
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 示例1：
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 *
 * 示例2：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 *
 * 示例3：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 */
public class AddTwoNumbersIi {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 如果使用转化int的方式也是一样无法进行处理的
            // 先将链表进行反转操作? 然后再相加

            // 两个栈对链表进行处理
            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();

            ListNode dummy = new ListNode(-1);

            ListNode p1 = l1, p2 = l2;
            while (p1 != null) {
                stack1.push(p1);
                p1 = p1.next;
            }
            while (p2 != null) {
                stack2.push(p2);
                p2 = p2.next;
            }

            int step = 0;
            // 栈1和栈2进行弹出操作
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                ListNode node1 = stack1.pop();
                ListNode node2 = stack2.pop();

                int plus = node1.val + node2.val + step;
                step = plus / 10;
                ListNode plusNode = new ListNode(plus % 10);
                plusNode.next = dummy.next;
                dummy.next = plusNode;
            }

            Stack<ListNode> stack = null;
            if (!stack1.isEmpty()) {
                stack = stack1;
            }
            if (!stack2.isEmpty()) {
                stack = stack2;
            }
            // 处理两个链表长度不一样的问题
            while (stack != null && !stack.isEmpty()) {
                ListNode node1 = stack.pop();
                int plus = node1.val + step;

                step = plus / 10;
                ListNode plusNode = new ListNode(plus % 10);
                plusNode.next = dummy.next;
                dummy.next = plusNode;
            }

            // 如果最后还有进位则需要再处理一下
            if (step > 0) {
                ListNode stepNode = new ListNode(step);
                stepNode.next = dummy.next;
                dummy.next = stepNode;
            }

            return dummy.next;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        // put your test code here

        int[] nums1 = { 7, 2, 4, 3 };
        int[] nums2 = { 5, 6, 4 };
        ListNode l1 = ListNode.createHead(nums1);
        ListNode l2 = ListNode.createHead(nums2);

        ListNode result = solution.addTwoNumbers(l1, l2);
        ListNode.print(result);
    }
}
