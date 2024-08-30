package org.leetcode.sliding_window;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxSlidingWindow_239 {
    public static void main(String[] args) {
        MaxSlidingWindow_239 maxSlidingWindow239 = new MaxSlidingWindow_239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow239.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    static class MyQueue {
        private final Deque<Integer> queue = new LinkedList<>();

        Integer poll(int val) {
            if (!queue.isEmpty() && val == queue.peek()) {
                return queue.poll();
            }
            return queue.peek();
        }

        void offer(int val) {
            while (!queue.isEmpty() && val > queue.peekLast()) {
                queue.removeLast();
            }
            queue.offer(val);
        }

        Integer peek() {
            return queue.peek();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.offer(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        // result[0] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            result[i - k] = myQueue.poll(nums[i - k]);
            myQueue.offer(nums[i]);
        }
        result[result.length - 1] = myQueue.peek();
        return result;
    }
}
