package com.minmin.algorithmspass.level2;

import java.util.PriorityQueue;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
    public static int findKthLargestByMyself(int[] nums, int k) {
        // 首先进行防御性编程，判断k和nums数组的长度大小
        if (nums.length < k) {
            return -1;
        }
        // 创建小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(4, (a, b) -> a - b);
        // 用nums的前k个元素初始化小堆
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        int len = nums.length;

        // 用nums中剩下的数据更新小堆
        // for循环插入元素——判断当前元素与堆顶元素的大小，如果比堆顶元素大，则入堆
        for (int i = k; i < len; i++) {
            if (minHeap.peek() != null && nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        // 返回堆顶元素
        return minHeap.peek();
    }


















    public static int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            // 看一眼，不拿出，因为有可能没有必要替换
            Integer topEle = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topEle) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
