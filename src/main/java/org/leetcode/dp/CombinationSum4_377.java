package org.leetcode.dp;

public class CombinationSum4_377 {
    public int combinationSum4(int[] nums, int target) {
        // dp[j] 代表装满 j 有dp[j] 种方法
        // dp[j] += dp[j - coins[i]]
        // dp[0] = 1;
        // 先物品再背包，错了，先背包后物品
        int[] dp = new int[target + 1];
        dp[0] = 1;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = nums[i]; j <= target; j++) {
//                dp[j] += dp[j - nums[i]];
//            }
//        }
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
