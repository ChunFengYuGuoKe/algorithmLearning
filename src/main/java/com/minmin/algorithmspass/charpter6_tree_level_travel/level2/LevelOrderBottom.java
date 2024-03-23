package com.minmin.algorithmspass.charpter6_tree_level_travel.level2;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 107.
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）。
 */
public class LevelOrderBottom {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<List<Integer>> level = levelOrderBottom(bTree.root);
        System.out.println(level.toString());
    }
    public static List<List<Integer>> levelOrderBottomByMyself(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // offer也是加到队列里，但他不对队列的长度限制进行检查
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // remove与poll的区别是remove在队列为空时会抛出异常
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 每次新的下面的一层都添加到上面相当于一个栈
            // 这样就做到了从树的底层往上层次遍历，还是要灵活运用数据结构的特点啊
            // 获得了一个通用的思路——如果我想让后遍历的元素先输出，就可以用栈
            // LinkedList既是list的一种实现，同时也实现了Queue接口
            // add接口可以用通过指定新元素插入位置为0，实现栈
            levelOrder.add(0, level);
        }
        return levelOrder;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0, level);//栈
        }
        return levelOrder;
    }
}

