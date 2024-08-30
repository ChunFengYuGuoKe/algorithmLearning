package org.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations_17 {
//    char[][] map = {{'a', 'b', 'c'},
//                    {'d', 'e', 'f'},
//                    {'g', 'h', 'i'},
//                    {'j', 'k', 'l'},
//                    {'m', 'n', 'o'},
//                    {'p', 'q', 'c'},
//                    {'a', 'b', 'c'},
//                    {'a', 'b', 'c'}};
    private final StringBuilder path = new StringBuilder();
    private final List<String> result = new ArrayList<>();

    static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return result;
        bt(0, digits);
        return result;
    }

    private void bt(int index, String digits) {
        if (path.length() == digits.length()) {
            result.add(new String(path));
            return;
        }
        Character num = digits.charAt(index);
        String letter = map.get(num);
        for (int i = 0; i < letter.length(); i++) {
            path.append(letter.charAt(i));
            bt(index + 1, digits);
            path.deleteCharAt(index);
        }
    }
}
