package org.leetcode.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBraces {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(')');
            else if (s.charAt(i) == '{') stack.push('}');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (stack.isEmpty() || stack.peek() != s.charAt(i)) return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }
}
