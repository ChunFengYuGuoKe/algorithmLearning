package org.leetcode.dp.rob;

import com.minmin.algorithmspass.tools.TreeNode;

public class Rob337 {
    public int rob(TreeNode root) {
        int[] choose = dfs(root);
        return Math.max(choose[0], choose[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) return dp;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }
}
