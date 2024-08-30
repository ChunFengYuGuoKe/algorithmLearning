package org.leetcode.greedy_algorithm;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    public static void main(String[] args) {
        String s = "vhaagbqkaq";
        PartitionLabels_763 partitionLabels763 = new PartitionLabels_763();
        List<Integer> list = partitionLabels763.partitionLabels(s);
        System.out.println(list);
    }

    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] covers = new int[26];
        for(int i = 0; i < n; i++) {
            covers[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int cover = Integer.MIN_VALUE;
        int subLen = 0;
        for (int i = 0; i < n; i++) {
            cover = Math.max(covers[s.charAt(i) - 'a'], cover);
            subLen++;
            if (i == cover) {
                result.add(subLen);
                subLen = 0;
            }
        }
        return result;
    }
}