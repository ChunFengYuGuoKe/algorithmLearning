package org.leetcode.tree;

import com.minmin.algorithmspass.tools.TreeNode;

public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        // 第一版
        // TreeNode temp = leftNode;
        // leftNode = rightNode;
        // rightNode = temp;

        // 第二版
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
