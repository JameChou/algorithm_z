package array;

/**
 * 实现一个双向不循环链表
 */
public class LinkedList<E> {
    protected E data;
    protected LinkedList<E> prev;
    protected LinkedList<E> next;

    public LinkedList() {
    }

    public LinkedList(E data) {
        this.data = data;
    }

    public LinkedList(E data, LinkedList<E> prev, LinkedList<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /**
     * 在尾部插入一个节点
     *
     * @data 数据
     */
    public void add(E data) {
        LinkedList<E> node = new LinkedList<>();
        node.data = data;

        LinkedList<E> temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }

        node.prev = temp;
        node.next = null;
        temp.next = node;
    }

    /**
     * 在头部插入一个节点
     *
     * @data 需要插入的数据
     */
    public void insert(E data) {
        LinkedList<E> node = new LinkedList<>();
        node.data = data;
        node.next = this;
        this.prev = node;
        node.prev = null;
    }

    /**
     * 向链表中指定的一个位置插入一个节点
     *
     * @index 需要插入的位置
     * @data 需要插入的数据
     */
    public void insert(int index, E data) {
        if (index < 0) {
            return;
        }
        LinkedList<E> node = new LinkedList<>();

        node.data = data;
        LinkedList<E> temp = this;
        int at = 0;
        while (temp != null && at < index) {
            temp = temp.next;
            at++;
        }

        if (temp == null || at < index) {
            return;
        }

        if (temp.next != null) {
            temp.next.prev = node;
        }
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
    }

    /**
     * 得到某个位置下的元素节点
     *
     * @index 位置
     */
    public LinkedList<E> get(int index) {
        if (index < 0) {
            return null;
        }

        LinkedList<E> temp = this;
        int at = 0;
        while (temp != null && at < index) {
            temp = temp.next;
            at++;
        }

        if (at != index) {
            return null;
        }

        return temp;
    }

    /**
     * 删除一个元素节点
     *
     * @index 位置
     */
    public void removeAt(int index) {
        if (index < 0) {
            return;
        }

        int at = 0;
        LinkedList<E> temp = null;
        while (temp != null && at < index) {
            temp = temp.next;
        }

        if (at != index) {
            return;
        }

        temp.prev.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    public void showAll() {
        LinkedList<E> temp = this;

        while (temp != null) {
            System.out.println(temp.data);

            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> strList = new LinkedList<String>("-1");
        strList.add("ABC");
        strList.add("DEF");
        strList.add("GHJK");
        strList.add("Hello");

        strList.showAll();

        System.out.println("--------------------------------");
        strList.removeAt(2);
        strList.showAll();

    }

}
