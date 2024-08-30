package org.leetcode.double_pointer;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap_42 {
    // 方法一：动态规划
    // public int trap(int[] height) {
    //     int n = height.length;
    //     // 1. 防御式编程，并且避免不必要的计算
    //     if (n == 0) {
    //         return 0;
    //     }

    //     // 2. 定义用于辅助计算的数组
    //     int[] leftMax = new int[n];
    //     leftMax[0] = height[0];
    //     // 3. 循环更新每个下标位置的左侧最大高度
    //     // 为什么可以这样更新，相当于每一步都利用了前面的结果，显著降低复杂度
    //     for (int i = 1; i < n; ++i) {
    //         leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    //     }

    //     // 4. 从右向左遍历，得到每个位置处右侧的最大高度
    //     int[] rightMax = new int[n];
    //     rightMax[n - 1] = height[n - 1];
    //     for (int i = n - 2; i >= 0; i--) {
    //         rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    //     }


    //     // 5. 遍历每个下标位置，得到每个位置能接的雨水量
    //     int ans = 0;
    //     for (int i = 0; i < n; i++) {
    //         ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    //     }
    //     return ans;
    // }

    // 方法二：单调栈
    // public int trap(int[] height) {
    //     int ans = 0;
    //     Deque<Integer> stack = new LinkedList<Integer>();
    //     int n = height.length;
    //     for (int i = 0; i < n; i++) {
    //         while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
    //             int top = stack.pop();
    //             if (stack.isEmpty()) {
    //                 break;
    //             }
    //             int left = stack.peek();
    //             int currWidth = i - left - 1;
    //             int currHeight = Math.min(height[left], height[i]) - height[top];
    //             ans += currWidth * currHeight;
    //         }
    //         stack.push(i);
    //     }
    //     return ans;
    // }

    // 方法三：双指针
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // 这里为什么要用这个条件来控制
            // 使最后右边界一定能到离左边界最近的且比左边界对应的栅栏要高
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
