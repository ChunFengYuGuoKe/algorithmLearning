package org.leetcode.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN_150 {
    public static void main(String[] args) {
        EvalRPN_150 evalRPN150 = new EvalRPN_150();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int i = evalRPN150.evalRPN(tokens);
        System.out.println(i);
    }
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isOP(token)) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = cal(token, num1, num2);
                stack.push(Integer.toString(res));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public boolean isOP(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public int cal(String token, int num1, int num2) {
        return switch (token) {
            case "+" -> num2 + num1;
            case "-" -> num2 - num1;
            case "*" -> num2 * num1;
            case "/" -> num2 / num1;
            default -> throw new RuntimeException();
        };
    }
}
