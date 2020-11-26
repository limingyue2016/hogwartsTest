package com.wework.common;

import com.wework.app.AddressBook;
import com.wework.app.AddressBookPage;
import com.wework.core.App;
import com.wework.core.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static App app;
    public static MainPage mainPage;
    public static AddressBookPage addressBookPage;
    public static AddressBook addressBook;

    @BeforeAll
    static void beforeAll() {
        app = new App();
        mainPage = app.start();
//        addressBookPage = mainPage.ToAddressBook();
        addressBook = mainPage.ToAddressBookFramework();
    }

    @AfterAll
    static void afterAll() {
//        app.quit();
    }
}
