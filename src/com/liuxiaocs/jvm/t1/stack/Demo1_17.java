package com.liuxiaocs.jvm.t1.stack;

/**
 * 局部变量的线程安全问题
 */
public class Demo1_17 {
    public static void main(String[] args) {
        // 主线程修改StringBuilder对象
        StringBuilder sb = new StringBuilder();
        sb.append(4);
        sb.append(5);
        sb.append(6);

        // 子线程同时修改StringBuilder对象
        new Thread(() -> {
            m2(sb);
        }).start();
    }

    // 不会有线程安全问题
    // sb是线程内的局部变量，是属于每个线程私有的
    // 其他线程不可能同时访问到这个StringBuilder对象，所以它一定是线程安全的
    public static void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    // 有可能多个线程都能访问到sb这个对象
    // 多个线程共享同一个对象，因此不是线程安全的
    // 不能使用StringBuilder了，需要改写成StringBuffer的实现
    public static void m2(StringBuilder sb) {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    // 其他对象有可能拿到返回的这个对象的引用并发的去修改它造成线程安全的问题
    public static StringBuilder m3() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }
}
