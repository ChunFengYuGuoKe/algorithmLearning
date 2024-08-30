package org.leetcode.dp;

public class CanPartition_416 {

    /**
     * 使用二维状态数组
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        // 初始化
        for (int j = 0; j <= target; j++) {
            if (j >= nums[0]) dp[0][j] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j > nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target] == target;
    }

    /**
     * 使用一维状态数组
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        // 初始化
        for (int j = 0; j <= target; j++) {
            if (j >= nums[0]) dp[j] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= 1; j--) {
                if (j > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[target] == target;
    }
}
