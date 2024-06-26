package com.minmin.algorithmspass.charpter7_tree_and_recurison.level1;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static int fibonacciByMyself(int n) {
        if (n <= 2) return 1;
        return fibonacciByMyself(n - 1) + fibonacciByMyself(n - 2);
    }

    public static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
