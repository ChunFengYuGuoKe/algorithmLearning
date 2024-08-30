package com.minmin.algorithmspass.chapter11_bit_operation;

public class Multiply {
    public static void main(String[] args) {
        System.out.println(multiply(16, 7));
    }
    public static int multiply(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int ans = 0;
        for (int i = 0; min != 0; i++) {
            // 如果是像7这样的数的话，在每一轮都会加上一个较小的值
            // 而如果是像8这样的值，会在指数级增长到最后才会加上
            if ((min & 1) == 1) {
                ans += max;
            }
            min >>= 1;
            // 这个是指数级上涨
            max += max;
        }
        return ans;
    }
}
