package org.leetcode.dp;

/**
 * 零钱兑换2
 * 组合问题，先物品再背包
 */
public class Change_518 {
    public int change(int amount, int[] coins) {
        // 1. dp数组的含义是什么? dp[i] 为在考虑当前物品之后凑出 i 有 dp[i] 种方法
        // 2. 递推公式，dp[i] += dp[i - coins[j]];
        // 3. 初始化，dp[0] = 1; 可以这样看，dp[1] += dp[1 - 1];
        // 4. 遍历顺序，从小到大，先物品后背包
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
