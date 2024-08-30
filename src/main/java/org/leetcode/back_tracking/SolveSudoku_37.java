package org.leetcode.back_tracking;

import java.util.HashSet;
import java.util.Set;

public class SolveSudoku_37 {
//    Set<Integer>[][] latticesSet = new HashSet[3][3];
//    Set<Integer>[] rowSet = new HashSet[9];
//    Set<Integer>[] colSet = new HashSet[9];

    public void solveSudoku(char[][] board) {
        bt(board);
    }

    private boolean bt(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(i, j, (char) ('0' + k), board)) {
                            board[i][j] = (char) ('0' + k);
                            boolean flag = bt(board);
                            if (flag) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char value, char[][] board) {
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (board[i][j] == value) return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (value == board[i][col]) return false;
        }
        for (int j = 0; j < 9; j++) {
            if (value == board[row][j]) return false;
        }
        return true;
    }

//    private void putIntoSets(int row, int col, int value, int[][] board) {
////        latticesSet[row % 3][col % 3].
//
//    }
}
