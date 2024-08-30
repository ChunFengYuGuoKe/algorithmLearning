package org.leetcode.binary_search;

import com.minmin.algorithmspass.tools.TreeNode;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class GetMinimumDifference {
    static int min = Integer.MAX_VALUE;
    static int pre = -1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println(getMinimumDifference(root));
    }
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        // if (root.left == null && root.right == null) {
        //     return min;
        // }
        dfs(root);
        return min;
    }

    // 这道题不能直接用递归的方式向上传递值
    // 这是为什么呢，因为处理的是一个全局变量吗
    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        // 这里的逻辑很有意思
        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
