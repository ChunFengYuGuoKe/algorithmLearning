package org.leetcode.heap;

import java.util.PriorityQueue;

class MedianFinder_295 {
    // 定义用于存储较大的那一半元素的小堆
    PriorityQueue<Integer> minHeap;
    // 定义用于存储较小的那一半元素的大堆
    PriorityQueue<Integer> maxHeap;


    public MedianFinder_295() {
        // 初始化两个堆
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    public void addNum(int num) {
        // 如果minHeap为空或者num大于小堆堆顶元素，入小堆，否则入大堆
        if (minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.offer(num);
            // 如果入堆后小堆的元素比大堆的元素多两个，则给一个元素给大堆
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        } else {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        int totalSize = minHeap.size() + maxHeap.size();
        // 如果两个堆的元素数量之和为奇数，返回小堆堆顶元素
        if (totalSize % 2 == 1) {
            return minHeap.peek();
        } else { // 如果两个堆元素数量之和为偶数，返回两堆堆顶元素之后的平均值
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
