package junit5Test;

import org.junit.jupiter.api.RepeatedTest;

public class CountTest{
    private Calculator calculator = new Calculator();

    @RepeatedTest(10)
    void countTest(){
        int result = calculator.counts();
        System.out.println(result);
    }
}
