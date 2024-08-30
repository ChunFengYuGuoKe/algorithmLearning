package com.minmin.algorithmspass.charpter8_tree_hot_problems.level2;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode104 最大深度和最小深度问题
 */
public class MinDepth {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTreeComplex();
        int testMethod = 2;
        int result = 0;
        switch (testMethod) {
            case 1://通过递归计算二叉树的深度
                result = minDepth_1(bTree.root);
                break;
            case 2://通过层次遍历计算二叉树的深度
                result = minDepth_2(bTree.root);
                break;
        }
        System.out.println(result);
    }

    /**
     * 通过递归计算二叉树的最小
     *
     * @param root
     * @return
     */
    public static int minDepth_1ByMyself(TreeNode root) {
        // 终止条件，如果节点为空，深度为零，因为它下面不可能再有叶节点了
        if (root == null) return 0;
        // 终止条件，如果节点为叶节点，深度为1，因为它自己本身就是叶节点
        if (root.left == null && root.right == null) return 1;

        // 先将最小深度设置为最大的整型数，确保之后能通过比较更新它
        int minDepth = Integer.MAX_VALUE;
        // 如果左子节点不为空，则从这里开始寻找叶子节点，算深度
        if (root.left != null) {
            minDepth = Math.min(minDepth_1ByMyself(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth_1ByMyself(root.right), minDepth);
        }
        // 最后返回minDepth + 1，原因是因为根节点到子节点还有一条边，要算上
        return minDepth + 1;
    }


    public static int minDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth_1(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth_1(root.right), min_depth);
        }
        return min_depth + 1;
    }

    /**
     * 通过层次遍历来求最大深度
     *
     * @return
     */
    public static int minDepth_2ByMyself(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return minDepth;
    }





    public static int minDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 0;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            minDepth++;
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                if (t.left == null && t.right == null) {
                    return minDepth;
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
        return 0;
    }

}
