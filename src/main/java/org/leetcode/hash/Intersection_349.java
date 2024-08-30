package org.leetcode.hash;

import java.util.*;

public class Intersection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        // List<Integer> res = new ArrayList<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        // int[] res = new int[nums1.length];
        List<Integer> list = new ArrayList<>();
        for (Integer item : set2) {
            if (set1.contains(item)) {
                list.add(item);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
