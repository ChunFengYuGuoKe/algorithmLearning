package com.minmin.algorithmspass.chapter11_bit_operation;

public class ReverseBit {
    public static void main(String[] args) {
        int reversed = reverseBit(2147483644);
        System.out.println(reversed);
    }

    // 这种方法是有问题的，因为它只会左移，导致右边的低16位始终为零
    public static int reverseBit(int num) {
        int mask = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cur = (num & mask);
            int curNum = cur << (31 - 2 * i);
            res += cur;
            mask <<= 1;
        }
        return res;
    }

    // you need treat n as an unsigned value
    // public int reverseBits(int n) {
    //     int mask = 1;
    //     int res = 0;
    //     int power = 31;
    //     for (int i = 0; i < 32; i++) {
    //         // int cur = (n & mask) << (31 - 2 * i);
    //         // res = res + cur;
    //         // System.out.println("n & mask=" + (n & mask));
    //         // System.out.println("cur=" + res);
    //         // System.out.println("res=" + res);
    //         // System.out.println("mask=" + mask);
    //         // mask = mask << 1;
    //         res += ((n >>> i) & mask) << power;
    //         power--;
    //     }
    //     return res;
    // }

    public int reverseBits(int n) {
        // 颠倒16位
        n = (n >>> 16) | (n << 16);
        // 每8位为一个块，进行颠倒
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}
