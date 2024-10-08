package com.minmin.algorithmspass.charpter8_tree_hot_problems.level2;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode104 最大深度和最小深度问题
 */
public class MaxDepth {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        bTree.root = bTree.buildBinaryTreeComplex();
        int testMethod = 3;
        int result = 0;
        switch (testMethod) {
            case 1://通过递归计算二叉树的深度
                result = maxDepth_1(bTree.root);
                break;
            case 2://通过层次遍历计算二叉树的深度
                result = maxDepth_2(bTree.root);
                break;


        }

        System.out.println(result);
    }

    /**
     * 通过递归计算二叉树的深度
     *
     * @param root
     * @return
     */

    public static int maxDepth_1ByMyself(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth_1ByMyself(root.left);
        int rightHeight = maxDepth_1ByMyself(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int maxDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth_1(root.left);
        int rightHeight = maxDepth_1(root.right);
        return Math.max(leftHeight, rightHeight) + 1;

    }

    /**
     * 通过层次遍历来求最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepth_2ByMyself(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            levels++;
        }
        return levels;
    }


    public static int maxDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            //size表示某一层的所有元素数
            int size = queue.size();
            //size=0 表示一层访问完了
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }


}
