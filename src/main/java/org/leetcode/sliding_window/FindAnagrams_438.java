package org.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class FindAnagrams_438 {
    public static void main(String[] args) {

    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if(sLen < pLen) return new ArrayList<Integer>();

        List<Integer> ans = new ArrayList<Integer>();
        // 构造两个用于比较的桶数组
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        /**
         * 初始化滑动窗口
         * 窗口指的两个数组下标
         * 两个数组适用于辅助窗口之间的元素比较的，这里其实有一个映射关系
         * 这样就可以在不变动原数组的情况下，进行比较
         * 更重要的作用是，采用滑动窗口，更新窗口就只用更新前端和后端的元素了
         *
         * 以及这里建立这样一个字母映射的作用是让字符自己的asc码决定它该去哪里，这样在如果包含的字符一样，
         * 那么就一定是在相同的位置，并且是以相同的顺序，很巧妙
         */

        for(int i = 0; i < pLen; i++) {
            ++pCount[p.charAt(i) - 'a'];
            ++sCount[s.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            /**
             * 减去左边的元素，加上右边的元素
             */
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if(Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
