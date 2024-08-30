package org.leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    public static void main(String[] args) {
        WordBreak_139 wordBreak139 = new WordBreak_139();
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordBreak139.wordBreak(s, wordDict);
    }

    // 错误写法，应该用set来判断，跟一般的dp不一样
    public boolean wordBreak1(String s, List<String> wordDict) {
        // dp
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < wordDict.size(); i++) {
            for (int j = wordDict.get(i).length(); j <= s.length(); j++) {
//                dp[j] = s.endsWith(wordDict.get(i)) && dp[j - wordDict.get(i).length()];
                dp[j] = s.startsWith(wordDict.get(i), j - wordDict.get(i).length() - 1) && dp[j - wordDict.get(i).length()];
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // dp
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int j = 1; j <= s.length(); j++) { // 遍历背包
            for (int i = 0; i < j; i++) { // 遍历物品
                if (wordSet.contains(s.substring(i, j)) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
