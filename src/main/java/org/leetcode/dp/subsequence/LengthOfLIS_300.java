package org.leetcode.dp.subsequence;

import java.util.Arrays;

/**
 * 最长递增子序列
 */
public class LengthOfLIS_300 {
    public int lengthOfLIS(int[] nums) {
        // dp含义？
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
