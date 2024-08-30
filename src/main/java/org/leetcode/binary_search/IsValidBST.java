package org.leetcode.binary_search;

import com.minmin.algorithmspass.tools.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class IsValidBST {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) {
            return false;
        }
        // 这里很有意思，这里的pre是从前面的isValidBST(root.left)更新的，是当前节点的上一个左节点
        if (root.val <= pre) {
            return false;
        }
        // 在即将判断右节点时，再用root.val更新pre
        pre = root.val;
        return isValidBST(root.right);
    }
}
