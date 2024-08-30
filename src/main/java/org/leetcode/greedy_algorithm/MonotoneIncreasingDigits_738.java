package org.leetcode.greedy_algorithm;

public class MonotoneIncreasingDigits_738 {
    // 错误解法
    public int monotoneIncreasingDigits(int n) {
        String s = Integer.toString(n);
        int l = s.length();
        int flag = l;
        for (int i = 0; i < l - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                int temp = i;
                while (temp > 0 && s.charAt(temp) == s.charAt(temp - 1)) {
                    temp--;
                }
                flag = temp;
                break;
            }
        }

        return 0;
    }

    public int monotoneIncreasingDigits1(int n) {
        char[] strNum = Integer.toString(n).toCharArray();
        int l = strNum.length;
        int flag = l;
        for (int i = l - 1; i > 0; i--) {
            if (strNum[i - 1] > strNum[i]) {
                flag = i;
                strNum[i - 1]--;
            }
        }
        for (int i = flag; i < strNum.length; i++) {
            strNum[i] = '9';
        }
        return Integer.parseInt(new String(strNum));
    }
}
