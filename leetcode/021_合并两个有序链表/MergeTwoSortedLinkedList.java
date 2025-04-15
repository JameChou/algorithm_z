public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoList(ListNode list1, ListNode list2) {

        ListNode list = null;
        ListNode rtnList = null;

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        while (list1 != null && list2 != null) {
            // 只放一个就好了啊
            if (list1.val > list2.val) {
                if (list == null) {
                    list = new ListNode(list2.val);
                    rtnList = list;
                } else {
                    list.next = new ListNode(list2.val);
                    list = list.next;
                }
                list2 = list2.next;
            } else {
                if (list == null) {
                    list = new ListNode(list1.val);
                    rtnList = list;
                } else {
                    list.next = new ListNode(list1.val);
                    list = list.next;
                }
                list1 = list1.next;
            }

        }

        if (list1 == null && list2 == null) {
            return rtnList;
        }

        if (list1 == null) {
            list.next = list2;
        } else {
            list.next = list1;
        }

        return rtnList;
    }

    public static void main(String[] args) {
        // for test
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node1.next.next = node3;

        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node33 = new ListNode(4);

        node11.next = node22;
        node11.next.next = node33;

        ListNode rtnList = new MergeTwoSortedLinkedList().mergeTwoList(node1, node11);
        System.out.println(rtnList);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
