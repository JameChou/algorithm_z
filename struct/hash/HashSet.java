package hash;

import java.util.HashMap;

public class HashSet<K> {
    private static final Object INSTANCE_OBJECT = new Object();

    private HashMap<K, Object> map;

    public HashSet() {
        map = new HashMap<>();
    }

    // 增，向哈希集合中添加一个元素，复杂度 O(1)
    // 如果元素已存在，则什么都不会发生
    public void add(K key) {
        map.put(key, INSTANCE_OBJECT);
    }

    // 删，从哈希集合中移除一个元素，复杂度 O(1)
    // 如果元素不存在，则什么都不会发生
    public void remove(K key) {
        map.remove(key);
    }

    // 查，判断元素是否存在，复杂度 O(1)
    public boolean contains(K key) {
        return map.containsKey(key);
    }

    // 获得这个集合的大小
    public int size() {
        return map.size();
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= 5; i++) {
            set.add(i);
        }

        set.add(2);
        set.add(4);

        System.out.println(set.contains(2));
        System.out.println(set.size());
        set.remove(2);
        System.out.println(set.contains(2));
        System.out.println(set.size());
    }

}
