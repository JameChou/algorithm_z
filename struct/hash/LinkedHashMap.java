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
        head = null;
        tail = null;
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

        Node<K, V> node = new Node<>(key, value);
        if (head == null) {
            head = node;
            map.put(key, node);
            return;
        }

        if (tail == null) {
            head.next = node;
            node.prev = head;
            tail = node;
            map.put(key, node);
            return;
        }

        node.prev = tail;
        tail.next = node;
        tail = node;
        map.put(key, node);
    }

    private Node<K, V> getNode(K key) {
        return map.get(key);
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

        Node<K, V> node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException();
        }

        map.remove(key);
        // 如果删除的这个节点是记录的头节点
        if (node == head) {
            head = node.next;
            if (node.next != null) {
                node.next.prev = null;
                node.next = null;
            }

            return;
        }

        if (node == tail) {
            tail = node.prev;
            if (node.prev != null) {
                node.prev.next = null;
                node.prev = null;
            }

            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
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

        Node<K, V> temp = head;
        // 对现在这个链表进行遍历按顺序拿到所有的节点
        while (temp == null) {
            values.add(temp.value);
            temp = temp.next;
        }

        return values;
    }

    public List<K> keys() {
        if (map.isEmpty()) {
            return Collections.emptyList();
        }

        List<K> keyList = new ArrayList<>();

        Node<K, V> temp = head;
        // 对现在这个链表进行遍历按顺序拿到所有的节点
        while (temp != null) {
            keyList.add(temp.key);
            temp = temp.next;
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
