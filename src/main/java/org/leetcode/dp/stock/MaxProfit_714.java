package org.leetcode.dp.stock;

public class MaxProfit_714 {
    public int maxProfit(int[] prices, int fee) {
        int days = prices.length;
        int[][] dp = new int[days][2];
        /**
         * 0: 持股
         * 1: 不持股
         */
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i -1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }
        return dp[days -  1][1];
    }
}
