
package leetcode.editor.cn;

import leetcode.editor.common.*;

public class IntersectionOfTwoLinkedLists {

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;

            while (p1 != p2) {
                if (p1 == null) {
                    p1 = headB;
                } else {
                    p1 = p1.next;
                }

                if (p2 == null) {
                    p2 = headA;
                } else {
                    p2 = p2.next;
                }
            }

            return p1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        // put your test code here

        solution.getIntersectionNode(null, null);
    }
}
