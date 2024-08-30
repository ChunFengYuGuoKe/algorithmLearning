package org.leetcode.stack_queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 单调栈就是要维护栈的一个大小顺序结构，同时利用栈的后进先出的特点
public class DailyTemperatures_739 {
    public static void main(String[] args) {
        DailyTemperatures_739 dailyTemperatures739 = new DailyTemperatures_739();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures739.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
                // 1. 当前元素 > 栈顶元素
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    Integer pop = stack.pop();
                    result[pop] = i - pop;
                }
                // 2. 当前元素 == 栈顶元素
                // 3. 当前元素 < 栈顶元素
            stack.push(i);
        }
        return result;
    }
}
