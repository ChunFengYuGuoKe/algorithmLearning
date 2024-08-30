package org.leetcode.greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FindContentChildren_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int index = s.length - 1;
        for (int i = 0; i < g.length; i++) {
            if (index >= 0 && s[index] >= g[i]) {
                result++;
                index--;
            }
        }
        return result;
    }
}
