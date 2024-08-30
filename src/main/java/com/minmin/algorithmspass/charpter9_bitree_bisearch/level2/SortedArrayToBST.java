package com.minmin.algorithmspass.charpter9_bitree_bisearch.level2;


import com.minmin.algorithmspass.tools.TreeNode;
import com.sun.source.tree.Tree;

/**
 * LeetCode108
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，
 * 请你将其转换为一棵 高度平衡 二叉搜索树。
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode node=sortedArrayToBST(nums);
        System.out.println(node.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfsByMyself(nums, 0, nums.length - 1);
    }

    /*
     * 通过前序遍历将有序数组中的值插入到搜索树中
     */
    private static TreeNode dfsByMyself(int[] nums, int left, int right) {
        // 如果在当前的问题规模下，left<right，则到达终止条件
        // 不再继续递归，饭后null
        if (left > right) {
            return null;
        }
        // 取mid为数组下标中间的左边一个元素
        int mid = left + ((right - left) >> 1);
        // 由当前数组的中间元素构造一个节点
        TreeNode root = new TreeNode(nums[mid]);
        // 递归地构造左右子树
        root.left = dfsByMyself(nums, left, mid - 1);
        root.right = dfsByMyself(nums, mid + 1, right);
        // 在当前节点和左右子树都构造好之后，返回当前节点
        return root;
    }

    private static TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        // 以升序数组的中间元素作为根节点 root。
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归的构建 root 的左子树与右子树。
        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);
        return root;
    }
}
