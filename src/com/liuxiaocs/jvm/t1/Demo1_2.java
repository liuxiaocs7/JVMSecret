package com.liuxiaocs.jvm.t1;

/**
 * 演示栈内存溢出: java.lang.StackOverflowError
 * -Xss256k
 */
public class Demo1_2 {
    private static int count;

    public static void main(String[] args) {
        try {
            method1();
        } catch (Throwable e) {
            e.printStackTrace();
            // java.lang.StackOverflowError
            // 22996
            System.out.println(count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }
}
