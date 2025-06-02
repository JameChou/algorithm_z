package struct.tree;

import java.util.List;

/**
 * BST树
 */
public class BinarySearchTree {

    static class Node {
        Integer value;
        Node left;
        Node right;

        public Node(Integer value) {
            this.value = value;
        }

        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node() {
        }
    }

    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    /**
     * 插入切点
     *
     * @param value 需要插入值
     */
    public void insert(int value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }

        Node cur = this.root, pre = null;

        // 这里对现在的这个树进行查找工作
        while (cur != null) {
            if (cur.value == value) {
                return;
            }

            pre = cur;
            if (cur.value < value) {
                cur = cur.left;
            } else if (cur.value > value) {
                cur = cur.right;
            }
        }

        // 能跳出相应的循环表明现在已经找到了节点高度为0的目标位置
        // 下面就是判断应该将新的节点插入到左节点上还是右节点上
        if (pre.value < value) {
            pre.right = new Node(value);
        } else {
            pre.left = new Node(value);
        }
    }

    public void remove(int value) {
        if (root == null) {
            return;
        }

        Node cur = this.root, pre = null;

        while (cur != null) {
            if (cur.value == value) {
                break;
            }

            pre = cur;
            if (cur.value < value) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        // 说明没有找到需要删除的节点
        if (cur == null) {
            return;
        }
        if (cur.left == null || cur.right == null) {
            // 说明现在需要删除的这个节点有0个或1节点
            Node child = cur.left != null ? cur.left : cur.right;
            if (cur != root) {
                // 判断cur在上一层节点的左子树还是右子树上然后再进行一次更新
                if (pre.left == cur) {
                    pre.left = child;
                } else {
                    pre.right = child;
                }
            } else {
                // 如果现在删除的节点是根节则需要替换根节点为子节点
                root = child;
            }
        } else {
            // 这里是找到当前节点的右子树中最小的值然后替换这个节点
            Node temp = cur.right;
            // 逻辑相当于找到右子树，然后使用中序遍历的方式找到第一个值（即最小值的结点）
            while (temp.left != null) {
                temp = temp.left;
            }

            // 这里再递归找到需要替换cur值的这个节点，把它给删除掉
            remove(temp.value);
            // 更新cur的值为右子树中最左的值
            cur.value = temp.value;
        }
    }

    /**
     * 判断数据是否存在，本质上也是一种查找的过程
     */
    public boolean exist(Integer value) {
        if (value == null) {
            return false;
        }

        Node cur = root;
        while (cur != null) {
            if (cur.value == value) {
                return true;
            }

            if (cur.value < value) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        return false;
    }

    /**
     * mid-order sequence
     *
     * @param node   起始的根节点数据
     * @param values 按照mid-order顺序得到的列表
     */
    public void inOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inOrder(node.left, values);
        values.add(node.value);
        inOrder(node.right, values);
    }

    public void preOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        values.add(node.value);
        preOrder(node.left, values);
        preOrder(node.right, values);
    }

    public void lastOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        lastOrder(node.left, values);
        lastOrder(node.right, values);
        values.add(node.value);
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {

    }
}
