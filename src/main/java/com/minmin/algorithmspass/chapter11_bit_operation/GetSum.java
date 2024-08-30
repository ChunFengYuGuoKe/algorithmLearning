package com.minmin.algorithmspass.chapter11_bit_operation;

public class GetSum {
    public static void main(String[] args) {
        int sum = getSum(11, 7);
        System.out.println(sum);
    }
    public static int getSum(int a, int b) {
        while (b != 0) {
            int sign = (a & b) << 1;
            a = a ^ b;
            b = sign;
        }
        return a;
    }
}
