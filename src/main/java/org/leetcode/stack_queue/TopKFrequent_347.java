package org.leetcode.stack_queue;

import java.util.*;

public class TopKFrequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(k, (entry1, entry2) -> entry2.getValue() - entry1.getValue());
        heap.addAll(entries);
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = Objects.requireNonNull(heap.poll()).getKey();
        }
        return result;
    }
}
