
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MergeKSortedLists {

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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            ListNode dummy = new ListNode(-1), p = dummy;

            // 初始化长度为3的堆
            PriorityQueue<ListNode> queue = new PriorityQueue<>(3, (a, b) -> a.val - b.val);
            for (ListNode node : lists) {
                if (node != null) {
                    // push 
                    queue.offer(node);
                }
            }

            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                p.next = node;

                node = node.next;
                if (node != null) {
                    queue.offer(node);
                }
                p = p.next;
            }

            return dummy.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here

        int[] nums1 = { 1, 4, 5 };
        int[] nums2 = { 1, 3, 4 };
        int[] nums3 = { 2, 6 };

        ListNode list1 = ListNode.createHead(nums1);
        ListNode list2 = ListNode.createHead(nums2);
        ListNode list3 = ListNode.createHead(nums3);

        ListNode[] lists = { list1, list2, list3 };

        ListNode result = solution.mergeKLists(lists);
        ListNode.print(result);
    }
}
