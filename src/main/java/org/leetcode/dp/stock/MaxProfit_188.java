package org.leetcode.dp.stock;

public class MaxProfit_188 {
    public static void main(String[] args) {
        MaxProfit_188 maxProfit188 = new MaxProfit_188();
        int[] prices = {2,4,1};
        System.out.println(maxProfit188.maxProfit(2, prices));
    }

    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days][2 * k + 1];
        for (int i = 0; i < 2 * k; i++) {
            if (i % 2 == 1) {
                dp[0][i] = -prices[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < days; i++) {
            dp[i][0] = 0;
            for (int j = 1; j < 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }
        return dp[days - 1][2 * k];
    }
}
