package com.minmin.algorithmspass.charpter5_queue_map.level2;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSumByMyself(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1;
            int target = -nums[first];
            for(int second = first + 1; second < n; second++) {
                //这里的条件是second > first + 1，也就是说second == first + 1时不需要判断吗？为什么
                // ！！！我知道了，因为second是从first + 1开始的，如果不大于first + 1，它就压根没有前一个元素可言
                if(second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while(second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
//                if (second > first + 1 && nums[second] == nums[second - 1]) {
//                    continue;
//                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]nums = {-1,0,1,2,-1,-4};
        //int[] nums = {0, 0, 0,0,0};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}
