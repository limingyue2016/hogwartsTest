package com.junit5;

/**
 * 1 线程安全问题修复之Synchronized
 */
public class Calculator1 {
    public static int count;

    public static int add(int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static int divide(int x, int y) {
        return x / y;
    }

    public static int counts() {
        synchronized (Calculator1.class) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return count++;
        }
    }
}
