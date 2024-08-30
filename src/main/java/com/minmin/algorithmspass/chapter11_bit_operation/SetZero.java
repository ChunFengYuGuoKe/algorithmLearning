package com.minmin.algorithmspass.chapter11_bit_operation;

public class SetZero {
    public int setZero(int num, int i) {
        // 获取除i位以外全为零的数
        int mask = ~(i << i);
        // 将掩码与操作数做与操作
        return num & mask;
    }
}
