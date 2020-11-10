package junit5Test;

public class Calculator {
    public static int count;

    public static int add(int x, int y) {
        count++;
        return x + y;
    }

    public static int subtract(int x, int y) {
        count++;
        return x - y;
    }

    public static int multiply(int x, int y) {
        count++;
        return x * y;
    }

    public static int divide(int x, int y) {
        count++;
        return x / y;
    }
}
