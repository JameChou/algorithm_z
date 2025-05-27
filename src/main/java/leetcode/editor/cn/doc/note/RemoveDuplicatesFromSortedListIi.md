# 删除相同元素的链表

[删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/)

这题的解法有以下几种:

## 使用HashMap
可以使用 `HashMap` 在第一次循环之中将每个节点的数量给记住。

```java
Map<Integer, Integer> node = new HashMap<>();
while (cur != null) {
    node.merge(cur.val, 1, Integer::sum);
    cur = cur.next;
}
```
后续的过程中，我们再循环一次，拿到每个节点，如果这个节点出现的次数是超过 `1` 的时候则不添加到新的链表中去。

```java
cur = head;
while (cur != null) {
    int count = node.get(cur.val);
    if (count <= 1) {
        p.next = cur;
        p = p.next;
    }

    cur = cur.next;
}
p.next = null;
```

但是这个程序运行的速度是最低效的。时间复杂度和空间复杂度都提升了一点。

完整代码这里贴一下。

```java
public ListNode deleteDuplicates(ListNode head) { 
    ListNode dummy = new ListNode(-1), p = dummy;

    ListNode cur = head;
    Map<Integer, Integer> node = new HashMap<>();
    while (cur != null) {
        node.merge(cur.val, 1, Integer::sum);
        cur = cur.next;
    }

    cur = head;
    while (cur != null) {
        int count = node.get(cur.val);
        if (count <= 1) {
            p.next = cur;
            p = p.next;
        }

        cur = cur.next;
    }
    p.next = null;

    return dummy.next;
}
```

```
> 2025/05/27 21:55:59	
Success:
	Runtime:3 ms, faster than 3.59% of Java online submissions.
	Memory Usage:43.1 MB, less than 5.01% of Java online submissions.
```

上面是提交后的结果。

## 双指针记录重复的节点和不重复的节点
我们可以使用两个链表分别去记重复的节点和非重复的节点。

```java
public ListNode deleteDuplicates(ListNode head) {
    // 为什么这里需要设置101题目中说明了，链表的节点值最大是为100，所以这里设置dummy的节点值为101
    ListNode dummy1 = new ListNode(101);
    ListNode dummy2 = new ListNode(101);

    ListNode repeatList = dummy1;
    ListNode singleList = dummy2;

    ListNode p = head;
    while (p != null) {
        // 如果当前的节点值==下一个节点的值或者当前节点的值等于重复链表最后一个值
        // 则表示这个节点是重复的
        if ((p.next != null && p.val == p.next.val) || p.val == repeatList.val) {
            repeatList.next = p;
            repeatList = repeatList.next;
        } else {
            singleList.next = p;
            singleList = singleList.next;
        }

        p = p.next;
        // 断开原链表的连接
        singleList.next = null;
        repeatList.next = null;
    }

    return dummy2.next;
}
```

>[!important]
>
>这里的一个重点是，判断是否这个节点是重复的，因为题目中的要求是说这两个链表是已经排好序的。 
>
>`if ((p.next != null && p.val == p.next.val) || p.val = repeatList.val)` 
>
>这里的判断尤为重要。



