package org.leetcode.matrix;

public class Rotate_48 {
    // 怎么在不创建一个新的矩阵的情况下，将矩阵中的元素换位？

// 这道题也很巧妙，经过了一个等式循环代换，结果达到了一个循环交换的结果
// 这样就只用保存最开始的那个被覆盖掉的变量即可

    // 为什么要这样分区？分成四个分区
// 因为每个分区对应的元素是一轮交换中的四个元素
// 对奇数和偶数的区别对待也很有意思
    public void rotate(int[][] matrix) {
        // 辅助数组是干什么的，保存马上要被替换掉的元素？貌似是不行
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
