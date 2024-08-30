package org.leetcode.dp;

import java.util.Arrays;

public class NumSquares_279 {
    public static void main(String[] args) {
        NumSquares_279 numSquares279 = new NumSquares_279();
        int i = numSquares279.numSquares(1);
        System.out.println();
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            // < 和 <= 要分清楚
            for (int j = square; j <= n; j++) {
                // 只有 dp[j - square] != Integer.MAX_VALUE 才有意义
                if (dp[j - square] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - square] + 1, dp[j]);
                }
            }
        }
        return dp[n];
    }
}
