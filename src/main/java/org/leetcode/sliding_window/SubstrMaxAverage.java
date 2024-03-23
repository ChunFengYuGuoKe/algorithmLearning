package org.leetcode.sliding_window;

public class SubstrMaxAverage {
    public static void main(String[] args) {
        int[] num = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(num, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        if(k > nums.length || k < 1 || nums.length < 1) {
            return -1;
        }
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int res = sum;

        for(int j = k; j < nums.length; j++) {
            // 为什么是j - k
            // 噢噢，右边加一个元素nums[j]，左边减去上一个窗口的第一个元素nums[j - k]
            sum += nums[j] - nums[j - k];
            res = Math.max(res, sum);
        }
        return (double)res/k;
    }
}
