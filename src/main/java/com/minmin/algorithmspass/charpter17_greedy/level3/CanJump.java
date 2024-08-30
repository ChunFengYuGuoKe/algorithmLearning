package com.minmin.algorithmspass.charpter17_greedy.level3;

/**
 * leetCode 55 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度，判断你是否能够到达最后一个位置。
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    /**
     * 用一个相对静态的cover值来存当前最大值，它是一个结果变量，而i是用于遍历处理的过程变量。
     * 这道题目的难点是要想到覆盖范围，而不用拘泥于每次究竟跳几步，
     * 覆盖范围是可以逐步扩展的，只有能覆盖就一定是可以跳过来的，不用管是怎么跳的。
     * @param nums
     * @return
     */
    public static boolean canJumpByMyself(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // 1. 定义一个cover，用来存储当前最远能到的距离
        int cover = 0;
        // 2. 循环遍历数组，找到最大cover
        for (int i = 0; i < nums.length; i++) {
            // 2.1 每次将当前这个位置能到的最远位置和当前cover值进行比较
            //      用较大的那个更新cover值
            cover = Math.max(cover, i + nums[i]);
            // 2.2 当cover大于终结值时，返回true
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int cover = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
