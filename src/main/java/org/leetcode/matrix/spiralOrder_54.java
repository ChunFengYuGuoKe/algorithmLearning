package org.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder_54 {
    /**
     * 这道题很巧妙的是它控制转向的机制
     * 就是用了四个循环，我最开始想的是不知道要写多少轮循环
     * 它里就是在一个控制结束条件的循环里，写了每一层的遍历逻辑
     * 这样它就会自己根据条件来结束循环
     *
     * 以及变量的设置也很有意义，用left、right、top、bottom表示相对静态一点的信息，即每一层的边界
     * 用row和column来表示动态信息，即当前遍历到哪一个元素了
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        int top = 0, left = 0, bottom = m - 1, right = n - 1;
        int cur = 0;
        while(left <= right && top <= bottom) {
            // 先是第一层，横着遍历直到边界，然后向下，然后向左，再向上
            // 问题是怎样转向，要写很多个if判断吗
            for(int column = left; column <= right; column++) {
                res.add(matrix[top][column]);
            }
            for(int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            // 这里的判断条件为什么更严格了，是为了什么目的？
            // 似乎是因为如果矩阵只有一行或一列的话，这里是在进行判断
            if(left < right && top < bottom) {
                for(int column = right - 1; column > left; column--) {
                    res.add(matrix[bottom][column]);
                }
                for(int row = bottom; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
