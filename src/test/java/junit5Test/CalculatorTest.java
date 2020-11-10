package junit5Test;

import junit5Test.BaseCase;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(JUnitPlatform.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest extends BaseCase {
    private Calculator calculator = new Calculator();

    @Test
    @Disabled
    void testCalculator() {
        assertAll("testCalculator",
                () -> assertEquals(calculator.add(1, 1), 2),
                () -> assertEquals(calculator.subtract(1, 1), 0),
                () -> assertEquals(calculator.multiply(1, 1), 1),
                () -> assertEquals(calculator.divide(1, 1), 1),
                () -> assertEquals(calculator.count, 4));

    }

    @Test
    @Order(4)
    @Tag("calculator")
    void testAdd() {
        assertEquals(calculator.add(1, 1), 2);
    }

    @Test
    @Order(3)
    @Tag("calculator")
    void testSubtract() {
        assertEquals(calculator.subtract(1, 1), 0);
    }

    @Test
    @Order(2)
    @RepeatedTest(3)
    void testMultiply() {
        assertEquals(calculator.multiply(1, 1), 1);
    }

    @Test
    @Order(1)
    void testDivide() {
        assertEquals(calculator.divide(1, 1), 1);
    }

}
