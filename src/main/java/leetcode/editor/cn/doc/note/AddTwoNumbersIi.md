# 两数相加II

[两数相加II](https://leetcode.cn/problems/add-two-numbers-ii/description/)

这是之前两数相加的进阶版，原来是使用数组来存储各个位置上的数字。现在换成链表了。

我先想到的是将这个链表进行反转，然后再从第一位开始去相加。但是有点**笨**，然后看到别人的处理是使用栈就有种开朗的感觉了。对啊为什么不用栈呢？

使用栈可以将整个链表进行反转。再进行相加操作

实现代码如下:

```java
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
```

