package org.leetcode.stack_queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 感觉这道题更多还是需要对数据结构有理解，同时也需要了解程序的逻辑，
 * 栈中递减存储，然后检测比栈顶元素小的当前元素，这样就能获取到栈顶元素两侧第一个比它小的元素了
 * 还要把题目和单调栈解法联系起来，感觉这一步也是难点
 */
public class LargestRectangleArea_LCR_039 {
    public int largestRectangleArea(int[] heights) {
        // 1. 有必要创建一个新数组吗，毕竟是O(n)的空间内复杂度
        int[] processedHeights = new int[heights.length + 2];
        processedHeights[0] = 0;
        processedHeights[heights.length + 1] = 0;
        System.arraycopy(heights, 0, processedHeights, 1, heights.length);
        Deque<Integer> st = new LinkedList<>();
        st.push(0);
        int maxArea = 0;
        for (int i = 1; i < processedHeights.length; i++) {
            while (!st.isEmpty() && processedHeights[i] < processedHeights[st.peek()]) {
                int curIndex = st.pop();
                if (st.isEmpty()) continue;
                int area = processedHeights[curIndex] * (i - st.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        return maxArea;
    }
}
