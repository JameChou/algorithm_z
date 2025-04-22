package tree;

import java.util.List;

/**
 * @TODO 完成后续的代码
 */
public class TreeMap<K, V> {
    static class TreeNode<K, V> {
        K key;
        V val;
        TreeNode<K, V> left;
        TreeNode<K, V> right;

        public TreeNode(K key, V val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(K key, V val, TreeNode<K, V> left, TreeNode<K, V> right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }
    }

    private TreeNode<K, V> root;

    // 增/改，复杂度 O(logN)
    public void put(K key, V value) {

    }

    // 查，复杂度 O(logN)
    public V get(K key) {

        return null;
    }

    // 删，复杂度 O(logN)
    public void remove(K key) {
    }

    // 是否包含键 key，复杂度 O(logN)
    public boolean containsKey(K key) {

        return false;
    }

    // 返回所有键的集合，结果有序，复杂度 O(N)
    public List<K> keys() {
        return null;
    }

    // ****** TreeMap 提供的额外方法 ******

    // 查找最小键，复杂度 O(logN)
    public K firstKey() {
        return null;
    }

    // 查找最大键，复杂度 O(logN)
    public K lastKey() {
        return null;
    }

    // 查找小于等于 key 的最大键，复杂度 O(logN)
    public K floorKey(K key) {
        return null;
    }

    // 查找大于等于 key 的最小键，复杂度 O(logN)
    public K ceilingKey(K key) {
        return null;
    }

    // 查找排名为 k 的键，复杂度 O(logN)
    public K selectKey(int k) {
        return null;
    }

    // 查找键 key 的排名，复杂度 O(logN)
    public int rank(K key) {
        return 0;
    }

    // 区间查找，复杂度 O(logN + M)，M 为区间大小
    public List<K> rangeKeys(K low, K high) {
        return null;
    }

    public static void main(String[] args) {

    }
}
