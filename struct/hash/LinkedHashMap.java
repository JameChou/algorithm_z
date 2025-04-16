package hash;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkedHashMap<K, V> {
    /**
     * 双向链表节点
     */
    static class Node<K, V> {
        private K key;
        private V value;

        private Node<K, V> prev;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }

        public Node(K key, V value, Node<K, V> prev, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public Node() {
        }

    }

    // 使用HashMap来实现有序的Map
    private HashMap<K, Node<K, V>> map;
    // 表的头节点
    private Node<K, V> head;
    // 表的尾节点
    private Node<K, V> tail;

    public LinkedHashMap() {
        map = new HashMap<>();
        head = new Node<K, V>(null, null);
        tail = new Node<K, V>(null, null);

        head.next = tail;
        tail.prev = head;
    }

    /**
     * 向表中插入一对键值对
     *
     * @param key   键
     * @param value 值
     */
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        // 现在表中已经有这个节点了，只需要去更新一下这个节点的value值
        if (map.containsKey(key)) {

            Node<K, V> node = map.get(key);
            node.value = value;

            return;
        }

        Node<K, V> node = new Node<>(key, value);
        // 把节点也要添加到linkedlist中去
        add2list(node);
        // 把节点放至到表中
        map.put(key, node);
    }

    /**
     * 将节点加入到整个链表的尾部
     *
     * @param node 需要添加的节点
     */
    private void add2list(Node<K, V> node) {

        node.next = tail;
        node.prev = tail.prev;

        tail.prev.next = node;
        tail.prev = node;
    }

    /**
     * 将某个节点从链表中删除
     *
     * @param node 需要移除的节点
     */
    private void removeFromList(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    /**
     * 删除某个节点
     *
     * @param key 键
     */
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (!map.containsKey(key)) {
            return;
        }

        Node<K, V> node = map.get(key);

        // 从表以及链中删除
        removeFromList(node);
        map.remove(key);

    }

    /**
     * 根据某个key获得某个节点，返回这个节点把对应的value
     *
     * @param key 键
     * @return 返回这个节点所对应的值
     */
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        Node<K, V> node = map.get(key);
        return node.value;
    }

    /**
     * 获得表中的所有的数据但是按照顺序来的
     */
    public List<V> values() {
        if (map.isEmpty()) {
            return Collections.emptyList();
        }

        List<V> values = new ArrayList<>();

        for (Node<K, V> node = head.next; node != tail; node = node.next) {
            values.add(node.value);
        }

        return values;
    }

    public List<K> keys() {
        if (map.isEmpty()) {
            return Collections.emptyList();
        }

        List<K> keyList = new ArrayList<>();

        for (Node<K, V> node = head.next; node != tail; node = node.next) {
            keyList.add(node.key);
        }

        return keyList;

    }

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

        System.out.println(map.keys()); // [a, b, c, d, e]
        map.remove("c");
        System.out.println(map.keys()); // [a, b, d, e]
    }

}
