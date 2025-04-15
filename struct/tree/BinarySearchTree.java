package tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    // 数据
    private int val;
    // 左侧节点指针
    private BinarySearchTree left;
    // 右铡节点指针
    private BinarySearchTree right;

    /*-----------------------------构造方法---------------------------*/
    public BinarySearchTree(int val) {
        this.val = val;
        left = right = null;
    }

    public BinarySearchTree() {
        left = right = null;
    }

    public BinarySearchTree(int val, BinarySearchTree left, BinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 以列表的第一个元素当作其根节点
     *
     * @param datas 需要构建BST的数据列表
     * @return 当这个树构建完成之后，返回这个树的根节点对象
     */
    public static BinarySearchTree constructBST(List<Integer> datas) {
        if (datas == null || datas.size() == 0) {
            return null;
        }

        // 把列表的第一个元素当作BST的根节点
        BinarySearchTree root = new BinarySearchTree(datas.get(0));

        for (int i = 1; i < datas.size(); i++) {
            int insertData = datas.get(i);
            // 每次都从根节点进行查找的工作
            BinarySearchTree temp = root;
            while (temp != null) {
                // 当前的节点数据与插入的数据相同的，则不会再插入了
                if (temp.val == insertData) {
                    break;
                }
                BinarySearchTree left = temp.left;
                BinarySearchTree right = temp.right;
                // 插入的数据是比现在这个节点小，则应该是左节点
                if (temp.val > insertData) {
                    if (left == null) {
                        BinarySearchTree insertNode = new BinarySearchTree(insertData);
                        temp.left = insertNode;
                        break;
                    } else {
                        temp = left;
                        continue;
                    }
                }

                // 插入的数据是比当前的节点数据大，则应该是右节点
                if (temp.val < insertData) {
                    if (right == null) {
                        BinarySearchTree insertNode = new BinarySearchTree(insertData);
                        temp.right = insertNode;
                        break;
                    } else {
                        temp = right;
                    }
                }
            }
        }

        return root;
    }

    /**
     * 向一个二叉搜索树中插入一个节点
     *
     * @param root    二叉搜索树的根节点
     * @param element 需要插入的元素
     */
    @SuppressWarnings("unchecked")
    public static void insert(BinarySearchTree root, int element) {

        BinarySearchTree pre, cur;
        cur = root;
        pre = null;
        while (cur != null) {
            if (cur.val == element) {
                return;
            }

            pre = cur;
            if (cur.val < element) {
                // 当前的节点值比插入值大则向右进行搜索
                cur = cur.right;
            } else {
                // 当前的节点值比插入值小则向右进行搜索
                cur = cur.left;
            }

        }

        // 向左或右插入节点
        BinarySearchTree node = new BinarySearchTree(element);
        if (pre.val < element) {
            pre.right = node;
        } else {
            pre.left = node;
        }

    }

    /**
     * 删除二叉搜索树中的某个节点
     *
     * @param root 二叉搜索树
     * @param cur  某个元素
     */
    public static void remove(BinarySearchTree root, int removeElement) {
        BinarySearchTree pre, cur;

        cur = pre = root;

        // 去查找数据
        while (cur != null && cur.val != removeElement) {
            // 查找到需要删除的元素搜索
            if (cur.val == removeElement) {
                break;
            }
            pre = cur;

            if (removeElement < cur.val) {
                cur = cur.left;
                continue;
            }

            if (removeElement > cur.val) {
                cur = cur.right;
            }
        }

        // 现在开始分情况去处理
        if (cur == null) {
            // 树里面并没有这个元素
            return;
        }

        BinarySearchTree replaceNode = null;
        // 需要删除的这个节点度是0，即这个元素既没有左侧节点以及右侧的节点
        if (cur.left == null && cur.right == null) {
            // 左侧
            replaceNode = null;
        } else if (cur.left != null && cur.right != null) {
            // 需要删除的元素度为2时
            // 上节点pre也需要更新，当度为2时还需要按照中序遍历的形式去查找“右侧”subtree中的最小值

        } else {
            // 度为1时的处理方式
            if (cur.left != null) {
                replaceNode = cur.left;
            } else {
                replaceNode = cur.right;
            }
        }
        // 更新上节点
        if (pre.left == cur) {
            pre.left = replaceNode;
        } else {
            pre.right = replaceNode;
        }
    }

    /**
     * 搜索某个元素值
     *
     * @param root 二叉搜索树的根节点
     * @param cur  搜索某个值
     * @return 是否有这个元素，如果有的话则返回true，没有则返回false
     */
    public static BinarySearchTree search(BinarySearchTree root, int searchData) {
        BinarySearchTree cur = root;

        while (cur != null) {
            if (cur.val == searchData) {
                return cur;
            }

            if (cur.val > searchData) {
                cur = cur.left;
                continue;
            }

            cur = cur.right;
        }

        return cur;
    }

    /**
     * 中序遍历
     *
     * 对于BST来讲，使用中序遍历完成之后得到的这个结果就是有序的结果列表了
     * 相当于是进行了一次排序操作
     *
     * @param root  需要遍历的根节点
     * @param lists 中序遍历完成后的结果列表
     */
    public static void inOrder(BinarySearchTree root, List<BinarySearchTree> lists) {
        if (root == null) {
            return;
        }

        inOrder(root.left, lists);
        lists.add(root);
        inOrder(root.right, lists);
    }

    /**
     * 测试方法
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(8);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(15);
        list.add(10);
        list.add(26);

        BinarySearchTree root = constructBST(list);
        List<BinarySearchTree> inOrderResultList = new ArrayList<>();
        inOrder(root, inOrderResultList);

        for (BinarySearchTree i : inOrderResultList) {
            System.out.print(i.val + " ");
        }
        System.out.println();

        insert(root, 13);
        inOrderResultList = new ArrayList<>();
        inOrder(root, inOrderResultList);
        for (BinarySearchTree i : inOrderResultList) {
            System.out.print(i.val + " ");
        }
        System.out.println();

        BinarySearchTree searchNode = search(root, 2);
        System.out.println(searchNode);
    }
}
