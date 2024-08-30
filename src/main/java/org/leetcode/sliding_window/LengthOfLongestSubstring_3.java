package org.leetcode.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        // 1. 声明、定义用于保存当前窗口内字符的set
        // 在不同的题目中用于保存窗口特征的可能是不同的数据类型，但万变不离其宗
        Set<Character> set = new HashSet<Character>();

        // 2. 声明、定义窗口的左右边界，以及结果变量
        int l = 0, r = 0;
        int len = 0;

        // 3. 滑动窗口进行运算
        while (r < s.length()) {
            // 第一版是这样写的，错了
            // if (!set.contains(s.charAt(r))) {
            //     set.add(s.charAt(r));
            // }

            // 3.1 如果当前窗口内包含有边界位置的字符，则一直移动左边界，直到没有重复字符
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            // 3.2 更新set操作，将右边界字符添加进去
            // 第二版把更新set的操作放在了左边界右移的操作后面
            set.add(s.charAt(r));

            // 3.3 动态更新结果
            len = Math.max(len, r - l + 1);

            // 3.4 右边界向右滑动
            r++;
        }
        return len;
    }

}
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Set<Character> exist = new HashSet<Character>();
//         int n = s.length();
//         int right = -1, ans = 0;
//         // 左右两个指针都分别只需要遍历一次即可，为什么？左指针好理解
//         // 右指针其实在第一次到达一个地方之后就不用动了，只要左指针还落后于它
//         // 只有当左指针追上来之后才会再次行动，右指针并不是每次都从头开始的
//         for(int i = 0; i < n; i++) {
//             if(i != 0) {
//                 exist.remove(s.charAt(i - 1));
//             }

//             while(right + 1 < n && !exist.contains(s.charAt(right + 1))) {
//                 exist.add(s.charAt(right + 1));
//                 right++;
//             }
//             // 为什么是rk - i + 1，举个例子就知道了，4——5总共是几个数？两个，但是为什么5-4=1？
//             // 因为4这个数没有算进去，只是他们俩之间的差值
//             ans = Math.max(ans, right - i + 1);
//         }
//         return ans;
//     }
// }