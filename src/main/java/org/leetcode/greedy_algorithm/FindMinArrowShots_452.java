package org.leetcode.greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots_452 {
    public static void main(String[] args) {
        FindMinArrowShots_452 findMinArrowShots452 = new FindMinArrowShots_452();
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};

        System.out.println(Arrays.deepToString(points));

        int minArrowShots = findMinArrowShots452.findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (point1, point2) -> {
            if (point1[0] > point2[0]) {
                return 1;
            } else if (point1[0] < point2[0]) {
                return -1;
            } else {
                return 0;
            }
        });
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            // 有重叠，修改当前气球的有边界
            if (points[i][0] <= points[i - 1][1]) {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            } else {
                result++;
            }
        }
        return result;
    }
}
