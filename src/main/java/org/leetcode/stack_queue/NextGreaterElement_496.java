package org.leetcode.stack_queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterElement_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> st = new LinkedList<>();
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            map.put(nums1[i], i);
        }
        st.push(0);
        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty() && nums2[i] > nums2[st.peek()]) {
                int nums2Index = st.pop();
                if (map.containsKey(nums2[nums2Index])) {
                    int curEleIndex = map.get(nums2[nums2Index]);
                    result[curEleIndex] = nums2[i];
                }
            }
            st.push(i);
        }
        return result;
    }
}
