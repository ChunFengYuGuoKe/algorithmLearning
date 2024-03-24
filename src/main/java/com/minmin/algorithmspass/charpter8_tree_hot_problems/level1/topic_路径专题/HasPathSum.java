package com.minmin.algorithmspass.charpter8_tree_hot_problems.level1.topic_路径专题;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 112
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 */
public class HasPathSum {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();

        boolean result1 = hasPathSum(bTree.root, 12);
        System.out.println(result1);

        List<List<Integer>> pathSum = pathSum(bTree.root, 12);
        System.out.println(pathSum);


    }




    /**
     * 问题2：LeetCode112. 路径总和
     *
     * @param root
     * @param sum
     * @return
     */

    // 这道题的逻辑和先前那道找所有路径的题是不一样的，它只需要左右子节点中的一边满足条件即可，应该是一个或的逻辑关系
    // 我考虑的是在遍历到节点为null是怎么处理，那么就采用一种技术使正常情况下节点不会到最后的空叶子节点处即可，也就是两边都是空的那种情况
    public static boolean hasPathSumByMyself(TreeNode root, int sum) {

        if (root == null) return true;
        return hasPathSumByMyself(root.left, sum - root.val)
                && hasPathSumByMyself(root.right, sum - root.val);
    }




    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    /**
     * 问题3  LeetCode113 路径总和II
     */
    static List<List<Integer>> ret = new LinkedList<List<Integer>>();
    static Deque<Integer> path = new LinkedList<Integer>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public static void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }

}
