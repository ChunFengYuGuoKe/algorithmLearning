package org.leetcode.dp.stock;

public class MaxProfit_121 {
    public static void main(String[] args) {
        MaxProfit_121 maxProfit121 = new MaxProfit_121();
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit121.maxProfit(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days][2];
        /**
         * dp含义，dp[i][0]代表第i天不持股的最大利润，dp[i][1]代表第i天持股的最大利润
         * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]
         * dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]
         */
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 遍历
        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[days - 1][0];
    }
}
