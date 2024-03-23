package com.minmin.algorithmspass.charpter3_array.level2.topic2_4区间合并;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并区间
 */
public class SummaryRanges {

    public static void main(String[] args) {
        int[] arr = {0,2,3,4,6,8,9,11};
        System.out.println(summaryRanges(arr));
    }

    public static List<String> summaryRangesByMyself (int[] nums) {
        int slow = 0;
        int fast = 0;
        List<String> result = new ArrayList<String>();
        for(;fast < nums.length - 1;fast++) {
            if(nums[fast + 1] != nums[fast] + 1) {
                if(nums[slow] == nums[fast]) {
                    result.add(Integer.toString(nums[slow]));
                }else {
                    result.add(nums[slow] + "->" + nums[fast]);
                }
                slow = fast + 1;
            }
            if(fast == nums.length - 2) {
                if(nums[fast + 1] == nums[fast] + 1) {
                    result.add(nums[slow] + "->" + nums[fast + 1]);
                }else if (nums[fast - 1] + 1 == nums[fast]){
                    //result.add(nums[slow] + "->" + nums[fast]);
                    result.add(Integer.toString(nums[fast + 1]));
                }
            }
        }
        return result;
    }














    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        // slow 初始指向第 1 个区间的起始位置
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            // fast 向后遍历，直到不满足连续递增(即 nums[fast] + 1 != nums[fast + 1])
            // 或者 fast 达到数组边界，则当前连续递增区间 [slow, fast] 遍历完毕，将其写入结果列表。
            if (fast + 1 == nums.length || nums[fast] + 1 != nums[fast + 1]) {
                // 将当前区间 [slow, fast] 写入结果列表
                StringBuilder sb = new StringBuilder();
                sb.append(nums[slow]);
                if (slow != fast) {
                    sb.append("->").append(nums[fast]);
                }
                res.add(sb.toString());
                // 将 slow 指向更新为 fast + 1，作为下一个区间的起始位置
                slow = fast + 1;
            }
        }
        return res;
    }
}
