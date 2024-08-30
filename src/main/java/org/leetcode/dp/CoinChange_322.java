package org.leetcode.dp;

import java.util.Arrays;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        // dp[j] 装满 j 最少用 dp[j] 个硬币
        // dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j])
        // 初始化，dp[0] = 1; 其余为 -1——这里错了，没搞清楚数组含义，dp[0] 只用 0 个硬币，所以应该是0
        // 遍历顺序，既非组合也非排列，随意
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
//                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
