package org.leetcode.matrix;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class SetZeroes_73 {
    public void setZeroes(int[][] matrix) {
        // 思路是什么？
        // 先遍历，找到0了就把那一行那一列的元素都设置为零
        // 之后再遇到这个行这个列的时候就continue

        // 题解的思路是用两个bool数组分别标记行和列的状态
        // 第一遍遍历更新这些状态，第二遍遍历再根据结果来对矩阵设值
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        // 为什么不能一次遍历实现，因为一次遍历就要兼顾标记和设值，实在是有点难搞
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
