package org.leetcode.array;

public class MaxSubArray_53 {
    // 操，这不就是我下午面试的那道题吗

    // 长教训了，以后做题要专注一点，每道题都有可能问到
    public int maxSubArray(int[] nums) {
        // int pre = 0, max = nums[0];
        // for(int x : nums) {
        //     // 这里数据的处理很有意思
        //     // 用两个变量，一个变量来记录当前最大值，另一个用来记录整体最大值

        //     // 这里的处理是把当前的所有值和现在这个元素的值进行比较，也很巧妙，这样就避开了我下午的不能判断负数的问题
        //     pre = Math.max(pre + x, x);
        //     max = Math.max(max, pre);
        // }
        // return max;

        // 第二版，看了动态规划的视频自己做的，
        // 这个是优化之前的，用一个数组存储每个节点的计算结果，避免重复计算，
        // 优化之后发现，由于这道题有连续子数组的要求，所以其实不必判断后面的每一个子数组
        // 那么就只用一个int变量存后一个子序列的最大值即可
//         class solution {
// 	public int max (int[] nums) {
// 		int n = nums.length;
// 		int[] L = Arrays.copyof(nums, n);
// 		int maxval = nums[n - 1];
// 		for(int i = n - 2; i >= 0; i--) {
// 			//for(int j = i +_1; j < n; j++) {
// 			//	L[i] = Math.max(
// 			//}
// 			L[i] = Math.max(nums[i], nums[i] + L[i + 1]);
//
// 			maxval = Math.max(L[i], L[i+1]); 这里是有错误的，L[i]就相当于是从当前位置开始的最长子序列，它应该与最长子序列比较才对
//                                           而不是与下一个元素开始的子序列比较，因为后一个子序列的大小可能不是最大的
// 		}
// 		return maxval;
// 	}
// }
        // 这道题算是比较特殊的，因为它的题目要求导致它从前面做也可以
        // 但是通常情况下，应该还是从后面开始做求比较好，然后处理到前面的时候再复用结果，因为从后面开始算，它的可能分支是要少很多的
        int n = nums.length;
        //int[] L = Arrays.copyOf(nums, n);
        int post = nums[n - 1];
        int maxval = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            //for(int j = i +_1; j < n; j++) {
            //	L[i] = Math.max(
            //}
            post = Math.max(nums[i], nums[i] + post);
            maxval = Math.max(post, maxval);
        }
        return maxval;
    }
}
