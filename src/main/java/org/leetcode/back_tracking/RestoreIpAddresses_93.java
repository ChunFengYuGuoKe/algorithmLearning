package org.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses_93 {
    List<String> validIps = new ArrayList<>();
    StringBuilder validIp = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return validIps;
        }
        bt(0, 0, s);
        return validIps;
    }

    private void bt(int startIndex, int count, String s) {
        if (startIndex == s.length()) {
            if (count == 4) {
                validIp.deleteCharAt(validIp.length() -1);
                validIps.add(new String(validIp));
                validIp.append('.');
                return;
            }
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (!isValid(substring)) continue;
            count++;
            validIp.append(substring);
            validIp.append(".");
            bt(i + 1, count, s);
            validIp.delete(validIp.length() - substring.length() - 1, validIp.length());
            count--;
        }
    }

    private boolean isValid(String s) {
        // 1. 多于一位的数不能以 0 开头
        if (s.length() > 1 && s.charAt(0) == '0') return false;

        // 2. 不能含数字以外的字符
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
            num = num * 10 + (s.charAt(i) - '0');
        }

        // 3. 数字不能大于 255 或小于 0
        if (num > 255 || num < 0) return false;
        return true;
    }


//    public static void main(String[] args) {
//
//    }
//
//    List<String> validIPs;
//    public List<String> restoreIpAddresses(String s) {
//        validIPs = new ArrayList<>();
//        if (s.length() > 12) {
//            return validIPs;
//        }
//        StringBuffer ipStr = new StringBuffer(s);
//        backtrack(ipStr, 0, 0);
//        return validIPs;
//    }
//
//    public void backtrack(StringBuffer ipStr, int pointNum, int startIndex) {
//        if (pointNum == 3) {
//            if (isValid(ipStr, startIndex, ipStr.length() - 1)) {
//                validIPs.add(ipStr.toString());
//            }
//        }
//        for (int i = startIndex; i < ipStr.length(); i++) {
//            if (isValid(ipStr, startIndex, i)) {
//                ipStr.insert(i, '.');
//                pointNum += 1;
//                backtrack(ipStr, pointNum, i + 2);
//                pointNum -= 1;
//                ipStr.deleteCharAt(i);
//            }
//        }
//    }
//
//    public boolean isValid(StringBuffer ipStr, int start, int end) {
//        if (start > end) {
//            return false;
//        }
//        if (ipStr.charAt(start) == '0' && start != end) {
//            return false;
//        }
//        int num = 0;
//        for (int i = start; i <= end; i++) {
//            if (ipStr.charAt(i) > '9' || ipStr.charAt(i) < '0') {
//                return false;
//            }
//            num = num * 10 + (ipStr.charAt(i) - '0');
//            if (num > 255) {
//                return false;
//            }
//        }
//        return true;
//    }
}
