package org.leetcode.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class LongestSubstringWithoutRepeatedCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> exist = new HashSet<Character>();
        int n = s.length();
        int right = -1, ans = 0;
        // 左右两个指针都分别只需要遍历一次即可，为什么？左指针好理解
        // 右指针其实在第一次到达一个地方之后就不用动了，只要左指针还落后于它
        // 只有当左指针追上来之后才会再次行动，右指针并不是每次都从头开始的
        for(int i = 0; i < n; i++) {
            if(i != 0) {
                exist.remove(s.charAt(i - 1));
            }

            while(right + 1 < n && !exist.contains(s.charAt(right + 1))) {
                exist.add(s.charAt(right + 1));
                right++;
            }
            // 为什么是rk - i + 1，举个例子就知道了，4——5总共是几个数？两个，但是为什么5-4=1？
            // 因为4这个数没有算进去，只是他们俩之间的差值
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}
