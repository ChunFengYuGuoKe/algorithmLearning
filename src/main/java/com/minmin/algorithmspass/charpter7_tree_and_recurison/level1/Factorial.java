package com.minmin.algorithmspass.charpter7_tree_and_recurison.level1;

/**
 * 阶乘计算
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorialByMyself(int n) {
        if (n <= 1) return 1;
        return factorialByMyself(n - 1) * n;
    }

    public static int factorial(int n) {
        if (n == 1) {
            return n;
        }
        return factorial(n - 1) * n;
    }

}
