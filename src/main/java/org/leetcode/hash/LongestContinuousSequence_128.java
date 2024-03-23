package org.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LongestContinuousSequence_128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            // 先使用num_set去重，防止之后对同一个数重复处理
            for(int num : nums) {
                num_set.add(num);
            }
            int longestStreak = 0;
            for(int num : num_set) {
                // hash表最本质的特征还是能很快地查找一个值，这是由他的存储机制决定的，永远只有O(1)的复杂度
                if(!num_set.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while(num_set.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    // 获取最值通用思路，提前每回合都把当前值与最值进行比较，比较两者之中更大/小的那个
                    // 这样不断迭代，就能得到总体最大的那个值
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
            return longestStreak;
        }
    }
}
