## BFS和DFS的应用场景

在实际的算法问题中，DFS算法常用穷举所有路径，BFS算法常用来寻找最短路径，这是什么原因呢？

### 为什么BFS常用来寻找最短路径

[leetcode的第111题](https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/)


> 给定一个二叉树，找出其最小深度。


这个题有两种解法，第一种解法是使用*DFS*深度遍历的方式得到所有数据，不过这种情况需要将所有的树节点都要遍历一遍之后才可以得到最短路径。

**解法一** 

```java
private void dsf(TreeNode root) {
    if (root == null) {
        return;
    }

    // 说明已经遍历到叶子节点了
    if (root.left == null && root.right == null) {
        resultMinDepth = Math.min(resultMinDepth, depth);
        return;
    }

    depth++;
    dsf(root.left);
    dsf(root.right);

    depth--;
}

```


**解法二** 
```java
/**
 * 使用BSF的方式去拿到某个树的是最短路径
 */
private int bsf(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int depth = 1, rtnDepth = Integer.MAX_VALUE;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                rtnDepth = Math.min(rtnDepth, depth);
                continue;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        depth++;
    }

    return rtnDepth;

}
```

我们可以看到，使用BSF的方式去算最短路径是比较好的。因为是按照层级去遍历的，当遇到第一个全部叶子节点的时候，就是最短路径。

从时间复杂度的角度来看，两种算法在最坏情况下都会遍历所有节点，时间复杂度都是$O(N)$，但在一般情况下，显然BFS算法实际效率会更高，所以在寻找最短路径的问题中，BSF算法才是首选。

### 为什么DFS常用来寻找所有路径

在寻找所有路径的问题中，实际上DFS算法用的比较多，BFS算法似乎用的不太多。

理论上两种遍历算法都是可以的，只不过BFS算法寻找所有路径的代码比较复杂，DFS算法代码比较简洁。

以二叉树为例，如果要用BFS算法来寻找所有路径（根节点到每个叶子节点都是一条路径），队列里面就不能只放节点了，而需要使用新建一个`State` 类，把当前节点以及到达当前节点的路径都存进去，这样才能正确维护每个节点的路径，最终计算出所有路径。

而使用DFS算法就简单了，它本就是一条树枝一条树枝从左往右遍历的，每条树枝就是一条路径，递归遍历到叶子节点的时候递归路径就是一条树枝，所以DFS算法天然适合寻找所有路径。


