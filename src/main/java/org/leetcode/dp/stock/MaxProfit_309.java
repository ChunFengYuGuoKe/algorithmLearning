package org.leetcode.dp.stock;

import java.util.Arrays;

public class MaxProfit_309 {
    public static void main(String[] args) {
        MaxProfit_309 maxProfit309 = new MaxProfit_309();
        int i = maxProfit309.maxProfit(new int[]{1, 2, 4});
    }

    public int maxProfit(int[] prices) {
        /**
         * 0: 不操作
         * 1: 不持股
         * 2: 卖出
         * 3: 冷冻
         * 4: 持股
         */
        int days = prices.length;
        int[][] dp = new int[days][5];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        dp[0][4] = -prices[0];

        /**
         * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
         * dp[i][2] = Math.max(dp[i - 1][4] + prices[i]);
         * dp[i][3] = dp[i - 1][2];
         * dp[i][4] = Math.max(dp[i -1][4], dp[i - 1][3]);
         */

        for (int i = 1; i < days; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][4] + prices[i];
            dp[i][3] = dp[i - 1][2];
            /**
             * 错误写法，错误原因——买股票不付钱
             * dp[i][4] = Math.max(dp[i - 1][4], Math.max(dp[i - 1][3], dp[i - 1][4]));
             */
            dp[i][4] = Math.max(dp[i - 1][1] - prices[i], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][4]));
        }
        return Math.max(dp[days -1][1], Math.max(dp[days - 1][2], dp[days - 1][3]));
    }
}
