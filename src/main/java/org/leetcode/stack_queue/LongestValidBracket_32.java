package org.leetcode.stack_queue;

import java.util.Stack;

public class LongestValidBracket_32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()((())())"));
    }

    public static int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
        Stack<Integer> stack = new Stack<>();
        // Deque<Integer> stack = new LinkedList<>();
        // 这样也可以，LinkedList实现了栈相关的api
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
