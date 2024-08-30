package org.leetcode.dp;

public class LastStoneWeightII_1049 {
    public int lastStoneWeightII(int[] stones) {
        int weight = 0;
        for (int stone : stones) {
            weight += stone;
        }
        int cap = weight / 2;
        int[] dp = new int[cap + 1];
        for (int j = 0; j <= cap; j++) {
            if (j >= stones[0]) dp[j] = stones[0];
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = cap; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return weight - dp[cap] -dp[cap];
    }
}
