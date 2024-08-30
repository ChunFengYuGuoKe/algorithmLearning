package com.minmin.algorithmspass.chapter11_bit_operation;

public class UpdateBit {
    /**
     * 先将待更新的那一位设置为零，再与将更新的数做与操作
     * @param num   将被更新的数
     * @param i     更新的哪一个bit位
     * @param v     为将要更新的值，为1或0
     * @return      更新后的数
     */
    public int updateBit(int num, int i, int v) {
        int mask = ~(1 << i);
        return (num & mask) | (v << i);
    }
}
