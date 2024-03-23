package org.leetcode.hash;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */

public class AlphabeticAnagramsGrouping_49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // 使用hssh解题的通用思路，预处理提取共同特征，把特征作为键，之为待处理元素
            // 如果希望根据特征分类，可以将值设置为一个集合，每次网集合中添加元素


            // 思路：字母异位词的特点是字母是一样的，只是字母的顺序不同
            // 而如果要直接一个个字母来比较，那就太麻烦了，所以先排序，
            // 然后使用hash来根据特征来从已有的数据中查找，hash查找的复杂度始终是O(1)
            // 如果有，就取出对应的list，往里面加上新的字符串再放回去，
            // 如果没有，就新创建一个list，并将排好序的字符串作为key一起存进hash表
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            for(String str : strs) {
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                String key = new String(arr);
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }
}
