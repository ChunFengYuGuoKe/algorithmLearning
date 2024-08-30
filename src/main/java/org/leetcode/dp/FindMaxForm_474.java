package org.leetcode.dp;

// 好耶，一遍过
public class FindMaxForm_474 {
    // 怎样定义dp数组，dp数组的含义是什么
    public int findMaxForm(String[] strs, int m, int n) {
        // i代表0，1代表1
        // 1. dp含义，dp[i][j]代表容量为i、j的最大子集数
        // 2. 递推公式，dp[i]][j] = max(dp[i - nums0][j - nums1] + 1, dp[i, j])
        // 3. 初始化，dp[0][j] = dp[0][j] >= strs[0] ? 1 : 0;
        /**
         * 4. 遍历顺序，从左到右，从上到下，错了，应该是从右下到左上，这个虽然是二维数组，但它其实仍然是滚动数组，
         * 每一轮的数据代表考虑当前物品的结果，由于是01背包问题，一个物品不能加入多次，所以只能从大到小遍历
         */
        int[][] dp = new int[m + 1][n + 1];
        // int[][] strInfo = new int[strs.length][2];
        // 统计字符串数组信息
//        for (int i = 0; i < strs.length; i++) {
//            for (int j = 0; j < strs[i].length(); j++) {
//                if (strs[i].charAt(j) == '0') {
//                    strInfo[i][0]++;
//                } else {
//                    strInfo[i][1]++;
//                }
//            }
//        }
        // 初始化dp，纵向第一列
//        for (int i = 1; i <= m; i++) {
//            if (strInfo[0][1] == 0 && strInfo[0][0] <= i) dp[i][0] = 1;
//        }
//        for (int j = 1; j <= n; j++) {
//            if (strInfo[0][0] == 0 && strInfo[0][1] <= j) dp[0][j] = 1;
//        }
        for (String str : strs) {
            int cnt0 = 0;
            int cnt1 = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
            for (int i = m; i >= cnt0; i--) {
                for (int j = n; j >= cnt1; j--) {
                    dp[i][j] = Math.max(dp[i - cnt0][j - cnt1] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
}
