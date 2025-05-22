package struct.array;

public class ArrayQueue {
    private static final int DEFAULT_SIZE = 50;
    private int[] array;
    // 队列的大小
    private int size;
    // 头部的游标指针
    private int front;

    public ArrayQueue(int capacity) {
        this.array = new int[capacity];
        this.size = this.front = 0;
    }

    public ArrayQueue() {
        this.array = new int[DEFAULT_SIZE];
        this.size = this.front = 0;
    }

    public int capacity() {
        return this.array.length;
    }

    public int size() {
        return this.size;
    }

    public void push(int element) {
        if (capacity() == this.size) {
            throw new IndexOutOfBoundsException();
        }

        // 使用取余的操作来达到循环的效果
        int end = (this.front + this.size) % capacity();
        this.array[end] = element;
        this.size++;
    }

    public int pop() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }

        int data = this.array[front];
        front = (front + 1) % capacity();
        size--;

        return data;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        for (int i = 1; i <= 4; i++) {
            queue.push(i);
        }

        System.out.println(queue.pop());
        System.out.println(queue.pop());

        for (int i = 5; i <= 7; i++) {
            queue.push(i);
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println(queue.pop());
        }

    }
}
