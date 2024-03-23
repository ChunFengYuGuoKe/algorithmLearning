package org.leetcode.ordinary_array;

public class RotatingArray {
    // 感谢之前的自己，有了一些积累，一些思考，现在做题才能有很顺畅的思路
    public static void main(String[] args) {
        rotate(new int[]{1, 2, 4, 5}, 3);
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        String s = "jfieujfiju";
        s.substring(0, 1);
        char[] arr = {'f', 'j', 'i'};
        System.out.println(arr.equals("fji".toCharArray()));
    }

    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
