package hash;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 数组增强哈希表
 */
public class EnhanceArrayHashMap<K, V> {
    static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    // 表中维护的只是key对应的数组下标值
    private HashMap<K, Integer> map;
    // 存储Node节点
    private ArrayList<Node<K, V>> arr;

    public EnhanceArrayHashMap() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }

    /**
     * 向表中添加一组键值对
     *
     * @param key   键
     * @param value 值
     */
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (map.containsKey(key)) {
            int index = map.get(key);
            Node<K, V> node = arr.get(index);
            node.value = value;
            return;
        }
        Node<K, V> node = new Node<>();
        node.key = key;
        node.value = value;
        arr.add(node);
        map.put(key, arr.size() - 1);
    }

    /**
     * 删除一个元素
     *
     * @param key 需要删除的键
     */
    public void remove(K key) {
        if (key == null) {
            return;
        }

        if (!map.containsKey(key)) {
            return;
        }

        int index = map.get(key);
        // 若是最后一位直接remove掉就可以了
        if (index == arr.size() - 1) {
            arr.remove(index);
            map.remove(key);

            return;
        }

        Node<K, V> last = arr.get(arr.size() - 1);
        arr.set(index, last);
        // 最后一位移到需要删除的那个元素上面，这里还需要更新map中的对应的索引值
        map.put(last.key, index);

        arr.remove(arr.size() - 1);
        map.remove(key);
    }

    /**
     * 根据key获得其对应的value
     *
     * @param key 键
     * @return 值
     */
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (!map.containsKey(key)) {
            return null;
        }

        int index = map.get(key);
        Node<K, V> node = arr.get(index);
        return node.value;
    }

    /**
     * 这个方法是整个这个类所做的重点的事情，就是为了能够均匀随机取得某一个key
     */
    public K randomKey() {
        if (map.isEmpty()) {
            return null;
        }

        Random random = new Random();

        // 从数组中随机取得一个key返回回去
        int index = random.nextInt(arr.size());
        return arr.get(index).key;
    }

    /**
     * 获得所有的值以列表的形式返回
     *
     * @return 表中的所有值
     */
    public List<V> values() {
        if (map.isEmpty()) {
            return Collections.emptyList();
        }

        List<V> values = new ArrayList<>();

        for (Node<K, V> node : arr) {
            values.add(node.value);
        }

        return values;
    }

    /**
     * 获得现在表中的所有key列表
     *
     * @return 表中的所有key以列表形式返回
     */
    public List<K> keys() {
        if (map.isEmpty()) {
            return Collections.emptyList();
        }

        List<K> keyList = new ArrayList<>();

        for (Node<K, V> node : arr) {
            keyList.add(node.key);
        }

        return keyList;
    }

    public static void main(String[] args) {
        EnhanceArrayHashMap<Integer, Integer> map = new EnhanceArrayHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);

        System.out.println(map.get(1)); // 1
        System.out.println(map.randomKey());

        map.remove(4);
        System.out.println(map.randomKey());
        System.out.println(map.randomKey());
    }
}
