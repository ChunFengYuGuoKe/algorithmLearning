package com.minmin.algorithmspass.chapter11_bit_operation;

public class IsOne {
    // 判断数的第i位是否为1
    public boolean get(int num, int i) {
        return ((num & (1 << i)) != 0);
    }
}
