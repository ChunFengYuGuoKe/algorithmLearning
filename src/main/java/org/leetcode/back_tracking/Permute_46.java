package org.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */

/**
 * 1. 排列跟组合的区别是，排列是树枝去重，组合是数层去重
 * 2. 这道题也用了哈希优化
 * 3. 用一个状态数组标识当前元素有没有用过
 */
public class Permute_46 {
    List<Integer> permutation = new ArrayList<>();
    List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] isUsed = new boolean[nums.length];
        bt(isUsed, nums);
        return permutations;
    }

    private void bt(boolean[] isUsed, int[] nums) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
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
//    public List<List<Integer>> permute(int[] nums) {
//        boolean[] exist = new boolean[21];
//        backtrack(nums, exist);
//        return result;
//    }
//
//    public void backtrack(int[] nums, boolean[] exist) {
//        if (path.size() == nums.length) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        for (int num : nums) {
//            if (exist[num + 10]) {
//                continue;
//            }
//            exist[num + 10] = true;
//            path.add(num);
//            backtrack(nums, exist);
//            path.remove(path.size() - 1);
//            exist[num + 10] = false;
//        }
//    }
}


// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();

//         List<Integer> output = new ArrayList<Integer>();
//         for (int num : nums) {
//             output.add(num);
//         }

//         int n = nums.length;
//         backtrack(n, output, res, 0);
//         return res;
//     }

//     public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
//         if (first == n) {
//             res.add(new ArrayList<Integer>(output));
//         }

//         for (int i = first; i < n; i++) {
//             Collections.swap(output, first, i);
//             backtrack(n, output, res, first + 1);
//             Collections.swap(output, first, i);
//         }
//     }
// }