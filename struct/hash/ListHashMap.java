package hash;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 拉链法实现一个哈希表
 */
public class ListHashMap<K, V> {
    static class KVNode<K, V> {
        private K key;
        private V value;

        public KVNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public KVNode() {
        }
    }

    // 默认表的大小
    private static final int DEFAULT_CAPACITY = 50;
    // 当前表中的数据
    private int size;
    // 表对象用于后面对数据进行存储
    private LinkedList<KVNode<K, V>> table[];
    // 最大因子，用于进行扩容时的操作
    private static final double BOND_FACTOR = 0.75;
    // 扩大或缩小的倍数
    private static final int EXPAND_RATE = 2;

    @SuppressWarnings("unchecked")
    public ListHashMap() {
        table = (LinkedList<KVNode<K, V>>[]) new LinkedList[DEFAULT_CAPACITY];
        this.size = 0;

        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<KVNode<K, V>>();
        }
    }

    @SuppressWarnings("unchecked")
    public ListHashMap(int capacity) {
        table = (LinkedList<KVNode<K, V>>[]) new LinkedList[capacity];
        this.size = 0;

        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<KVNode<K, V>>();
        }
    }

    /**
     * 计算一个键值的hash值，这个哈希值与我们的表的长度有关，以及自身去调用hashCode方法有关。
     *
     * @return 这个key的哈希值
     */
    public int hashKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        int hash = key.hashCode() % table.length;
        return hash;
    }

    /**
     * 向表中添加放置一个元素，键值对的形式传入进来，key-value
     *
     * @param key   键值
     * @param value 值
     */
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        int hash = hashKey(key);
        KVNode<K, V> node = new KVNode<>();
        node.key = key;
        node.value = value;

        LinkedList<KVNode<K, V>> values = table[hash];
        for (KVNode<K, V> n : values) {
            // 如果这里已经有值的话，则去更新value值，然后直接return
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }

        // 上面的for循环已经return的话，就表明之前有这个key所以表里面并没有直接增加元素数量，所以不需要再去判断是否是需要扩容
        values.addLast(node);
        size++;

        if (((double) size / table.length) >= BOND_FACTOR) {
            // 如果现在的负载因子已经足够大了，那么这时候就需要对表进行扩容，我这里是将表扩容至2倍以上
            resize(table.length * EXPAND_RATE);
        }

    }

    /**
     * 根据key删除其中的某一个节点
     *
     * @param key 需要删除的节点key
     */
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        int hash = hashKey(key);
        LinkedList<KVNode<K, V>> nodes = table[hash];
        if (nodes.isEmpty()) {
            return;
        }

        for (KVNode<K, V> node : nodes) {
            if (node.key.equals(key)) {
                nodes.remove(node);
                break;
            }
        }

        size--;

        // 如果现在的这个表数据已经足够小的话，还是需要再对这个数组进行缩减
        if (size < table.length / 8) {
            resize((int) Math.floor(table.length / 4));
        }
    }

    /**
     * 根据某个key来获得其对应的value
     *
     * @param key 键的值
     * @return 这个key所对应的value
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }

        int hash = hashKey(key);
        LinkedList<KVNode<K, V>> nodes = table[hash];
        if (nodes.isEmpty()) {
            return null;
        }

        for (KVNode<K, V> node : nodes) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    /**
     * 获得现在表中的所有key值，以列表的形式返回回去
     *
     * @return 所有的key值列表
     */
    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (List<KVNode<K, V>> nodes : table) {
            for (KVNode<K, V> node : nodes) {
                keys.add(node.key);
            }
        }

        return keys;
    }

    /**
     * 获得表中的所有值的列表
     *
     * @return 表中的所有值列表-arraylist
     */
    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (List<KVNode<K, V>> nodes : table) {
            for (KVNode<K, V> node : nodes) {
                values.add(node.value);
            }
        }

        return values;
    }

    /**
     * 获得当前表的大小
     */
    public int size() {
        return size;
    }

    /**
     * 重新对表进行扩容操作
     * 
     * @param length 扩容至新的表的大小
     */
    public void resize(int length) {
        // 扩容的大小不正确
        if (length <= 0) {
            throw new IllegalArgumentException();
        }

        // 新的大小
        ListHashMap<K, V> newHashMap = new ListHashMap<K, V>(length);
        for (List<KVNode<K, V>> nodes : table) {
            for (KVNode<K, V> node : nodes) {
                newHashMap.put(node.key, node.value);
            }
        }

        table = newHashMap.table;
        size = newHashMap.size();
    }

    public static void main(String[] args) {
        ListHashMap<Integer, Integer> map = new ListHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(2)); // 2

        map.put(1, 100);
        System.out.println(map.get(1)); // 100

        map.remove(2);
        System.out.println(map.get(2)); // null
        // [1, 3]（顺序可能不同）
        System.out.println(map.keys());

        map.remove(1);
        map.remove(2);
        map.remove(3);
        System.out.println(map.get(1)); // null
    }

}
