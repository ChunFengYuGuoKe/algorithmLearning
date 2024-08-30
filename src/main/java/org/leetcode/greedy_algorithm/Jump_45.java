package org.leetcode.greedy_algorithm;

public class Jump_45 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int steps = 0;
        int curDis = 0;
        int nextDis = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDis = Math.max(i + nums[i], nextDis);
            if (i == curDis) {
                if (curDis < nums.length - 1) {
                    steps++;
                    curDis = nextDis;
                    if (curDis >= nums.length - 1) break;
                } else {
                    break;
                }
            }
        }
        return steps;
    }
}
