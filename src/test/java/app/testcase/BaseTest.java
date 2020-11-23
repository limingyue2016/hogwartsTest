package app.testcase;

import app.page.App;
import app.page.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    public static MainPage mainPage;
    protected static App app;

    @BeforeAll
    static void beforeAll() {
        app = new App();
        mainPage = app.start();
    }

    @AfterAll
    static void afterAll() {
//        app.quit();
    }
}
