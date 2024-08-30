package org.leetcode.back_tracking;

import java.util.*;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * 示例 1：
 *
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 *
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 *
 * 提示：
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */

/**
 * 从本题中我学到了：
 * 1. 同一数层去重可以使用Set
 * 2. 可以使用数组进行哈希优化，用数映射位置的操作换掉哈希判断
 */
public class FindSubsequences_491 {
    List<Integer> subsequence = new ArrayList<>();
    List<List<Integer>> subsequences = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        boolean[] isUsed = new boolean[nums.length];
        bt(0, isUsed, nums);
        return subsequences;
    }

    private void bt(int startIndex, boolean[] isUsed, int[] nums) {
        if (subsequence.size() >= 2) {
            subsequences.add(new ArrayList<>(subsequence));
        }
        if (startIndex >= nums.length) return;
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 如果当前的数大于等于序列中的前一个数，则加入到子序列中，否则 continue
            // 不能用 nums[i] == nums[i - 1] 去重，因为没有排序，这道题也不能排序，会破坏原本的顺序
//            if ((!subsequence.isEmpty() && nums[i] < subsequence.get(subsequence.size() - 1))
//                    || (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1])) continue;
            if ((!subsequence.isEmpty() && nums[i] < subsequence.get(subsequence.size() - 1))
                    || set.contains(nums[i])) continue;
            set.add(nums[i]);
            isUsed[i] = true;
            subsequence.add(nums[i]);
            bt(i + 1, isUsed, nums);
            subsequence.remove(subsequence.size() - 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        FindSubsequences_491 findSubsequences491 = new FindSubsequences_491();
        int[] nums = {4,6,7,7};
        List<List<Integer>> subsequences1 = findSubsequences491.findSubsequences(nums);
        System.out.println(nums);
    }


    /**
     * 双指针法——滑动窗口
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences1(int[] nums) {
        List<List<Integer>> subsequences = new ArrayList<>();
        LinkedList<Integer> subsequence = new LinkedList<>();
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] <= nums[right + 1]) {
                subsequence.addLast(nums[right]);
                right++;
            } else {
                subsequence.addLast(nums[right]);
                right++;
                while (left < right) {
                    left++;
                    subsequence.removeFirst();
                    subsequences.add(new LinkedList<>(subsequence));
                }
            }
        }
        // for (int right = 0; right < nums.length; right++) {
        //     if ()
        // }
        return subsequences;

    }



//    static Deque<Integer> path = new ArrayDeque<>();
//    static List<List<Integer>> result = new ArrayList<List<Integer>>();
//    public static List<List<Integer>> findSubsequences(int[] nums) {
//        boolean[] used = new boolean[nums.length];
//        backtrack(nums, 0, used);
//        return result;
//    }
//
//    public static void backtrack(int[] nums, int startIndex, boolean[] used) {
//        if (path.size() >= 2) {
//            result.add(new ArrayList<>(path));
//        }
//        if (startIndex >= nums.length) {
//            return;
//        }
//        Set<Integer> usedSet = new HashSet<>();
//        for (int i = startIndex; i < nums.length; i++) {
//            // 如果当前path为空，或者不为空但当前值大于等于上一个值，才继续往下判断
//            if (path.isEmpty() || path.getLast() <= nums[i]) {
//                if (i > 0 && usedSet.contains(nums[i])) {
//                    continue;
//                }
//                usedSet.add(nums[i]);
//                path.addLast(nums[i]);
//                used[i] = true;
//                backtrack(nums, i + 1, used);
//                used[i] = false;
//                path.removeLast();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {100,90,80,70,60,50,60,70,80,90,100};
//        List<List<Integer>> answer = findSubsequences(nums);
//        System.out.println(answer);
//    }
}
