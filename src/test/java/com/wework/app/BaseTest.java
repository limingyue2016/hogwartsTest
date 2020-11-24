package com.wework.app;

import com.wework.app.MainPage;
import com.wework.app.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    public static MainPage mainPage;
    protected static App app;
    public static AddressBookPage addressBookPage;

    @BeforeAll
    static void beforeAll() {
        app = new App();
        mainPage = app.start();
        addressBookPage = mainPage.ToAddressBook();
    }

    @AfterAll
    static void afterAll() {
//        app.quit();
    }
}
