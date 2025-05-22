package struct.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用数组来实现一个哈希表
 *
 * @link https://www.hello-algo.com/chapter_hashing/hash_map/#611
 */
public class ArrayHashMap {
    class Pair {
        public int key;
        public String val;

        public Pair(int key, String val) {
            this.key = key;
            this.val = val;
        }
    }

    private List<Pair> buckets;

    public ArrayHashMap() {
        buckets = new ArrayList<>(100);
        // 初始化将内部的列表中添加null对象
        for (int i = 0; i < 100; i++) {
            buckets.add(null);
        }
    }

    private int hashFunc(int key) {
        int index = key % 100;
        return index;
    }

    public void put(int key, String val) {
        int index = hashFunc(key);
        Pair pair = new Pair(key, val);

        buckets.set(index, pair);
    }

    public String get(int key) {
        int index = hashFunc(key);
        Pair pair = buckets.get(index);
        return pair == null ? null : pair.val;
    }

    public static void main(String[] args) {
        ArrayHashMap map = new ArrayHashMap();
        map.put(13345, "哈哈");
        map.put(22346, "冉冉");

        System.out.println(map.get(13345));
        System.out.println(map.get(334));
        System.out.println(map.get(22346));
    }

}
