package org.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    private final List<Integer> combination = new ArrayList<>();
    private final List<List<Integer>> combinations = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // boolean[] used = new boolean[candidates.length];
        bt(0, candidates, target);
        return combinations;
    }

    private void bt(int startIndex, int[] candidates, int target) {
        if (sum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            combination.add(candidates[i]);
            bt(i, candidates, target);
            combination.remove(combination.size() - 1);
            sum -= candidates[i];
        }
    }
}
