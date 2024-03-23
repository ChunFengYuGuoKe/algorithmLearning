package com.minmin.algorithmspass.charpter3_array.level2.topic2_5替换空格;

/**
 * 替换空格
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We are happy.");
        System.out.println(replaceSpace2ByMySelf(sb));
    }

    public static String replaceSpace2ByMySelf(StringBuffer str) {
        int blankCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                blankCnt++;
            }
        }
        int newLength = str.length() + blankCnt * 2;
        int slow = newLength - 1;
        int fast = str.length() - 1;
        char[] res = new char[newLength];
        char[] addition = {'%', '2', '0'};
        for(; fast >= 0; fast--) {
            if(str.charAt(fast) != ' ') {
                res[slow--] = str.charAt(fast);
            } else {
                for(int k = 2; k >= 0; k--) {
                    res[slow--] = addition[k];
                }
            }
        }
        return new String(res);
    }


    /**
     * 方法1：创建新的字符串
     *
     * @param str
     * @return
     */
    public static String replaceSpace1(StringBuffer str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ')
                res += "%20";
            else
                res += c;
        }
        return res;
    }

    /**
     * 方法2：在原数组基础上改
     *
     * @param str
     * @return
     */
    public static String replaceSpace2(StringBuffer str) {
        if (str == null)
            return null;
        int numOfblank = 0;//空格数量
        int len = str.length();
        for (int i = 0; i < len; i++) {  //计算空格数量
            if (str.charAt(i) == ' ')
                numOfblank++;
        }
        str.setLength(len + 2 * numOfblank); //设置长度
        int fast = len - 1;  //两个指针
        int slow = (len + 2 * numOfblank) - 1;

        while (fast >= 0 && slow > fast) {
            char c = str.charAt(fast);
            if (c == ' ') {
                fast--;
                str.setCharAt(slow--, '0');
                str.setCharAt(slow--, '2');
                str.setCharAt(slow--, '%');
            } else {
                str.setCharAt(slow, c);
                fast--;
                slow--;
            }
        }
        return str.toString();
    }
}
