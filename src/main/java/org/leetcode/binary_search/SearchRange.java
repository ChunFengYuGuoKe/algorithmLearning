package org.leetcode.binary_search;

public class SearchRange {
    public static void main(String[] args) {
        // int[] nums = {5,7,7,8,8,10};
        int[] nums = {5};
        int res = searchFirst(nums, 5);
        System.out.println(res);
    }
    public static int[] searchRange(int[] nums, int target) {
        int first = searchFirst(nums, target);
        int last = searchLast(nums, target);
        return new int[]{first, last};
    }

    /**
     * 第一个问题——当我在用searchFirst时，找到target之后，更新right不能用right = mid - 1
     * 我怀疑是因为int mid = left + ((right - left) >> 1);这个算式的影响，因为它始终是向下取整的
     * **************************************************************************
     * 第二个问题，还不能处理只有单个元素的情况
     * @param nums
     * @param target
     * @return
     */
    public static int searchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int searchLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return result;
    }
}
