package array;

import java.util.ArrayList;

/**
 * 使用数组来实现Stack栈结构
 * 此次不再使用链表去实现栈数据结构了，因为跟数组是差不多的
 */
public class ArrayStack<E> {
    private ArrayList<E> eles;

    // 游标指针
    private int cursor = -1;
    private int size = 50;

    public ArrayStack() {
        // 默认大小为50个元素
        eles = new ArrayList<>(size);
    }

    public ArrayStack(int size) {
        eles = new ArrayList<>(size);
        this.size = size;
    }

    public void push(E element) {
        // 现在已经指向到最后一个时候
        if (this.size == (cursor + 1)) {
            return;
        }

        eles.add(element);
        cursor++;
    }

    public E pop() {
        if (cursor == -1) {
            throw new IndexOutOfBoundsException();
        }

        E rtnValue = eles.get(cursor);
        cursor--;
        return rtnValue;
    }

    public int size() {
        return (cursor + 1);
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }

        int size = stack.size();
        for (int i = 0; i < size + 1; i++) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();
    }
}
