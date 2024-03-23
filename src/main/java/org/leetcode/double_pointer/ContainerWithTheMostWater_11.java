package org.leetcode.double_pointer;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 */
public class ContainerWithTheMostWater_11 {
    public int maxArea(int[] height) {
        // 左边基于什么移动呢，右边又基于什么移动呢
        // 每次都要算容量，并与最大容量进行比较吗

        // 对啊每次只要移动小的那一边就可以了，其实两个值可以看作一个值的，
        // 最后的综合结果就是由小的那一边决定的，对顺序没有要求
        // 所以每次只要移动小的那一边看能不能变得大一点就可以了
        int n = height.length;
        int left = 0, right = n - 1;
        // int maxLeft = 0, maxRight = n - 1;
        int maxCapacity = 0;
        while(left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentCapacity = currentHeight * currentWidth;
            if(currentCapacity > maxCapacity) {
                maxCapacity = currentCapacity;
                // maxLeft = left;
                // maxRight = right;
            }
            //(height[left] < height[right]) ? left++ : right--;
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxCapacity;
    }
}
