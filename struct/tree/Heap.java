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
        // 如果现在堆已经到达最大值的情况下抛出Exception，只是简单实现正常的情况下，我们可以进行扩容操作
        if (size() == this.heap.length) {
            throw new IndexOutOfBoundsException();
        }

        this.heap[size - 1] = val;
        heapfiy(size - 1);
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
    private void heapfiy(int i) {
        while (true) {
            int p = parent(i);
            if (p < 0)
                return;
            if (heap[i] > heap[p]) {
                swap(i, p);
                i = p;
            } else {
                break;
            }

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
        heap[size() - 1] = null;

        size--;
        sink(0);

        // 交换完了之后，需要再下潜重新将堆进行排序

        return rtnValue;
    }

    public Integer peek() {
        return heap[0];
    }

    private void sink(int i) {

        // i = (size - 3) / 2
        while (i <= (this.size - 3) / 2) {
            int left = left(i);
            int right = right(i);

            if (heap[left] == null && heap[right] == null) {
                break;
            } else {
                if (heap[left] != null && heap[right] != null && heap[i] >= heap[left] && heap[i] >= heap[right]) {
                    break;
                } else {
                    if (heap[left] != null) {
                        if (heap[left] > heap[i]) {
                            swap(i, left);
                            i = left;
                        }
                    } else if (heap[right] != null) {
                        if (heap[right] > heap[i]) {
                            swap(i, right);
                            i = right;
                        }
                    }
                }
            }

        }

    }

    public static void main(String[] args) {

    }
}
