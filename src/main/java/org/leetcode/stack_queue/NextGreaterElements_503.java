package org.leetcode.stack_queue;

import java.util.*;

public class NextGreaterElements_503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> st = new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        st.push(0);
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int processingIndex = st.pop();
                result[processingIndex] = nums[i % n];
            }
            st.push(i % n);
        }
//        for (int i = 0; i < 2 * n; i++) {
//            while (!st.isEmpty() && nums[i % n] > nums[st.peek() % n]) {
//                int processingIndex = st.pop() % n;
//                result[processingIndex] = nums[i % n];
//            }
//            st.push(i % n);
//        }
        return result;
    }
}
