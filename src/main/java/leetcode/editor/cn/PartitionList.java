
package leetcode.editor.cn;

import leetcode.editor.common.*;

public class PartitionList {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode partition(ListNode head, int x) {
            // 虚拟头节点
            ListNode dummy1 = new ListNode(-1);
            ListNode dummy2 = new ListNode(-1);

            // p1表存是小于x的节点 p2表存的是>=x的节点
            ListNode p1 = dummy1, p2 = dummy2;
            ListNode p = head;

            while (p != null) {
                // 判断现在p的值是否>=x如果是的话，则添加到p2这个链表中，否则为p1
                if (p.val >= x) {
                    p2.next = p;
                    p2 = p2.next;
                } else {
                    p1.next = p;
                    p1 = p1.next;
                }

                // 这里需要将原来的链接给去除掉
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }

            p1.next = dummy2.next;

            return dummy1.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        // put your test code here

        int num[] = { 1, 4, 3, 2, 5, 2 };
        ListNode list = ListNode.createHead(num);

        // 输出应该为 [1, 2, 2, 4, 3, 5]
        ListNode result = solution.partition(list, 3);
        ListNode.print(result);
    }
}
