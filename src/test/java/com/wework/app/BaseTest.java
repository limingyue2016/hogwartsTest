package com.wework.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static App app;
    public static MainPage mainPage;
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
