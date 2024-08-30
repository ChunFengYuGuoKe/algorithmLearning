package org.leetcode.greedy_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            // 重叠时，修改结果集中上一个区间的右边界
            if (intervals[i][0] <= res.get(res.size() - 1)[1]) {
                res.get(res.size() - 1)[1] = Math.max(intervals[i][1], res.get(res.size() - 1)[1]);
                // pos = res.get(res.size() - 1)[1];
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
//        int[][] resultArr = new int[res.size()][2];
//        for (int i = 0; i < res.size(); i++) {
//            resultArr[i] = res.get(i);
//        }
//        return resultArr;
    }
}
