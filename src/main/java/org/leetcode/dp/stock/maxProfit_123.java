package org.leetcode.dp.stock;

public class maxProfit_123 {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days][5];
        /**
         * 0: 不操作
         * 1: 第一次持股
         * 2: 第一次不持股
         * 3: 第二次持股
         * 4: 第二次不持股
         * dp[i][0] = 0;
         * dp[i][1] = 0;
         * dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
         * dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
         * dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] - prices[i]);
         */
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < days; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[days - 1][4];
    }
}
