package com.minmin.algorithmspass.charpter6_tree_level_travel.level2;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.*;

/**
 * LeetCode 515题目要求：
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class LargestValues {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<Integer> level = largestValues(bTree.root);
        System.out.println(level.toString());
    }

    public static List<Integer> largestValuesByMyself(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            int size = q.size();
            int max = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                if (i == 0) {
                    max = cur.val;
                } else {
                    max = Math.max(max, cur.getVal());
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }


    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        if (root != null) {
            deque.addLast(root);
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            int levelMaxNum = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                levelMaxNum = Math.max(node.val, levelMaxNum);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            res.add(levelMaxNum);
        }
        return res;
    }
}

