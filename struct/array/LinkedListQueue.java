package array;

import java.util.LinkedList;

/**
 * 使用链表去实现队列
 */
public class LinkedListQueue<E> {
    private int size = 50;
    private LinkedList<E> eles;

    public LinkedListQueue() {
        eles = new LinkedList<>();
    }

    public LinkedListQueue(int size) {
        this.size = size;
        eles = new LinkedList<>();
    }

    public void push(E element) {
        if (eles.size() == size) {
            throw new IndexOutOfBoundsException();
        }
        eles.add(element);
    }

    public E pop() {
        if (eles.size() == 0) {
            return null;
        }

        E e = eles.getFirst();
        eles.removeFirst();

        return e;
    }

    public int size() {
        return eles.size();
    }

    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        for (int i = 1; i <= 10; i++) {
            queue.push("elements[" + i + "]: " + i);
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.pop());
        }
    }
}
