package org.leetcode.greedy_algorithm;

import com.minmin.algorithmspass.tools.TreeNode;

public class MinCameraCover_968 {
    int result = 0;

    /**
     * 0: 无覆盖
     * 1: 有摄像头
     * 2: 有覆盖
     */
    public int minCameraCover(TreeNode root) {
        int status = dfs(root);
        if (status == 0) {
            result++;
        }
        return result;
    }
    // 00 01 02 10 11 12 20 21 22
    private int dfs(TreeNode node) {
        if (node == null) return 2;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right == 0) {
            result++;
            return 1;
        } else {
            return 2;
        }
//        if (left == 1 || right == 1) {
//            return 2;
//        }
    }
}
