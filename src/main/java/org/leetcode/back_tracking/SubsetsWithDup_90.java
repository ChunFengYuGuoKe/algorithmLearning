package org.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup_90 {
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> subsets = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        bt(0, isUsed, nums);
        return subsets;
    }

    private void bt(int startIndex, boolean[] isUsed, int[] nums) {
        subsets.add(new ArrayList<>(subset));
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) continue;
            isUsed[i] = true;
            subset.add(nums[i]);
            bt(i + 1, isUsed, nums);
            subset.remove(subset.size() -1);
            isUsed[i] = false;
        }
    }



























//    static List<List<Integer>> result = new ArrayList<>();
//    static List<Integer> path = new ArrayList<>();
//    public static List<List<Integer>> subsetsWithDup(int[] nums) {
//        backtrack(nums, 0);
//        return result;
//    }
//
//    public static void backtrack(int[] nums, int startIndex) {
//        result.add(new ArrayList<>(path));
//        if (path.size() >= nums.length) {
//            return;
//        }
//        boolean[] curLevelUsed = new boolean[21];
//        for (int i = startIndex; i < nums.length; i++) {
//            if (curLevelUsed[nums[i] + 10]) {
//                continue;
//            }
//            curLevelUsed[nums[i] + 10] = true;
//            path.add(nums[i]);
//            backtrack(nums, i + 1);
//            path.remove(path.size() - 1);
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {4,4,4,1,4};
//        List<List<Integer>> answer = subsetsWithDup(nums);
//        System.out.println(answer);
//    }
}
