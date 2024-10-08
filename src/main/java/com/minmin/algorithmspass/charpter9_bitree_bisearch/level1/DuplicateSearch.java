package com.minmin.algorithmspass.charpter9_bitree_bisearch.level1;

/**
 * 在序列中存在重复元素时的二分查找
 */

public class DuplicateSearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9};
        int result = -1;
        int testMethod = 1;
        switch (testMethod) {
            case 1:
                result = search1(array, 2);
                break;
            case 2:
                result = search2(array, 3);
                break;

        }
        System.out.println(result);


    }

    public static int search1ByMyself(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 如果mid元素一直等于目标值，就一直向前找，直到不为目标值
                while (mid != 0 && nums[mid] == target) {
                    mid --;
                }
                // 当循环是因为mid到0位置时，mid不用+1
                if (mid == 0 && nums[mid] == target) {
                    return mid;
                }
                // 当循环是因为nums[mid] != target停下时，mid需要+1，因为上一个元素才是target
                return mid + 1;
            }
        }
        return -1;
    }

    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0;

        if (nums[0] == target) {
            return 0;
        }

        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                //找到之后，往左边找
                while (mid != 0 && nums[mid] == target)
                    mid--;
                return mid + 1;
            }
        }
        return -1;
    }

    /**
     * 方法二，仍然采用递归来找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        return binSearch2(nums, target, 0, nums.length - 1);
    }

    private static int binSearch2(int[] nums, int target, int left, int right) {
        if (left > right)
            return -1;
        if (nums[left] == target)
            return left;
        int mid = left + ((right - left) >> 1);
        if (nums[mid] < target) {
            return binSearch2(nums, target, mid + 1, right);
        } else if (nums[mid] > target) {
            return binSearch2(nums, target, left, mid - 1);
        } else {
            return binSearch2(nums, target, left, mid);
        }
    }
}
