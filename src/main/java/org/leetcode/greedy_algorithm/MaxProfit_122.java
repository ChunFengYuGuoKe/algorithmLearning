package org.leetcode.greedy_algorithm;

public class MaxProfit_122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int curProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            curProfit = prices[i] - prices[i - 1];
            if (curProfit > 0) {
                profit += curProfit;
            }
        }
        return profit;
    }
}
