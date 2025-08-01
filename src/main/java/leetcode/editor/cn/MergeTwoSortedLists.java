
package leetcode.editor.cn;

import leetcode.editor.common.*;

public class MergeTwoSortedLists {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            ListNode dummy = new ListNode(-1), p = dummy;
            ListNode p1 = list1, p2 = list2;

            while (p1 != null && p2 != null) {
                if (p1.val > p2.val) {
                    p.next = p2;
                    p2 = p2.next;
                } else {
                    p.next = p1;
                    p1 = p1.next;
                }

                p = p.next;
            }

            if (p1 != null) {
                p.next = p1;
            }

            if (p2 != null) {
                p.next = p2;
            }

            return dummy.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // put your test code here

        int num1[] = { 1, 2, 4 };
        int num2[] = { 1, 3, 4 };

        ListNode list1 = ListNode.createHead(num1);
        ListNode list2 = ListNode.createHead(num2);

        ListNode result = solution.mergeTwoLists(list1, list2);
        ListNode.print(result);
    }
}
