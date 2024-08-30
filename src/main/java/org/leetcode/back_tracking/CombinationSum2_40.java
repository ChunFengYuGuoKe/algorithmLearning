package org.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {
    private final List<Integer> combination = new ArrayList<>();
    private final List<List<Integer>> combinations = new ArrayList<>();

    private int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] isUsed = new boolean[candidates.length];
        bt(0, isUsed, candidates, target);
        return combinations;
    }

    public void bt(int startIndex, boolean[] isUsed, int[] candidates, int target) {
        if (sum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !isUsed[i - 1]) continue;
            sum += candidates[i];
            combination.add(candidates[i]);
            isUsed[i] = true;
            bt(i + 1, isUsed, candidates, target);
            isUsed[i] = false;
            combination.remove(combination.size() - 1);
            sum -= candidates[i];
        }
    }
}
