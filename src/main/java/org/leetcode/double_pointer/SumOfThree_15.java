package org.leetcode.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class SumOfThree_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int first = 0; first < n; first++) {
            // 只需要保证每个数跟上次的不一样就好，因为是排了序的，所以只要不一样就不会有重复的
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int target = -nums[first];
            int third = n - 1;
            for(int second = first + 1; second < n; second++){
                // 这里同上，然后前两个数都不一样了，最后一个数就肯定不一样了。因为前两个数只会增长，不存在说一个增一个减，把变化抵消的说法
                if(second > first + 1 && nums[second] == nums[second - 1]) continue;
                while(second < third && nums[second] + nums[third] > target){
                    third--;
                }
                if(second == third) break;
                if(nums[second] + nums[third] == target) {
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(nums[first]);
                    res.add(nums[second]);
                    res.add(nums[third]);
                    ans.add(res);
                }

            }
        }
        return ans;
    }
}
