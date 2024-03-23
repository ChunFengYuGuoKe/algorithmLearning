package org.leetcode.matrix;

public class SearchMatrix_240 {
    // 1.先判断当前元素是否是target
// 2.先沿着一个方向寻找，将当前位置的下一个元素与target进行判断。
// 当target大于这个元素时，继续前移，如果，target小于这个元素，如果target大于另一个方向的下一个元素，就换方向
// 换方向之后到再次大于下一个元素时，再次判断另一个方向的元素比target大之后再换方向
// 如此往复


    public boolean searchMatrix(int[][] matrix, int target) {
        // int right = matrix[0].length;
        // int bottom = matrix.length;
        // int row = 0, col = 0;
        // boolean flag = false;
        // while(row < right || col < bottom) {
        //     if(target == matrix[row][col]) {
        //         flag = true;
        //     }
        //     if(matrix[row + 1][col] > target && matrix[row][col + 1] > target) {
        //         break;
        //     }
        //     if(col < right && matrix[row][col + 1] <= target) {
        //         col++;
        //     }
        //     if(row < bottom && matrix[row + 1][col] <= target) {
        //         row++;
        //     }
        //     while(col < right && matrix[row][col + 1] <= target) {
        //         col++;
        //     }
        //     while(row < bottom && matrix[row + 1][col] <= target) {
        //         row++;
        //     }
        // }
        // return flag;

        int n = matrix[0].length;
        int m = matrix.length;
        int x = 0, y =  n - 1;
        while(x < m && y >= 0) {
            if(matrix[x][y] == target) {
                return true;
            }
            if(matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
            // 为什么下面这种写法是错的？因为每次移动了下标都需要重新判断是否超界，而这部分判断时放在循环控制条件里的
            // if(matrix[x][y] > target) {
            //     y--;
            // }
        }
        return false;
    }
}
