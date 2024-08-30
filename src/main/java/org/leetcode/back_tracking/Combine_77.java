package org.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Combine_77 {
    static List<Integer>  path = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<List<Integer>> combine(int n, int k) {
        combineByRecurse(n, k, 1);
        return res;
    }

    private static void combineByRecurse(int n, int k, int startIndex) {
        if (path.size() == k) {
            List<Integer> onePath = new ArrayList<>(path);
            res.add(onePath);
            return;
        }
        for (int i = startIndex; i <= (n - (k - path.size()) + 1); i++) {
            path.add(i);
            combineByRecurse(n, k, i + 1);
            Integer curNum = i;
            path.remove(curNum);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
}
