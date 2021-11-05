package com.liuxiaocs.jvm.t1.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示内存溢出
 * -Xmx8m
 *
 * java.lang.OutOfMemoryError: Java heap space
 */
public class Demo1_5 {

    public static void main(String[] args) {
        int i = 0;
        try {
            // list不能被垃圾回收掉
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
