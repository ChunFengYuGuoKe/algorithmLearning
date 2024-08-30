package org.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> subsets = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        bt(0, nums);
        return subsets;
    }

    private void bt(int startIndex, int[] nums) {
        subsets.add(new ArrayList<>(subset));
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);;
            bt(i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
