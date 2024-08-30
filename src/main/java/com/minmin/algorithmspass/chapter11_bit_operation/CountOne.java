package com.minmin.algorithmspass.chapter11_bit_operation;

public class CountOne {

    // 通过对待操作的数进行右移然后与1相与进行判断
    public int countOneByNumRightMove(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (num >> i) & 1;
        }
        return count;
    }


    // 通过num & (num - 1)，每次会将num的最后一个1转化为零
    // 只要num!=0，count就+1
    public int countOneByNMinusOne(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
