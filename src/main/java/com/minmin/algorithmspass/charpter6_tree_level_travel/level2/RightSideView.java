package com.minmin.algorithmspass.charpter6_tree_level_travel.level2;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  LeetCode 199题目要求:
 *  给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，
 *  返回从右侧所能看到的节点值。
 */
public class RightSideView {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<Integer> level = rightSideViewByMyself(bTree.root);
        System.out.println(level.toString());
    }

    public static List<Integer> rightSideViewByMyself(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int rightValue = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
                if (i == size - 1) rightValue = cur.getVal();
            }
            res.add(rightValue);
        }
        return res;
    }






    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}

