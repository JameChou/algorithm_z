# 按K个一组来进行反转

## 反转N个节点
我们首先要处理反转 `N` 个节点，这个方法我们已经处理过了。

```java
public ListNode reverseNodes(ListNode head, int n) {
    ListNode dummy = new ListNode(-1);
    ListNode p = head, cur = null;

    int k = n;
    while (p != null && k > 0) {
        cur = p;
        p = p.next;
        cur.next = dummy.next;
        dummy.next = cur;

        k--;
    }

    return dummy.next;
}
```

上面的代码就是按 `N` 个数量反转节点。然后返回新的头节点。


## 递归反转 `K` 个数量一组节点
这里先直接看代码是如何处理的。

```java
public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode a = head, b = head;
    for (int i = 0; i < k; i++) {
        // 表明已经到了节点的最后
        if (b == null) {
            return head;
        }

        b = b.next;
    }

    // 拿到新的节点，反转前K个节点
    ListNode newHead = reverseNodes(a, k);
    // 此时的b已经指向了后一个节点了
    // 因为上面的for循环已经找到下一个了
    // 这时候a节点已经被反转到最后一个了，这时候a.next就是递归后的结果
    a.next = reverseKGroup(b, k);

    return newHead;
}
```

### 判断是否还可以按要求即 `K` 个数量的节点进行反转

```java

ListNode a = head, b = head;
for (int i = 0; i < k; i++) {
    // 表明已经到了节点的最后
    if (b == null) {
        return head;
    }

    b = b.next;
}
```

这段代码完成了两件事:
1. 判断现在的链表长度是否可以按照 `K` 个节点数量反转了，如果 `length <= k` 这个时候 `b == null` 则会直接返回。
2. 当这段 `for` 循环结束之后，`b` 这时候已经是下一个需要反转链表的起始位置了。

### 递归去反转

```java

ListNode newHead = reverseNodes(a, k);
a.next = reverseKGroup(b, k);

return newHead;
```

这里还是分两个部分。

1. `ListNode newHead = reverseNodes(a, k)` 这段代码不需要再去解释了，即调用第一个章节的方法，其实就是对一个链前 `N` 个节点进行反转。
2. `a.next = reverseKGroup(b, k)` 因为 **`a` 这时候已经是反转过的了，从头到尾，另外 `b` 这个节点经过上面的 `for` 循环已经<u>指向下一组了</u>。**


