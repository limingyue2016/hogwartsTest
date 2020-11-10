package junit5Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseCase {
    @BeforeAll
    static void beforeAllTest() {
        System.out.println("beforeAllTest");
    }

    @AfterAll
    static void afterAllTest() {
        System.out.println("afterAllTest");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("beforeEachTest");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("afterEachTest");
    }
}
