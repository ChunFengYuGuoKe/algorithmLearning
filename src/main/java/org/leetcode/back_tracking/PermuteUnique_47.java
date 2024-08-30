package org.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermuteUnique_47 {
    List<Integer> permutation = new ArrayList<>();
    List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        bt(isUsed, nums);
        return permutations;
    }

    private void bt(boolean[] isUsed, int[] nums) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) continue;
            if (!isUsed[i]) {
                isUsed[i] = true;
                permutation.add(nums[i]);
                bt(isUsed, nums);
                permutation.remove(permutation.size() - 1);
                isUsed[i] = false;
            }
        }
    }





















//    List<List<Integer>> result = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        boolean[] used = new boolean[nums.length];
//        backtrack(nums, used);
//        return result;
//    }
//    public void backtrack(int[] nums, boolean[] used) {
//        if (path.size() == nums.length) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        // 用于树层去重，如果这个数在树的同一层已经用过了，就没必要继续算了，只会导致重复
//        boolean[] curLevelUsed = new boolean[21];
//        for (int i = 0; i < nums.length; i++) {
//            // 如果这个位置的数在同一个树枝上已经用过，或者在同一树层已经用过，就跳过
//            if (used[i] || curLevelUsed[nums[i] + 10]) {
//                continue;
//            }
//            curLevelUsed[nums[i] + 10] = true;
//            used[i] = true;
//            path.add(nums[i]);
//            backtrack(nums, used);
//            path.remove(path.size() - 1);
//            used[i] = false;
//        }
//    }
}
