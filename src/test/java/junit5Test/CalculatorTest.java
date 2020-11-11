package junit5Test;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(JunitPlatform.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("DisplayName")
@Epic("计算器测试用例")
@Feature("计算器功能测试用例")
@Link("https://github.com/")
@Link(name = "github", type = "mylink")
public class CalculatorTest extends BaseCase {
    private Calculator calculator = new Calculator();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    void calculatorTest() {
        assertAll("testCalculator",
                () -> assertEquals(calculator.add(1, 1), 2),
                () -> assertEquals(calculator.subtract(1, 1), 0),
                () -> assertEquals(calculator.multiply(1, 1), 1),
                () -> assertEquals(calculator.divide(1, 1), 1));

    }

    @Test
    @Order(4)
    @Tag("calculator")
    @Severity(SeverityLevel.CRITICAL)
    @Description("description")
    @Story("加法")
    void addTest() {
        assertEquals(calculator.add(1, 1), 2);
    }

    @Test
    @Order(3)
    @Tag("calculator")
    @Story("减法")
    void subtractTest() {
        assertEquals(calculator.subtract(1, 1), 0);
    }

    @Order(2)
    @RepeatedTest(3)
    @Story("乘法")
    void multiplyTest() {
        assertEquals(calculator.multiply(1, 1), 1);
    }

    @Test
    @Order(1)
    @Issue("Issue1")
    @Story("除法")
    @TmsLink("https://github.com/")
    void divideTest() {
        assertEquals(calculator.divide(1, 1), 1);
    }

}
