package com.minmin.algorithmspass.chapter11_bit_operation;



public class FindDuplicatesIn32000 {
    public void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1;
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }

    // 封装int数组实现位集功能
    class BitSet {
        int[] bitset;

        // 初始化int数组
        public BitSet(int size) {
            bitset = new int[size >> 5];
        }


        // 为什么要通过wordNumber和bitNumber来更新位集
        // 因为数组支持按索引访问元素，但这是一个int数组
        // 每个int值占32位，所以当前位置除以32即是对应整数的索引
        // 而对32求余即为当前位在int中的偏移量
        boolean get(int pos) {
            int wordNumber = (pos >> 5);
            // 对32取模
            int bitNumber = (pos & 0x1F);
            return (bitset[wordNumber] |= 1 << bitNumber) != 0;
        }

        //
        void set(int pos) {
            int wordNumber = (pos >> 5);
            int bitNumber = (pos & 0x1F);
            bitset[wordNumber] |= 1 << bitNumber;
        }
    }
}
