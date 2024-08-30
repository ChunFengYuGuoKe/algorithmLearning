package org.leetcode.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortedSquares_977 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int idx = nums.length - 1;
        while (left <= right) {
            if ((nums[left] * nums[left]) > (nums[right] * nums[right])) {
                result[idx] = nums[left] * nums[left];
                left++;
            } else {
                result[idx] = nums[right] * nums[right];
                right--;
            }
            idx--;
        }
        return result;
    }
}
