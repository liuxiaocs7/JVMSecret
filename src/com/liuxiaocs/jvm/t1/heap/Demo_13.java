package com.liuxiaocs.jvm.t1.heap;

import java.util.ArrayList;

/**
 * 演示查看对象个数 堆转储 dump
 * <p>
 * 将内存快照抓取下来，分析内存占用最大的对象
 */
public class Demo_13 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
        }
        Thread.sleep(1000000000L);
    }
}

class Student {
    private byte[] big = new byte[1024 * 1024];
}