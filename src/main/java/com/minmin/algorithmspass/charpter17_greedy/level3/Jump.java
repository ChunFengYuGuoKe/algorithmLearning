package com.minmin.algorithmspass.charpter17_greedy.level3;

/**
 * LeetCode45 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 假设一定能到达末尾，然后让你求最少到达的步数该怎么办呢？
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jumpByMyself(nums));
    }

    public static int jumpByMyself(int[] nums) {
        // 1. 首先定义四个变量，curLeft和curRight用来控制每轮小循环
        //    curMax用于记录当前最远距离，steps用于记录当前步数
        int curRight = 0;
        int curMaxPos = 0;
        int steps = 0;
        for (int curLeft = 0; curLeft < nums.length; curLeft++) {
            // 2.1 每次移动一个格子，更新当前最大距离
            curMaxPos = Math.max(curMaxPos, curLeft + nums[curLeft]);
            // 2.2 如果已经走到了上一轮确定下来的边界，说明此时的curMaxPos已经是
            //     上一轮局部最优得了，也就是最远距离了，此时就用curMaxPos更新right，
            //     作为下一轮更新的边界
            if (curLeft == curRight) {
                curRight = curMaxPos;
                steps++;
            }
            // 2.3 如果当前最大位置已经可以到终点了，那么就可以收手了，先为把最后走的一步加上去
            //     至于为什么可以这样，我想的是因为之前轮数的步数已经算进去了，如果这里已经可以到终点了
            //     那就走最后一步就行了
            /**
             * if (curMaxPos >= nums.length - 1) {
             *                 steps++;
             *                 break;
             *             }
             * 这里这样写是有问题的，会额外多加一次步数
             * 错误原因是要么步数还没更新就返回，妖要么就多算了一次步数
             * 只用curRight这个变量来控制终止条件，max只是用来指示当前最远距离的
             */
             if (curRight >= nums.length - 1) {
                 return steps;
             }
        }
        return steps;
    }










    public static int jump(int[] nums) {
        int right = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int left = 0; left < nums.length - 1; left++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[left] + left);
            if (left == right) { //遇到边界，就更新边界，并且步数加一
                right = maxPosition;
                steps++;
            }
            //right指针到达末尾了。
            if (right >= nums.length - 1) {
                return steps;
            }
        }
        return steps;
    }
}
