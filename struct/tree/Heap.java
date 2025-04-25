package tree;

public class Heap {

    private Integer heap[];
    private static final int DEFAULT_SIZE = 50;

    public Heap(int size) {
        this.size = 0;
        if (size > 0) {
            heap = new Integer[size];
        } else {
            heap = new Integer[DEFAULT_SIZE];
        }
    }

    public Heap() {
        this.size = 0;
        heap = new Integer[DEFAULT_SIZE];
    }

    private int size;

    public int size() {
        return size;
    }

    /**
     * 得到左节点的索引
     *
     * @param i 需要得到左节点索引的节点在数组中的索引值
     * @return 左节点的索引位置
     */
    public int left(int i) {
        return 2 * i + 1;
    }

    /**
     * 得到右节点的索引
     *
     * @param i 需要得到右节点索引的节点在数组中的索引值
     * @return 右节点的索引位置
     */
    public int right(int i) {
        return 2 * i + 2;
    }

    /**
     * 得到当前的这个节点的父节点位置索引
     * 
     * @param i 当前节点的位置索引
     * @return 父节点的索引位置
     */
    public int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 向堆中push元素，元素入堆操作
     *
     * @param 需要入堆的元素
     */
    public void push(int val) {
        // 堆中的元素已经满了则向外抛出Exception
        if (size == heap.length) {
            throw new IndexOutOfBoundsException();
        }

        heap[size] = val;
        size++;
        swim(size - 1);
    }

    /**
     * 交换数组中的两个位置的值
     *
     * @param i 位置i
     * @param p 位置p
     */
    private void swap(int i, int p) {
        int temp = heap[i];
        heap[i] = heap[p];
        heap[p] = temp;
    }

    /**
     * 堆化操作，其实这里相当于上浮操作，将新插入的值上浮
     *
     * @param i 需要上浮的元素索引
     */
    private void swim(int i) {
        // 上浮的跳出条件是什么？
        int p = parent(i);
        while (heap[i] > heap[p]) {
            if (p == 0) {
                if (heap[i] > heap[0]) {
                    swap(i, p);
                }
                break;
            }
            swap(i, p);
            i = p;
            p = parent(i);
        }
    }

    /**
     * 拿到堆顶元素
     *
     * @return 堆顶元素，如果现在堆的大小已经是0的情况下，返回null
     */
    public Integer pop() {
        if (size() == 0) {
            return null;
        }

        // 先交换队首的元素到最尾部
        swap(0, size() - 1);

        Integer rtnValue = heap[size() - 1];

        size--;
        sink(0);
        // 交换完了之后，需要再下潜重新将堆进行排序

        return rtnValue;
    }

    /**
     * 下沉操作，我们需要对现在这个节点下面的所有子节点进行比较操作
     * 如果下面的元素有比自己大的，则进行交换，直到交换到没有数据为止
     */
    private void sink(int i) {
        int left = left(i);
        int right = right(i);

        while (left < size || right < size) {
            // 如果小于左节点的话，下沉至左节点位置
            if (left < size && heap[i] < heap[left]) {
                swap(i, left);
                i = left;
                // 如果小于右节点，下沉至右节点位置
            } else if (right < size && heap[i] < heap[right]) {
                swap(i, right);
                i = right;
            } else {
                // 都不符合则跳出当前循环
                break;
            }

            left = left(i);
            right = right(i);
        }
    }

    public Integer peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return heap[0];
    }

    public static void main(String[] args) {
        Heap pq = new Heap(5);
        pq.push(3);
        pq.push(2);
        pq.push(1);
        pq.push(5);
        pq.push(4);

        System.out.println(pq.pop()); // 1
        System.out.println(pq.pop()); // 2
        System.out.println(pq.pop()); // 3
        System.out.println(pq.pop()); // 4
        System.out.println(pq.pop()); // 5
    }
}
