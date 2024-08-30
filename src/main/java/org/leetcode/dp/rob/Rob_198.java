package org.leetcode.dp.rob;

public class Rob_198 {
    public int rob(int[] nums) {
        /**
         * 上一家有没有偷这个信息，要怎么判断呢？
         * 这个问题说明我的思路有点问题，这里应该不是从前一家是否被偷的状态来判断当前这家能否被偷，
         * 而应该反过来想，如果要偷当前这家，那么之前最多偷到i - 2家，如果不偷，最多能偷到i - 1家
         */


        /**
         * 我好像还是在用背包问题的思路解这道题，它和背包问题有什么区别呢？
         * 1. 这里并没有一个背包，没有最多能偷多少的限制
         * 2. 多了不能相邻偷的限制
         * 3. 偷的东西和它的下标位置是强相关的
         */

        // dp[i]的含义是考虑到第i家之后，最多能偷的钱财，但不一定要偷nums[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length < 2) return nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        /**
         * 错误解法
         * for (int i = 0; i < nums.length; i++) {
         *             for (int j = 2; j < nums.length; j++) {
         *                 dp[j] = Math.max(dp[j - 2] + nums[i], dp[j - 1]);
         *             }
         *         }
         */
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
