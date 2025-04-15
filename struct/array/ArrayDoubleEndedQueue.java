package array;

/**
 * 数组去实现一个双向的队列
 */
public class ArrayDoubleEndedQueue {
    public static final int QUEUE_DEFAULT_SIZE = 50;

    int[] array;
    // 前后两个指针
    int front, rare;
    // 队列大小
    int queueSize;

    public ArrayDoubleEndedQueue(int size) {
        this.array = new int[size];
        front = rare = -1;
        queueSize = 0;
    }

    public ArrayDoubleEndedQueue() {
        this.array = new int[QUEUE_DEFAULT_SIZE];
        front = rare = -1;
        queueSize = 0;
    }

    public int capacity() {
        return this.array.length;
    }

    public void push(int val) {
        pushLast(val);
    }

    public int pop() {
        return popFirst();
    }

    /**
     * 从队列的前面添加一个元素
     *
     * @param val 需要添加的元素
     */
    public void pushFirst(int val) {
        if (capacity() == queueSize) {
            throw new IndexOutOfBoundsException();
        }

        front = (front - 1 + capacity()) % capacity();
        array[front] = val;
        queueSize++;
    }

    /**
     * 从队列后添加一个元素
     *
     * @param val 需要添加的元素
     */
    public void pushLast(int val) {
        if (capacity() == queueSize) {
            throw new IndexOutOfBoundsException();
        }

        rare = (rare + 1) % capacity();
        array[rare] = val;
        queueSize++;
    }

    /**
     * 弹出队列的元素数据
     *
     * @return 返回队列前部的元素数据
     */
    public int popFirst() {
        if (queueSize == 0) {
            throw new IndexOutOfBoundsException();
        }

        if (front == -1) {
            front = 0;
        }
        int data = array[front];
        front = (front + 1) % capacity();

        queueSize--;

        return data;
    }

    public int popLast() {
        if (queueSize == 0) {
            throw new IndexOutOfBoundsException();
        }

        if (rare == -1) {
            rare = 0;
        }
        int data = array[rare];

        rare = (rare - 1 + capacity()) % capacity();
        queueSize--;
        return data;
    }

    public boolean isEmpty() {
        return queueSize == 0;
    }

    public static void main(String[] args) {
        ArrayDoubleEndedQueue queue = new ArrayDoubleEndedQueue(10);
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
