package org.leetcode.greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals_435 {
    // bug 代码
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int result = 0;
        int pos = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 重叠时，这里多了个等于的情况
            if (intervals[i][0] <= pos) {
                result++;
                pos = Math.min(intervals[i][1], pos);
            } else {
                pos = intervals[i][1];
            }
        }
        return result;
    }

    // carl 解法
    public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int result = 0;
        // int pos = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 重叠时
            if (intervals[i][0] < intervals[i - 1][1]) {
                result++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return result;
    }

}
