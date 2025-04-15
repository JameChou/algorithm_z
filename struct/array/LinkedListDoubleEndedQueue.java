/**
 * 使用链表实现一个双向的队列
 * 
 * @link https://www.hello-algo.com/chapter_stack_and_queue/deque/#1
 */
public class LinkedListDoubleEndedQueue {
    /**
     * 链表类，这里使用的是不循环的双向链表
     */
    class LinkedList {
        LinkedList prev;
        LinkedList next;
        int val;

        public LinkedList(int val) {
            this.val = val;
            prev = next = null;
        }
    }

    private int size;
    // 持有队列的前后两个节点对象
    private LinkedList front, rare;

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在队列的头部push一个数据
     *
     * @param val 需要往队首添加的数据
     */
    public void pushFirst(int val) {
        if (isEmpty()) {
            front = rare = new LinkedList(val);
            size++;
            return;
        }

        LinkedList node = new LinkedList(val);
        node.next = front;
        front.prev = node;
        front = node;
        size++;
    }

    /**
     * 从队列后面添加数据
     *
     * @param val 从队列最后面push一个元素
     */
    public void pushLast(int val) {
        if (isEmpty()) {
            front = rare = new LinkedList(val);
            size++;
            return;
        }

        LinkedList node = new LinkedList(val);
        node.prev = rare;
        rare.next = node;
        rare = node;
        size++;
    }

    public int pop() {
        return popFirst();
    }

    public void push(int val) {
        pushLast(val);
    }

    /**
     * 拿到队首的第一条数据
     *
     * @return 正常队列的pop数据
     */
    public int popFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        LinkedList tempNode = front;

        int data = front.val;
        front = front.next;
        tempNode.prev = null;
        tempNode.next = null;
        size--;

        return data;
    }

    /**
     * @return 返回队尾的元素
     */
    public int popLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        int data = rare.val;
        rare = rare.prev;
        rare.next = null;
        size--;

        return data;
    }

    public static void main(String[] args) {
        LinkedListDoubleEndedQueue queue = new LinkedListDoubleEndedQueue();
        for (int i = 1; i <= 10; i++) {
            queue.push(i);
        }

        queue.pop();
        queue.pop();

        queue.pushFirst(11);
        queue.pushFirst(12);

        while (!queue.isEmpty()) {
            System.out.print(queue.pop() + " ");
        }

        System.out.println();
    }
}
