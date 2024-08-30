package com.minmin.algorithmspass.chapter11_bit_operation;

public class CountOneOfArray {
    public int[] countOnes(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            // 统计每个数的1的个数
            int count = 0;
            while (i != 0) {
                i &= i - 1;
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}
