package junit5Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1 线程安全问题修复之java.util.concurrent.atomic
 */
public class Calculator {
    public static AtomicInteger count = new AtomicInteger(0);

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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count.incrementAndGet();
    }
}
