package org.leetcode.dp;

public class FindTargetSumWays_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];
    }

    // 错误写法
//    public int findTargetSumWays(int[] nums, int target) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        int left = (sum + target) / 2;
//        int[] dp = new int[left + 1];
//        for (int j = 0; j <= left; j++) {
//            if (j >= nums[0]) dp[j] = nums[0];
//        }
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = left; j >= 1; j--) {
//                if (j >= nums[i]) {
//                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
//                }
//            }
//        }
//        return 0;
//    }
}
