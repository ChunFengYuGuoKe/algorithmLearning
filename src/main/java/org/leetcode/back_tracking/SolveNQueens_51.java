package org.leetcode.back_tracking;

import java.util.*;

public class SolveNQueens_51 {
    public static void main(String[] args) {
        SolveNQueens_51 solveNQueens51 = new SolveNQueens_51();
        List<List<String>> nQueens = solveNQueens51.solveNQueens(4);
        System.out.println(nQueens);
    }

    List<String> board = new ArrayList<>();
    List<List<String>> boards = new ArrayList<>();
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> lToRSet = new HashSet<>();
    Set<Integer> rToLSet = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        bt(0, n);
        return boards;
    }

    private void bt(int row, int n) {
        if (board.size() == n) {
            boards.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                colSet.add(col);
                lToRSet.add(row - col);
                rToLSet.add(row + col);
                board.add(generateRow(col, n));
                bt(row + 1, n);
                board.remove(board.size() - 1);
                colSet.remove(col);
                lToRSet.remove(row - col);
                rToLSet.remove(row + col);
            }
        }
    }

    private boolean isValid(int row, int col) {
        return !this.colSet.contains(col) && !lToRSet.contains(row - col) && !rToLSet.contains(row + col);
    }

    private String generateRow(int col, int n) {
        char[] rowStr = new char[n];
        Arrays.fill(rowStr, '.');
        rowStr[col] = 'Q';
        return new String(rowStr);
    }
}
