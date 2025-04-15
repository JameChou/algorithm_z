public class DeleteDunplicateFromSortedList {

    /**
     * 这道题还是比较简单的，就是常规的对链表进行去重的操作
     *
     * @head 链的表头数据
     * @return 新的去重链表数据
     */
    public ListNode deleteDunplicates(ListNode head) {
        ListNode index = head;
        ListNode rtnNode = head;

        while (head != null) {
            // 表明现在的这个值跟之前的index是一样的这个时候就不需要更新index
            if (head.val != index.val) {
                index = head;
            } else {
                // 表明现在的值是相等，有是有重复数据的
                if (head.next != null && head.next.val != index.val) {
                    index.next = head.next;
                }
                // 表明是最后一个节点
                if (head.next == null) {
                    index.next = null;
                }
            }

            head = head.next;
        }

        return rtnNode;
    }

    public static void main(String[] args) {
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val) {
            this.val = val;
        }
    }
}
