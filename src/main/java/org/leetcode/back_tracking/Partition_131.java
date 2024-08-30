package org.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Partition_131 {
    List<String> partition = new ArrayList<>();
    List<List<String>> partitions = new ArrayList<>();

    public List<List<String>> partition(String s) {
        bt(0, s);
        return partitions;
    }

    public void bt(int startIndex, String s) {
        if (startIndex == s.length()) {
            partitions.add(new ArrayList<>(partition));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome(s.substring(startIndex, i + 1))) continue;
            partition.add(s.substring(startIndex, i + 1));
            bt(i + 1, s);
            partition.remove(partition.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
