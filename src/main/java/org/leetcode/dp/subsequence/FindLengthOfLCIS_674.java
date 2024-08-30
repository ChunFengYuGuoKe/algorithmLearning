package org.leetcode.dp.subsequence;

import java.util.Arrays;

public class FindLengthOfLCIS_674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}