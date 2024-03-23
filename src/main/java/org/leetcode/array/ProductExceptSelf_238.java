package org.leetcode.array;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] R = new int[nums.length];
        int[] L = new int[nums.length];
        int[] res = new int[nums.length];
        L[0] = 1;
        R[nums.length - 1] = 1;
        // 像这样的情况是逐步迭代，不用每一次都全部重新算
        // 这样就显著地降低了复杂度，只用一次遍历就完成计算了

        // 这里的思路也很好，就是把一个元素的左右两边分开看，同时迭代地进行计算
        // 并且这里对边界值地处理也很精密，比如将第一个元素地左边乘积初始化为1，最后一个元素的左边初始化为1
        for(int i  = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for(int j = nums.length - 2; j >= 0; j--) {
            R[j] = R[j + 1] * nums[j + 1];
        }
        for(int k = 0; k < nums.length; k++) {
            res[k] = L[k] * R[k];
        }
        return res;
    }
}
