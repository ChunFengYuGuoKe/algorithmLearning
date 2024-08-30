package org.leetcode.sliding_window;

public class SubstrMaxAverage {
    public static void main(String[] args) {
        // int[] num = {1, 12, -5, -6, 50, 3};
        int[] num = {0 ,4 ,0 ,3 ,2};
        System.out.println(findMaxAverage2(num, 1));
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

    public static double findMaxAverage2(int[] nums, int k) {
        // 1.首先进行防御性编程
        if (nums.length < k) return -1;
        int left = 0, right = k - 1;
        // 滑动窗口和结果要分别用一个变量来存，否则会出现逻辑错误
        double sum = 0;
        // 像这种涉及下标的运算，最好还是用for循环来做，用while容易出现边界问题
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = 0;
        while (right + 1 < nums.length) {
            right++;
            sum = sum + nums[right] - nums[left];
            maxSum = Math.max(sum, maxSum);
            left++;
        }
        return maxSum / k;
    }
}
