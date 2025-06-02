
package leetcode.editor.cn;

import leetcode.editor.common.*;

/**
 * 判断一个链表是否为回文链表
 * 如: 1 -> 2 -> 2 -> 1
 * 就是一个回文链表
 */
public class PalindromeLinkedList {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // ListNode left = null;
        // boolean result = true;
        //
        // public boolean isPalindrome(ListNode head) {
        // left = head;
        //
        // traverse(head);
        //
        // return result;
        // }
        //
        // public void traverse(ListNode right) {
        // if (right == null) {
        // return;
        // }
        //
        // traverse(right.next);
        // if (left.val != right.val) {
        // result = false;
        // return;
        // }
        //
        // left = left.next;
        // }

        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return false;
            }

            ListNode left = head;
            // 找到中间节点
            ListNode middle = findMiddle(head);

            // 中间节点到链表的尾部这一半的链表进行反转操作
            ListNode right = reverse(middle);

            // 左右两侧的链表进行遍历比较
            while (right != null) {
                if (right.val != left.val) {
                    return false;
                }

                right = right.next;
                left = left.next;
            }

            return true;
        }

        // 对链表进行反转操作
        public ListNode reverse(ListNode head) {
            ListNode dummy = new ListNode(-1), cur, p;
            p = head;
            while (p != null) {
                cur = p;
                p = p.next;

                cur.next = dummy.next;
                dummy.next = cur;
            }

            return dummy.next;
        }

        // 找到中间节点
        public ListNode findMiddle(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 说明这个链表的长度是一个奇数
            if (fast != null) {
                return slow.next;
            }
            // 链表是长度是偶数
            return slow;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // put your test code here

        // test for the solution method
        int[] nums = { 1, 2 };
        ListNode head = ListNode.createHead(nums);
        boolean result = solution.isPalindrome(head);
        System.out.println(result);
    }
}
