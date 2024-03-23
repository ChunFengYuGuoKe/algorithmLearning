package org.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge_56 {
    public static int[][] merge(int[][] intervals) {
        // 外层循环是用来遍历每一个小数组
        // 然后判断前一个小数组的第二个元素是否小于后一个小数组的第一个元素
        // 如果是小于关系，就将他们合并

        // 错了，应该还有一个条件，前一个数组的第二个元素要小于第二个元素的第二个元素

        // 此外，还得先对数组进行排序
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 这里是重写了一个比较方法，似乎也可以用lambda表达式
        // 这里可以看出，在二维数组中，是把第二维当成一个元素
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for(int i  = 0; i < intervals.length; ++i) {
            int left = merged.get(i)[0], right = merged.get(i)[1];
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < left) {
                merged.add(intervals[i]);
            } else {
                // 这里就体现按照第一个元素排序的好处了，不用再考虑第一个元素了
                // 排序了就相当于已经把问题规模缩减了一次了
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        // 再将list转换为数组，这里第一个参数是要给的
        return merged.toArray(new int[merged.size()][]);
    }
}
