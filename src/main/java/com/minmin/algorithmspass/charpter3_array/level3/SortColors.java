package com.minmin.algorithmspass.charpter3_array.level3;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColorsByMySelf(nums);
        for (int num : nums) {
            System.out.print(num);
        }

    }

    public static void sortColorsByMySelf(int[] nums) {
        int slow = 0;
        int fast = 0;
        for (;fast < nums.length ;fast++) {
            if (nums[fast] == 0) {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
        }
        fast = slow + 1;
        for(;fast < nums.length ;fast++) {
            if(nums[fast] == 1) {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
        }
    }

    public static void sortColorsByMySelf2(int[] nums) {
        int slow = 0, fast = nums.length - 1;
        int index = 0;
        for(;index < nums.length; index++) {
            if(nums[index] == 0){

            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }


    public static void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        //将所有的0交换到数组的最前面
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }

        //将所有的1交换到2的前面
        for (int right = left; right < n; ++right) {
            if (nums[right] == 1) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                ++left;
            }
        }
    }
}
