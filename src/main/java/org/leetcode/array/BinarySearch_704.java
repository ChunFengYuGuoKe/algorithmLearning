package org.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearch_704 {
    public static void main(String[] args) {
        BinarySearch_704 binarySearch704 = new BinarySearch_704();
        int[] nums = {5};
        binarySearch704.search(nums, 5);
    }

    // 左闭右开
    public int search(int[] nums, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.peek();
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left + right) >> 1;
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // 左闭右闭
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
