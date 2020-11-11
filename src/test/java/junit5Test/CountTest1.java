package junit5Test;

import org.junit.jupiter.api.RepeatedTest;

public class CountTest1 {
    private Calculator1 calculator1 = new Calculator1();

    @RepeatedTest(10)
    void countTest1() {
        int result = calculator1.counts();
        System.out.println(result);
    }
}
