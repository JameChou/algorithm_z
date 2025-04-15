package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeArray {
    private List<Integer> trees;

    public BinaryTreeArray(List<Integer> arrs) {
        this.trees = new ArrayList<>(arrs);
    }

    /**
     * 获得树的大小
     *
     * @return 数组的长度，树的大小
     */
    public int size() {
        return trees.size();
    }

    /**
     * 获取数组中的某个值
     *
     * @param i 数组的下标
     * @return 数组的树某个节点值
     */
    public Integer val(int i) {
        if (i < 0 || i >= size()) {
            return null;
        }

        return trees.get(i);
    }

    /**
     * 广度优先遍历
     *
     * @return 广度优先遍历
     */
    public List<Integer> levelOrder() {
        List<Integer> lists = new ArrayList<>();

        for (int i = 0; i < size(); i++) {
            Integer value = val(i);
            if (value == null) {
                continue;
            }

            lists.add(value);
        }

        return lists;
    }

    /**
     * 计算一个索引下的根节点，其左节点索引
     *
     * @param index 需要计算其左节点索引
     */
    public Integer left(Integer index) {
        if (index == null) {
            return null;
        }

        // 根据 2i + 1 存储的规则
        Integer leftIndex = 2 * index + 1;
        return leftIndex;
    }

    /**
     * 计算一个索引下的根节点，其右节点索引
     *
     * @param index 需要计算其右节点索引
     */
    public Integer right(Integer index) {
        if (index == null) {
            return null;
        }

        // 根据 2i + 2 存储的规则
        Integer rightIndex = 2 * index + 2;

        return rightIndex;
    }

    /**
     * 计算一个节点的父节点索引
     *
     * @param index 需要计算的这个节点父节点索引
     */
    public Integer parent(Integer index) {
        if (index == null) {
            return null;
        }

        Integer parentIndex = (index - 1) / 2;

        return parentIndex;
    }

    /**
     * 深度搜索dfs
     *
     * @param index 需要从哪个节点开始进行遍历
     * @param order 深度检索的方式，总共有三种, pre,in,post
     * @param vals  根据不同的遍历方式，得到最终的列表
     */
    private void dfs(Integer index, String order, List<Integer> vals) {
        if (val(index) == null) {
            return;
        }

        if (order == "pre") {
            vals.add(val(index));
        }
        dfs(left(index), order, vals);
        if (order == "in") {
            vals.add(val(index));
        }
        dfs(right(index), order, vals);
        if (order == "post") {
            vals.add(val(index));
        }
    }

    /**
     * 前序遍历
     *
     * @return 遍历结果列表
     */
    public List<Integer> preOrder() {
        List<Integer> preOrderList = new ArrayList<>();
        dfs(0, "pre", preOrderList);

        return preOrderList;
    }

    /**
     * 中序遍历
     *
     * @return 遍历结果列表
     */
    public List<Integer> inOrder() {
        List<Integer> inOrderList = new ArrayList<>();
        dfs(0, "in", inOrderList);

        return inOrderList;
    }

    /**
     * 后序遍历
     *
     * @return 遍历结果列表
     */
    public List<Integer> postOrder() {
        List<Integer> postOrderList = new ArrayList<>();
        dfs(0, "post", postOrderList);

        return postOrderList;
    }

    public static void main(String[] args) {
        /* 二叉树的数组表示 */
        // 使用 int 的包装类 Integer ，就可以使用 null 来标记空位
        Integer[] tree = { 1, 2, 3, 4, null, 6, 7, 8, 9, null, null, 12, null, null, 15 };

        List<Integer> treeList = new ArrayList<>();
        for (int i = 0; i < tree.length; i++) {
            treeList.add(tree[i]);
        }

        BinaryTreeArray bta = new BinaryTreeArray(treeList);

        // 层序遍历的方式，广度优先搜索
        List<Integer> levelOrderList = bta.levelOrder();
        for (Integer i : levelOrderList) {
            System.out.print(i + " ");
        }
        System.out.println();

        /* -------------------------深度搜索---------------------------------------- */
        List<Integer> preOrderList = bta.preOrder();
        for (Integer i : preOrderList) {
            System.out.print(i + " ");
        }
        System.out.println();

        List<Integer> inOrderList = bta.inOrder();
        for (Integer i : inOrderList) {
            System.out.print(i + " ");
        }
        System.out.println();

        List<Integer> postOrderList = bta.postOrder();
        for (Integer i : postOrderList) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
