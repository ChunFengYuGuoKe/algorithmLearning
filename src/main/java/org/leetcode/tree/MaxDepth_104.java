package org.leetcode.tree;

import com.minmin.algorithmspass.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node != null && node.left != null) {
                    queue.add(node.left);
                }
                if (node != null && node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }
}
