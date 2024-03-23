package org.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class SumOfTwo_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ht = new HashMap<Integer, Integer>();
        // 获取数组长度length不用带括号
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(ht.containsKey(target - nums[i])){
                return new int[]{ht.get(target - nums[i]), i};
            }
            ht.put(nums[i], i);
        }
        return null;
    }
}
