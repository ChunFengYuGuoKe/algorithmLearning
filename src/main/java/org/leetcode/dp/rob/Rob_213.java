package org.leetcode.dp.rob;

public class Rob_213 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        // 考虑第一家，不考虑最后一家
        dp[0] = nums[0];
        if (nums.length < 2) return nums[0];
        if (nums.length < 3) return Math.max(nums[0], nums[1]);
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int money1 = dp[nums.length - 2];

        // 考虑最后一家，不考虑第一家
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int money2 = dp[nums.length - 1];
        return Math.max(money1, money2);
    }
}
